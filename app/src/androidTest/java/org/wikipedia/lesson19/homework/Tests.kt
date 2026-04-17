package org.wikipedia.lesson19.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.OnboardingScreen
import org.wikipedia.lesson18.homework.ExploreScreenHW
import org.wikipedia.lesson19.homework.CommonMenuButtons
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.main.MainActivity

class Tests : TestCase(
    Kaspresso.Builder.withForcedAllureSupport()
) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun topReadImageIsDisplayed() {
        run {
            action.click(OnboardingScreen.skipButton)

            ExploreScreenHW.topReadBlock {
                cardListItem(2) {
                    verify.isDisplayed(cardImage)
                }
            }
        }
    }

    @Test
    fun switchIsOff() {
        run {
            action.click(OnboardingScreen.skipButton)
            action.click(CommonMenuButtons.moreButton)
            action.click(CommonMenuButtons.settingsButton)

            SettingsScren.settingsItem("Show link previews") {
                showLinkPreviewsSwitch {
                    action.setCheckedTrue(this)
                    action.click(this)
                    verify.isNotChecked(this)
                }
            }
        }
    }
}