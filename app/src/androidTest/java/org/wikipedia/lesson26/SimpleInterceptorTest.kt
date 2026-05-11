package org.wikipedia.lesson26

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.interceptors.step.ScreenshotStepInterceptor
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.main.MainActivity


class SimpleInterceptorTest : TestCase(
    // kaspressoBuilder = Kaspresso.Builder.advanced().apply {
        // viewBehaviorInterceptors.add(BeforeAfterBehaviorInterceptor())
        // viewActionWatcherInterceptors.add(MyViewActionInterceptor())
        // viewAssertionWatcherInterceptors.add(MyViewAssertionInterceptor())
        // viewBehaviorInterceptors.add(TestTimeInterceptor())
    // }

    // скриншоты не будут создаваться, так как удалили интерцептор
    Kaspresso.Builder.withForcedAllureSupport().apply {
        stepWatcherInterceptors.removeIf {
            it is ScreenshotStepInterceptor
        }
        // добавили свой интерсептор, где скриншоты делаются только при ошибке теста
        stepWatcherInterceptors.add(ScreenshotStepOnlyFailInterceptor(screenshots))
    }
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun smartScenariosTest1() {
        run {
            step("test") {
                OnboardingScreen.skip {
                    isDisplayed()
                    click()
                }
            }
            step("fail"){
                OnboardingScreen.skip.isDisplayed()
            }
        }
    }
}

