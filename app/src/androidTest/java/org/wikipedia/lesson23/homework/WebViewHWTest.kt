package org.wikipedia.lesson23.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson13.homework.GameScreen
import org.wikipedia.lesson18.homework.ExploreScreenHW
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson23.ArticleScreen
import org.wikipedia.main.MainActivity

class WebViewHWTest: TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewSimple(){
        run {
            action.click(OnboardingScreen.skip)

            ExploreScreenHW.topReadBlock {
                cardListItem(0) {
                    action.click(this)
                }
            }
            action.click(GameScreen.close)
            Thread.sleep(3000)

            verify.isDisplayed(ArticleScreen.title)

            // Кликает по заголовку References в конце статьи
            action.click(ArticleScreen.references)

            // Берёт второй блок и проверяет, что текст в индексе блока равен [2]
            ArticleScreen.referencesItem(2) {
                verify.hasText(index, "[2]")
            }

        }
    }
}