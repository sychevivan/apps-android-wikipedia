package org.wikipedia.lesson23

import io.github.kakaocup.kakao.web.KWebView

fun KWebView.withXPath(xPath: String): KWebViewElement {
    return KWebViewElement(
        this, xPath
    )
}