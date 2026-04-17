package org.wikipedia.lesson20

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.OnboardingScreen
import org.wikipedia.lesson18.homework.ExploreScreenHW
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.main.MainActivity

class TestExample : TestCase(
    Kaspresso.Builder.withForcedAllureSupport()
) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun multiActionTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
        }
    }

    @Test
    fun assertionTest() {
        run {
            OnboardingScreen.page(1) {
                title.equalsWithTrim("New ways to explore")
            }
        }
    }
}