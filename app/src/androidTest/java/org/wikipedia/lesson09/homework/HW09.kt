package org.wikipedia.lesson09.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.announcement.AnnouncementCardView
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson09.OnboardingScreen
import org.wikipedia.main.MainActivity

class HWTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOnboardingScreen() {
        run {
            step("Нажимает на кнопку Skip") {
                OnboardingScreen.skip.isDisplayed()
                OnboardingScreen.skip.click()
            }
            step("Проверяет, что на экране отображается featuredArticleItems") {
                ExploreScreenHW.featuredArticleItems.childWith<featuredArticleItem> {
                    isInstanceOf(FeaturedArticleCardView::class.java)
                }.perform {
                    isDisplayed()
                }
            }
            step("Нажимет кнопку Customize") {
                ExploreScreenHW.customizeItems.childWith<CustomizeItem> {
                    isInstanceOf(AnnouncementCardView::class.java)
                }.perform {
                    customizeButton.click()
                }
            }
            step("Отключает Featured Article") {
                // CustomizeTheFeedScreen.contentTypesRecyclers.childAt<ContentTypesItem>(1) {
                //     switch.isDisplayed()
                //     switch.isChecked()
                //     switch.click()
                //     switch.isNotChecked()
                //     Thread.sleep(2000)
                // }
                CustomizeTheFeedScreen.contentTypesRecyclers.childWith<ContentTypesItem> {
                    withDescendant { withText("Featured article") }
                }.perform{
                    switch.isDisplayed()
                    switch.isChecked()
                    switch.click()
                    switch.isNotChecked()
                    Thread.sleep(2000)
                }
            }
            step("Нажимает стрелку назад в верхнем тулбаре") {
                CustomizeTheFeedScreen.backToolbarButton.click()
            }
            step("Проверяет, что блок Featured Article не отображается на экране Explore (метод doesNotExist())") {
                ExploreScreenHW.featuredArticleItems.childWith<featuredArticleItem> {
                    // isInstanceOf(FeaturedArticleCardView::class.java)
                    isAssignableFrom(FeaturedArticleCardView::class.java)
                }.perform {
                    articleTitle.doesNotExist()
                }
            }
        }
    }
}