package org.wikipedia.lesson21.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson19.homework.CommonMenuButtons.moreButton
import org.wikipedia.lesson19.homework.CommonMenuButtons.settingsButton
import org.wikipedia.lesson21.homework.SettingsScreenHW.blockWithCheckBox
import org.wikipedia.lesson21.homework.SettingsScreenHW.blockWithIcon
import org.wikipedia.main.MainActivity

class HomeworkTest : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSettingsScenario() {
        run {
            action.click(OnboardingScreen.skip)
            action.click(moreButton)
            action.click(settingsButton)

            blockWithCheckBox(1) {
                action.setCheckedTrue(switch)
                verify.isChecked(switch)
            }

            blockWithIcon(2) {
                verify.containsText(title, "Terms of use")
            }

        }
    }
}
