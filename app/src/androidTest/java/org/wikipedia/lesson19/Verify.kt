package org.wikipedia.lesson19

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson18.getName
import org.wikipedia.lesson23.KWebViewElement
import org.wikipedia.lesson24.getName

// Шаги проверок
class Verify(private val steps: StepDefinitions) : StepsDsl<Verify>() {

    override val self = this

    fun isDisplayed(element: BaseAssertions) {
        steps.isDisplayed(
            "Проверяет, что отображается '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun isDisplayed(element: NodeAssertions) {
        steps.isDisplayed(
            "Проверяет, что отображается Compose элемент '${(element as NodeActions).getName()}'",
            element
        )
    }

    fun hasText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' эквивалентен '$text'",
            element,
            text,
            false
        )
    }

    fun containsText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' содержит подстроку '$text'",
            element,
            text,
            true
        )
    }

    fun doesNotExist(element: BaseAssertions) {
        steps.doesNotExist(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' отсутствует",
            element
        )
    }

    fun doesNotExist(element: NodeAssertions) {
        steps.doesNotExist(
            "Проверяет, что Compose элемент '${(element as NodeActions).getName()}' отсутствует",
            element
        )
    }

    fun isNotChecked(element: CheckableAssertions) {
        steps.isNotChecked(
            "Проверяет, что переключатель '${(element as BaseActions).getName()}' выключен",
            element
        )
    }

    fun isChecked(element: CheckableAssertions) {
        steps.isChecked(
            "Проверяет, что переключатель '${(element as BaseActions).getName()}' включен",
            element
        )
    }

    fun isEnabled(element: BaseAssertions) {
        steps.isEnabled(
            "Проверяет, что активен ' '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun isDisabled(element: BaseAssertions) {
        steps.isDisabled(
            "Проверяет, что заблокирован ' '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun isDisplayed(element: KWebViewElement) {
        steps.isDisplayed(
            "Проверяет, что отображается WebView элемент '${element.getName()}'",
            element
        )
    }

    fun hasText(element: KWebViewElement, text: String) {
        steps.hasText(
            "Проверяет что текст в WebView элементе '${element.getName()}' эквивалентен '$text'",
            element,
            text
        )
    }

    fun assertTrimmedTextIsEquals(element: NodeAssertions, text: String) {
        steps.assertTrimmedTextIsEquals(
            "Проверяет что trimmed текст '${(element as NodeActions).getName()}' эквивалентен '$text'",
            element,
            text
        )
    }
}