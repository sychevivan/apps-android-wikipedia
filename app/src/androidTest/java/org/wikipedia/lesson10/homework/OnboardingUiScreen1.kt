package org.wikipedia.lesson10.homework

import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen1 : UiScreen<OnboardingUiScreen1>() {

    override val packageName = "org.wikipedia.alpha"

    val continueButton = UiButton {
        withId(this@OnboardingUiScreen1.packageName, "fragment_onboarding_forward_button")
    }

    val skip = UiButton {
        withId(this@OnboardingUiScreen1.packageName, "fragment_onboarding_skip_button")
    }

    val primaryTextView = UiTextView{
        withId(this@OnboardingUiScreen1.packageName, "primaryTextView")
    }

    val secondaryTextView = UiTextView{
        withId(this@OnboardingUiScreen1.packageName, "secondaryTextView")
    }

    val optionLabel = UiTextView{
        withId(this@OnboardingUiScreen1.packageName, "option_label")
    }

    val fragmentPager = UiScrollView {
        withId(this@OnboardingUiScreen1.packageName, "fragment_pager")
    }
}