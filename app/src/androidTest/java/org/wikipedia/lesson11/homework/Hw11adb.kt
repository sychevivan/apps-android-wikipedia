package org.wikipedia.lesson11.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson09.OnboardingScreen
import org.wikipedia.main.MainActivity
import java.util.Locale

class Hw11adb : TestCase() {

    @get:Rule
    val testContext = ActivityScenarioRule(MainActivity::class.java)


    // поворот экрана и проверка ориентации через метод device.uiDevice.isNaturalOrientation
    @Test
    fun checkRotationTest() {
        run {
            device.uiDevice.setOrientationRight()
            Thread.sleep(3000)
            Assert.assertFalse(device.uiDevice.isNaturalOrientation)
        }
    }

    // выключение и включение экрана с проверкой, что элемент интерфейса остался видимым
    @Test
    fun checkElementAfterScreenOffAndOnTest() {
        run {
            OnboardingScreen.skip.isDisplayed()

            device.uiDevice.sleep()
            Thread.sleep(2000)
            Assert.assertFalse(device.uiDevice.isScreenOn)

            device.uiDevice.wakeUp()
            Thread.sleep(2000)
            Assert.assertTrue(device.uiDevice.isScreenOn)

            OnboardingScreen.skip.isDisplayed()
        }
    }

    // сворачивание приложения через home и возврат через recent apps с проверкой элемента
    @Test
    fun checkElementAfterHomeAndRecentAppsTest() {
        run {
            OnboardingScreen.skip.isDisplayed()

            device.uiDevice.pressHome()
            Thread.sleep(2000)

            device.uiDevice.pressRecentApps()
            Thread.sleep(1000)
            device.uiDevice.pressRecentApps()

            OnboardingScreen.skip.isDisplayed()
        }
    }


    // проверка, что активна MainActivity
    @Test
    fun checkMainActivityTest() {
        run {
            OnboardingScreen.skip.click()
            device.activities.isCurrent(MainActivity::class.java)
        }
    }

    // смена системного языка на французский через adb и проверка русского текста в приложении
    @Test
    fun changeSystemLanguageToFrenchWithAdbTest() {
        before{
            device.language.switchInApp(locale = Locale.FRENCH)
        }.
        after {
            device.language.switchInApp(locale = Locale.ENGLISH)
        }.
        run {
            OnboardingScreen.skip.hasText("Sauter")
        }
    }
}
