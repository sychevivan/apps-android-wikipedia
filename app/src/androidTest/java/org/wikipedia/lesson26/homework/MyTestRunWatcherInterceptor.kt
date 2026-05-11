package org.wikipedia.lesson26.homework

import android.util.Log
import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.testcases.models.info.TestInfo

class MyTestRunWatcherInterceptor : TestRunWatcherInterceptor {
    override fun onTestStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "[MyTestRunWatcher] TEST STARTED: ${testInfo.testName}")
    }

    override fun onBeforeSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "[MyTestRunWatcher] BEFORE section STARTED: ${testInfo.testName}")
    }

    override fun onBeforeSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "[MyTestRunWatcher] BEFORE section FINISHED SUCCESS: ${testInfo.testName}")
    }

    override fun onBeforeSectionFinishedFailed(testInfo: TestInfo, throwable: Throwable) {
        // Log.e("KASPRESSO", "[MyTestRunWatcher] BEFORE section FINISHED FAILED: ${testInfo.testName}", throwable)
    }

    override fun onMainSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "[MyTestRunWatcher] MAIN section STARTED: ${testInfo.testName}")
    }

    override fun onMainSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "[MyTestRunWatcher] MAIN section FINISHED SUCCESS: ${testInfo.testName}")
    }

    override fun onMainSectionFinishedFailed(testInfo: TestInfo, throwable: Throwable) {
        // Log.e("KASPRESSO", "[MyTestRunWatcher] MAIN section FINISHED FAILED: ${testInfo.testName}", throwable)
    }

    override fun onAfterSectionStarted(testInfo: TestInfo) {
        Log.i("KASPRESSO", "[MyTestRunWatcher] AFTER section STARTED: ${testInfo.testName}")
    }

    override fun onAfterSectionFinishedSuccess(testInfo: TestInfo) {
        Log.i("KASPRESSO", "[MyTestRunWatcher] AFTER section FINISHED SUCCESS: ${testInfo.testName}")
    }

    override fun onAfterSectionFinishedFailed(testInfo: TestInfo, throwable: Throwable) {
        // Log.e("KASPRESSO", "[MyTestRunWatcher] AFTER section FINISHED FAILED: ${testInfo.testName}", throwable)
    }

    override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
        val result = if (success) "SUCCESS" else "FAILED"
        Log.i("KASPRESSO", "[MyTestRunWatcher] TEST FINISHED: ${testInfo.testName} with result = $result")
    }
}