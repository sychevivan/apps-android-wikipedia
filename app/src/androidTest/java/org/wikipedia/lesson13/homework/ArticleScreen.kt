package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson18.name

object ArticleScreen : NamedScreen<ArticleScreen>() {
    override val layoutId = null
    override val viewClass = null
    override val screenName: String = "Страница статьи"

    val webView = KWebView{
        withId(R.id.page_web_view)
    }

    val pageTheme by lazy {
        KTextView{
            withId(R.id.page_theme)
        }.name(withParent("Кнопка настройки темы"))
    }

    val readArticleButton = KButton{
        withId(R.id.link_preview_primary_button)
    }

}