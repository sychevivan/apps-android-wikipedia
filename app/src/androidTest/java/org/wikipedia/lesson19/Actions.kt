package org.wikipedia.lesson19

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.lesson18.getName
import org.wikipedia.lesson23.KWebViewElement
import org.wikipedia.lesson24.getName

// Шаги действий
class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun setCheckedTrue(element: CheckableActions) {
        steps.setChecked("Включает '${(element as BaseActions).getName()}'", element, true)
    }

    fun setCheckedFalse(element: CheckableActions) {
        steps.setChecked("Выключает '${(element as BaseActions).getName()}'", element, false)
    }

    fun click(element: KWebViewElement) {
        steps.click("Нажимает на WebView элемент '${element.getName()}'", element)
    }

    fun clickIfEnabled(element: NodeActions) {
        steps.clickIfEnabled("clickIfEnabled '${element.getName()}'", element)
    }
}