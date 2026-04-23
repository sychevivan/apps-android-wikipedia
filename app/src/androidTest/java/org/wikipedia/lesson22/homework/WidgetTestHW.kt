package org.wikipedia.lesson22.homework

import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson13.homework.ArticleScreen
import org.wikipedia.lesson13.homework.GameScreen
import org.wikipedia.lesson18.homework.ExploreScreenHW
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.main.MainActivity


class WidgetTestHW : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun fontSettingsWidgetTest() {
        run {
            action.click(OnboardingScreen.skip)
            ExploreScreenHW.featuredArticle(0) {
                action.click(articleDescription)
            }
            action.click(GameScreen.close)
            action.click(ArticleScreen.pageTheme)

            SettingsBottomSheetScreen.fontSettingsWidget {
                verify.isDisplayed(this)
                action.click(buttonIncreaseTextSize)
                verify.containsText(textSizePercent, "110%")
                action.click(buttonDecreaseTextSize)
                action.click(buttonDecreaseTextSize)
                verify.containsText(textSizePercent, "90%")
            }
        }
    }

    @Test
    fun themeSettingsWidgetTest() {
        run {
            action.click(OnboardingScreen.skip)
            ExploreScreenHW.featuredArticle(0) {
                action.click(articleDescription)
            }
            action.click(GameScreen.close)
            action.click(ArticleScreen.pageTheme)

            SettingsBottomSheetScreen.themeSettingsWidget {
                verify.isDisplayed(this)

                action.setCheckedFalse(themeChooserMatchSystemThemeSwitch)
                verify.isEnabled(buttonThemeBlack)
                verify.isEnabled(buttonThemeDark)

                action.setCheckedTrue(themeChooserMatchSystemThemeSwitch)
                verify.isDisabled(buttonThemeBlack)
                verify.isDisabled(buttonThemeDark)
            }
        }
    }

}