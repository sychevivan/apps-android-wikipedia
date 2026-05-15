package org.wikipedia.lesson27.homework

import org.junit.AssumptionViolatedException
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class SkipDeprecatedRule : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                val deprecatedAnnotation = description.getAnnotation(Deprecated::class.java)
                if (deprecatedAnnotation != null) {
                    throw AssumptionViolatedException("Тест пропущен, так как он помечен аннотацией @Deprecated")
                }
                base.evaluate()
            }
        }
    }
}

class SkipDeprecatedTest {
    @get:Rule
    val skipRule = SkipDeprecatedRule()

    @Test
    @Deprecated("Устаревший тест")
    fun testShouldBeSkipped() {
        // Этот тест не должен выполниться
        assert(false) { "Тест должен был быть пропущен!" }
    }

    @Test
    fun testShouldBeExecuted() {
        // Этот тест должен выполниться успешно
        assert(true)
    }
}
