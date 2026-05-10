package org.wikipedia.lesson25

import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import io.qameta.allure.kotlin.Allure

class CloseGotIt(testContext: BaseTestContext) : ScreenBehaviorBase(testContext) {

    override val step = "Закрывает блок Got It"
    override val action: Allure.StepContext.() -> Unit = {
        getElementByText("Got It").click()
    }

    override fun isConditionMet(): Boolean {
        return checkScreenByText("Got It")
    }
}