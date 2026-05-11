package org.wikipedia.lesson26

import android.util.Log
import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import com.kaspersky.components.alluresupport.files.attachScreenshotToAllureReport
import com.kaspersky.kaspresso.device.screenshots.Screenshots
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor
import com.kaspersky.kaspresso.interceptors.watcher.testcase.StepWatcherInterceptor
import com.kaspersky.kaspresso.interceptors.watcher.view.ViewActionWatcherInterceptor
import com.kaspersky.kaspresso.interceptors.watcher.view.ViewAssertionWatcherInterceptor
import com.kaspersky.kaspresso.testcases.models.info.StepInfo

// class BeforeAfterBehaviorInterceptor: ViewBehaviorInterceptor {
//     override fun <T> intercept(
//         interaction: ViewInteraction,
//         action: () -> T
//     ): T {
//         Log.i("KASPRESSO", "before")
//         val result = action()
//         Log.i("KASPRESSO","after")
//         return result
//     }
// }

class MyViewActionInterceptor : ViewActionWatcherInterceptor {
    override fun intercept(viewAction: ViewAction, view: View) {
        Log.i("KASPRESSO", "Description: ${viewAction.description}")
    }
}

class MyViewAssertionInterceptor : ViewAssertionWatcherInterceptor {
    override fun intercept(
        viewAssertion: ViewAssertion,
        view: View?,
        exception: NoMatchingViewException?
    ) {
        Log.i("KASPRESSO", "Before assertion")
        if (exception != null) {
            Log.e("KASPRESSO", "Assertion: ${exception.message}")
        }
    }
}

class TestTimeInterceptor : ViewBehaviorInterceptor {
    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        val startTime = System.currentTimeMillis()
        val result = action()
        val endTime = System.currentTimeMillis()
        Log.i("KASPRESSO", "Test time is " + (endTime - startTime).toString() + "ms")
        return result
    }
}

class ScreenshotStepOnlyFailInterceptor(
    private val screenshots: Screenshots
) : StepWatcherInterceptor {

    override fun interceptAfterWithSuccess(stepInfo: StepInfo) {
        // intercept(makeTag(stepInfo))
    }

    override fun interceptAfterWithError(stepInfo: StepInfo, error: Throwable) {
        intercept("${makeTag(stepInfo)}_failure_${error.javaClass.simpleName}")
    }

    private fun intercept(tag: String) {
        screenshots.takeAndApply(tag) { attachScreenshotToAllureReport() }
    }

    private fun makeTag(stepInfo: StepInfo): String = "${stepInfo.testClassName}_step_${stepInfo.ordinal}"
}
