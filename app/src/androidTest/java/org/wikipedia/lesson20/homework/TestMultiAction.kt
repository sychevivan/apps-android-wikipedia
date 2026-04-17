package org.wikipedia.lesson20.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson09.OnboardingScreen
import org.wikipedia.lesson20.equalsWithTrim
import org.wikipedia.lesson20.multiAction
import org.wikipedia.main.MainActivity

class TestMultiAction : TestCase(
    Kaspresso.Builder.withForcedAllureSupport()
) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun multiActionTest2() {
        run {
            OnboardingScreen.skip.multiAction()
            NavBarElements.searchButton.click()
            SearchScreen.searchField.click()
            // Thread.sleep(3000)
            SearchScreen.searchFieldAfterClick.multiAction()
            SearchScreen.searchFieldAfterClick.equalsWithTrim("On")
            device.uiDevice.pressBack()
            device.uiDevice.pressBack()
            // Thread.sleep(3000)
            NavBarElements.moreButton.click()
            NavBarElements.settingsButton.click()

            SettingsScren.settingsItem("Download only over Wi-Fi") {
                switch.setChecked(false)
                switch.multiAction()
                switch.isChecked()
            }
        }
    }
}