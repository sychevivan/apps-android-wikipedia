package org.wikipedia.lesson19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson23.KWebViewElement
import org.wikipedia.lesson23.WebViewTest
import org.wikipedia.lesson24.assertTrimmedTextIsEquals
import org.wikipedia.lesson24.clickIfEnabled
import org.wikipedia.lesson25.ClosePlayTodayGame
import org.wikipedia.lesson25.CloseGotIt
import org.wikipedia.lesson25.PassInterferingScreens

class StepDefinitions(private val testContext: TestContext<*>) {

    private val passInterferingScreens = PassInterferingScreens(
        listOf(
            ClosePlayTodayGame(testContext),
            CloseGotIt(testContext)
        )
    )

    fun click(step: String, element: BaseActions) {
        execute(step) {
            element.click()
        }
    }

    fun isDisplayed(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisplayed()
        }
    }

    fun hasText(step: String, element: TextViewAssertions, text: String, isSubstring: Boolean) {
        execute(step) {
            if (isSubstring) {
                element.containsText(text)
            } else {
                element.hasText(text)
            }
        }
    }

    fun doesNotExist(step: String, element: BaseAssertions) {
        execute(step) {
            element.doesNotExist()
        }
    }

    private fun execute(step: String, fnc: () -> Unit) {
        testContext.step(step) {
            try {
                fnc()
            } catch (_: Throwable) {
                passInterferingScreens.execute()
                fnc()
            }
        }
    }

    fun isNotChecked(step: String, element: CheckableAssertions) {
        execute(step) {
            element.isNotChecked()
        }
    }

    fun isChecked(step: String, element: CheckableAssertions) {
        execute(step) {
            element.isChecked()
        }
    }

    fun setChecked(step: String, element: CheckableActions, checked: Boolean) {
        execute(step) {
            element.setChecked(checked)
        }
    }

    fun isEnabled(step: String, element: BaseAssertions) {
        execute(step) {
            element.isEnabled()
        }
    }

    fun isDisabled(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisabled()
        }
    }

    fun isDisplayed(step: String, element: KWebViewElement){
        execute(step) {
            element.performWebViewAction { scroll() }
        }
    }

    fun click(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction {
                scroll()
                click()
            }
        }
    }

    fun hasText(step: String, element: KWebViewElement, text: String) {
        execute(step) {
            element.performWebViewAction {
                scroll()
                hasText(text)
            }
        }
    }

    fun clickIfEnabled(step: String, element: NodeActions) {
        execute(step) {
            element.clickIfEnabled()
        }
    }

    fun assertTrimmedTextIsEquals(step: String, element: NodeAssertions, text: String) {
        execute(step) {
            element.assertTrimmedTextIsEquals(text)
        }
    }
}