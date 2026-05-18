package org.wikipedia.lesson28.homework

import org.junit.rules.TestRule
import org.junit.runner.Description as JUnitDescription
import org.junit.runners.model.Statement
import org.wikipedia.BuildConfig

class DataRule : TestRule {
    var testData: String = ""

    override fun apply(base: Statement, description: JUnitDescription): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                val annotation = description.getAnnotation(Description::class.java)
                if (annotation?.value == "valid") {
                    testData = BuildConfig.VALID_SEARCH
                } else {
                    testData = BuildConfig.INVALID_SEARCH
                }
                base.evaluate()
            }
        }
    }
}
