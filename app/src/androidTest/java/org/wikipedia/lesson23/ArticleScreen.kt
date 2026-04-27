package org.wikipedia.lesson23

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen

object ArticleScreen : NamedScreen<ArticleScreen>() {
    override val screenName: String = "Экран статьи"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

    // val title by lazy {
    //     KWebViewElement(
    //         webView, "//h1"
    //     ).name(withParent("Заголовок статьи"))
    // }

    val title by lazy {
        webView.withXPath("//h1")
            .name(withParent("Заголовок статьи"))
    }

    val references by lazy {
        webView.withXPath("//*[@id=\"References\"]")
            .name(withParent("Блок References"))
    }

    val referencesList by lazy {
        KWebViewList(
            webView, "//ol"
        ).name(withParent("Список ссылок в блоке References"))
    }

    fun referencesItem(index:Int, fnc: ReferencesItem.() -> Unit) {
        referencesList.childAt(index, fnc)
    }
}