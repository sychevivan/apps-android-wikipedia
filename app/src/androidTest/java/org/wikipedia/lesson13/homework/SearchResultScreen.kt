package org.wikipedia.lesson13.homework

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

object SearchResultScreen : UiScreen<SearchResultScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val putin = UiButton {
        withText("Vladimir Putin")
    }
}