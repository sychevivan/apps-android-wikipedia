package org.wikipedia.lesson23

import io.github.kakaocup.kakao.web.KWebView

class ReferencesItem(kWebView: KWebView, listContainerXpath: String) :
    KWebViewItem(kWebView, listContainerXpath) {

    override val self: KWebViewItem = this

    val index by lazy{
        child("//a[@class='pcs-ref-back-link']")
            .name(withParent("index"))
    }

    val text by lazy {
        child("//div[@class='pcs-ref-body']")
            .name(withParent("Текст"))
    }
}