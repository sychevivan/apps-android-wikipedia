package org.wikipedia.lesson24.homework

import androidx.compose.ui.test.click
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.components.composesupport.config.ComposeConfig
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.compose.node.element.ComposeScreen.Companion.onComposeScreen
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson24.AddLanguageScreen
import org.wikipedia.main.MainActivity

class ComposeTestSimple :
    TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        ComposeConfig.Builder.default(this) {}
    }) {

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @get:Rule(order = 2)
    val kakaoRule = KakaoComposeTestRule(composeTestRule, true)

    @Test
    fun composeTest() {
        run {
            OnboardingScreen.page(0) {
                action.click(addLanguages)
            }
            action.click(MyLanguagesScreen.addLanguages)

            AddLanguageScreen {
                itemWithText("Deutsch") {
                    verify.assertTrimmedTextIsEquals(canonicalName, "немецкий")
                    verify.assertTrimmedTextIsEquals( localName, "Deutsch")
                    action.clickIfEnabled(canonicalName)
                }
            }

            action.click(OnboardingScreen.backToolbarButton)

            OnboardingScreen.page(0) {
                languagesBlockByIndex(2){
                    verify.hasText(this, "3.\t\tDeutsch")
                }
            }
        }
    }
}