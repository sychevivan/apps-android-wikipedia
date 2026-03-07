package org.wikipedia.lesson10.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson10.OnboardingUiScreen
import org.wikipedia.lesson10.homework.OnboardingUiScreen1.continueButton
import org.wikipedia.lesson10.homework.OnboardingUiScreen1.fragmentPager
import org.wikipedia.lesson10.homework.OnboardingUiScreen1.optionLabel
import org.wikipedia.lesson10.homework.OnboardingUiScreen1.primaryTextView
import org.wikipedia.lesson10.homework.OnboardingUiScreen1.secondaryTextView
import org.wikipedia.main.MainActivity

class KautomatorTestHW : TestCase() {

    @get:Rule
    val testContext = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun kautomatorTestFirstScreen() {
        run {
            OnboardingUiScreen {
                step("Проверяет отображение текста") {
                    primaryTextView.isDisplayed()
                    primaryTextView.containsText("The Free Encyclopedia\n" +
                            "…in over 300 languages")
                    secondaryTextView.isDisplayed()
                    secondaryTextView.containsText("We’ve found the following on your device:")
                    optionLabel.isDisplayed()
                    optionLabel.containsText("1.\t\tEnglish")
                }
            }
        }
    }

    @Test
    fun kautomatorTestScreen2() {
        run {
            step("Переходит на следующий экран"){
                // continueButton.click()
                fragmentPager.swipeLeft()
            }
            OnboardingUiScreen {
                step("Проверяет отображение текста") {
                    primaryTextView.isDisplayed()
                    primaryTextView.containsText("New ways to explore")
                    secondaryTextView.isDisplayed()
                    secondaryTextView.containsText("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. \n" +
                            "Customize the feed to your interests – whether it’s learning about historical events On this day, or rolling the dice with Random.")
                }
            }
        }
    }

    @Test
    fun kautomatorTestScreen3() {
        run {
            step("Переходит на экран 3"){
                continueButton.click()
                continueButton.click()
            }
            OnboardingUiScreen {
                step("Проверяет отображение текста") {
                    primaryTextView.isDisplayed()
                    primaryTextView.containsText("Reading lists with sync")
                    secondaryTextView.isDisplayed()
                    secondaryTextView.containsText("You can make reading lists from articles you want to read later, even when you’re offline. \n" +
                            "Login to your Wikipedia account to sync your reading lists. Join Wikipedia")
                }
            }
        }
    }

    @Test
    fun kautomatorTestScreen4() {
        run {
            step("Переходит на экран 4"){
                continueButton.click()
                continueButton.click()
                continueButton.click()
            }
            OnboardingUiScreen {
                step("Проверяет отображение текста") {
                    primaryTextView.isDisplayed()
                    primaryTextView.containsText("Data & Privacy")
                    secondaryTextView.isDisplayed()
                    secondaryTextView.containsText("We believe that you should not have to provide personal information to participate in the free knowledge movement. Usage data collected for this app is anonymous. Learn more about our privacy policy and terms of use.")
                }
            }
        }
    }
}