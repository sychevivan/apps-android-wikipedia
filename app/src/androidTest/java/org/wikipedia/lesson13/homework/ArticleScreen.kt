package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object ArticleScreen : KScreen<ArticleScreen>() {
    override val layoutId = null
    override val viewClass = null

    val webView = KWebView{
        withId(R.id.page_web_view)
    }

    val readArticleButton = KButton{
        withId(R.id.link_preview_primary_button)
    }
}