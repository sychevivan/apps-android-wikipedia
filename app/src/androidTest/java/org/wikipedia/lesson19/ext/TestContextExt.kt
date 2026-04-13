package org.wikipedia.lesson19.ext

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.wikipedia.lesson19.Actions
import org.wikipedia.lesson19.StepDefinitions
import org.wikipedia.lesson19.StepsDsl
import org.wikipedia.lesson19.Verify

private val steps = mutableMapOf<String, StepsDsl<*>>()

val TestContext<*>.action: Actions
    get() {
        return steps.getOrPut(getId(this, "action")) {
            Actions(StepDefinitions(this))
        } as Actions

    }

val TestContext<*>.verify: Verify
    get() {
        return steps.getOrPut(getId(this, "verify")) {
            Verify(StepDefinitions(this))
        } as Verify
    }

private fun getId(testContext: TestContext<*>, stepType: String): String {
    return "${testContext.hashCode()}-$stepType"
}