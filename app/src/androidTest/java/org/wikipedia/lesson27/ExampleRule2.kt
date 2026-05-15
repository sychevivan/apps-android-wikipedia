package org.wikipedia.lesson27

import android.util.Log
import io.qameta.allure.kotlin.AllureId
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import kotlin.collections.contains

class ExampleRule2: TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        Log.i("KASPRESSO", "ExampleRule rule started before test")
        Log.i("KASPRESSO", description?.displayName.toString())
        
        return object : Statement(){
            override fun evaluate() {

                val allureId = description?.getAnnotation<AllureId>(AllureId::class.java)?.value
                Log.i("KASPRESSO","allure id is $allureId")
                if (allureId !in Config2.testClasses) {
                    throw AssertionError("Не входит в список тестов")
                }

                try{
                    base?.evaluate()
                }
                catch (e: Throwable){
                    Log.i("KASPRESSO", e.message.toString())
                }
                Log.i("KASPRESSO", "Log after test")
            }
        }
    }
}

object Config2 {
    val testClasses = listOf("1", "2", "3")
}

class SampleTest2() {
    @get:Rule
    val baseRule = ExampleRule2()

    @Test
    @AllureId("4")
    fun testRuleSample() {
        Log.i("KASPRESSO", "Log from test testRuleSample")
        Assert.assertTrue("Тут упали", false)
    }
}
