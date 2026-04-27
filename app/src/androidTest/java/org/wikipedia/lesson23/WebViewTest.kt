package org.wikipedia.lesson23

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson13.homework.GameScreen
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson18.homework.CardListItem
import org.wikipedia.lesson18.homework.ExploreScreenHW
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson18.homework.TopReadItem
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.main.MainActivity

class WebViewTest : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewSimple(){
        run {
            action.click(OnboardingScreen.skip)
            // ExploreScreenHW.featuredArticle(0) {
            //     action.click(articleDescription)
            // }

            // ExploreScreenHW.topReadBlock {
            //     cardListItems.childAt<CardListItem>(0,{
            //         action.click(this)
            //     })
            // }

            ExploreScreenHW.topReadBlock {
                cardListItem(0) {
                    action.click(this)
                }
            }
            action.click(GameScreen.close)
            Thread.sleep(3000)

            // ArticleScreen{
            //     title.performWebViewAction {
            //         scroll()
            //     }
            // }

            verify.isDisplayed(ArticleScreen.title)
        }
    }
}