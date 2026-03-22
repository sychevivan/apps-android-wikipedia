package org.wikipedia.lesson13.homework

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson09.OnboardingScreen
import org.wikipedia.main.MainActivity

class WebviewTests: TestCase() {

    @get:Rule
    val testContext = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webviewTest() {
        run {
            step("Нажимает на кнопку Skip") {
                OnboardingScreen.skip.click()
            }
            step("Нажимает на Search") {
                ExploreScreenHW.search.click()
            }
            step("Вводит putin"){
                SearchScreen.edit.replaceText("putin")
            }
            step("Нажимает на putin") {
                SearchResultScreen.putin.click()
                GameScreen.close.click()
            }
            step("Проверяет Reference"){
                ArticleScreen.webView{
                    withElement(Locator.ID, "References"){
                        scroll()
                        hasText("References")
                    }
                }
            }
            step("Прокручивает до ссылки 5 и нажимает ее"){
                ArticleScreen.webView{
                    withElement(Locator.XPATH, "//sup[contains(@class,'mw-ref')]//span[text()=5]"){
                        scroll()
                        click()
                    }
                }
            }
            step("проверяет элементы reference"){
                ReferencesScreen{
                    referenceTitle.hasText("Reference ")
                    items.childAt<ReferenceItem>(0) {
                        referenceId.hasText("5.")
                    }
                    device.uiDevice.pressBack()
                }
            }
            step("Раскрывает элемент Quick facts"){
                ArticleScreen.webView{
                    withElement(Locator.XPATH, "//strong[@class='pcs-table-infobox' and text()='Quick facts']"){
                        scroll()
                        click()
                    }
                }
            }
            step("Прокручивает до второй ссылки mw-redirect и нажимает ее"){
                ArticleScreen.webView{
                    withElement(Locator.XPATH, "(//a[contains(@class,'mw-redirect')])[2]"){
                        scroll()
                        click()
                    }
                }
            }
            step("Нажимает Read article"){
                ArticleScreen.readArticleButton.click()
            }
            step("Скроллит до References через xpath"){
                ArticleScreen.webView{
                    withElement(Locator.XPATH, "//*[@id='References']"){
                        scroll()
                    }
                }
            }
        }
    }
}