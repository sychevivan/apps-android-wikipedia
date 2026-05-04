package org.wikipedia.lesson24

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions

fun NodeAssertions.assertTrimmedTextIsEquals(expected: String) {
    delegate.check(TrimmedTextAssertions(expected))
}

fun NodeActions.clickIfEnabled() {
    delegate.perform(ClickIfEnabledAction())
}