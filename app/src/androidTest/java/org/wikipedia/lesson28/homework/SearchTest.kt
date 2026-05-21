package org.wikipedia.lesson28.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.qameta.allure.kotlin.Description
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson13.homework.SearchResultScreen
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson20.homework.NavBarElements
import org.wikipedia.lesson20.homework.SearchScreen
import org.wikipedia.main.MainActivity

class SearchTest : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val dataRule = DataRule()

    private fun searchValidTest() {
        run {
            action.click(OnboardingScreen.skip)
            action.click(NavBarElements.searchButton)
            action.click(SearchScreen.searchField)
            action.typeText(SearchScreen.searchFieldAfterClick, dataRule.testData)
            SearchResultScreen.trump.isDisplayed()
        }
    }

    private fun searchInvalidTest() {
        run {
            action.click(OnboardingScreen.skip)
            action.click(NavBarElements.searchButton)
            action.click(SearchScreen.searchField)
            action.typeText(SearchScreen.searchFieldAfterClick, dataRule.testData)
            SearchResultScreen.nothingFound.isDisplayed()
        }
    }

    @Test
    @Description("valid")
    fun testValidSearch() {
        searchValidTest()
    }

    @Test
    @Description("invalid")
    fun testInvalidSearch() {
        searchInvalidTest()
    }


    @Test
    @Description("qwerty")
    fun testQwertySearch() {
        searchInvalidTest()
    }
}
