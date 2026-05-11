package org.wikipedia.lesson26.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.main.MainActivity

class SimpleInterceptorTestHW : TestCase(
    Kaspresso.Builder.withForcedAllureSupport().apply {
        testRunWatcherInterceptors.add(MyTestRunWatcherInterceptor())
    }
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun interceptorOrderTest() {
        before {
            testLogger.i("INTERCEPTOR_TEST", ">>> BEFORE SECTION: setup started")
        }.after {
            testLogger.i("INTERCEPTOR_TEST", ">>> AFTER SECTION: cleanup started")
        }.run {
            step("Step 1: Check onboarding is displayed") {
                testLogger.i("INTERCEPTOR_TEST", ">>> RUN STEP 1: checking onboarding display")
                OnboardingScreen.skip.isDisplayed()
            }
            step("Step 2: Click skip") {
                testLogger.i("INTERCEPTOR_TEST", ">>> RUN STEP 2: clicking skip")
                OnboardingScreen.skip.click()
            }
            step("Step 3: Verify main screen") {
                testLogger.i("INTERCEPTOR_TEST", ">>> RUN STEP 3: verifying main screen")
            }
        }
    }
}
