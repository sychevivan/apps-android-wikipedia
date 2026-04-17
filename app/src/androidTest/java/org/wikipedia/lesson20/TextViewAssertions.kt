package org.wikipedia.lesson20

import io.github.kakaocup.kakao.text.TextViewAssertions

fun TextViewAssertions.equalsWithTrim(expected: String) {
    view.check(EqualsWithTrimAssertion(expected))
}