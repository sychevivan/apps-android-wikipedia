package org.wikipedia.lesson22

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.ExploreScreenHW
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.main.MainActivity

class WidgetTest : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkWidget() {
        run {
            action.click(OnboardingScreen.skip)
            verify{
                ExploreScreenHW.searchWidget{
                    isDisplayed(this)
                    isDisplayed(searchIcon)
                    hasText(searchField, "Поиск по Википедии")
                    isDisplayed(micIcon)
                }
            }
        }
    }

}