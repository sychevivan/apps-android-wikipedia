@file:OptIn(ExperimentalTestApi::class)

package org.wikipedia.lesson24

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.SemanticsMatcher
import io.github.kakaocup.compose.node.builder.ViewBuilder
import io.github.kakaocup.compose.node.core.BaseNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemBuilder
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode
import org.wikipedia.compose.uiTests.LazyListItemPositionSemantics
import org.wikipedia.compose.uiTests.LazyListSizeSemantics

inline fun <reified T : KLazyListItemNode<*>> KLazyListNode.invokeAtIndex(
    index: Int,
    fnc: T.() -> Unit
) {
    val list = this
    childAt<T>(index) {
        name(list.withParent("$index"))
        fnc()
    }
}

inline fun <reified T : KLazyListItemNode<*>> KLazyListNode.invokeWithText(
    text: String,
    fnc: T.() -> Unit
) {
    childWith<T> {
        hasText(text, true)
    }.name(withParent(text))
        .fnc()
}

fun BaseNode<*>.createLazyList(
    viewBuilderAction: ViewBuilder.() -> Unit,
    itemTypeBuilder: KLazyListItemBuilder.() -> Unit,
) = KLazyListNode(
    viewBuilderAction = viewBuilderAction,
    itemTypeBuilder = itemTypeBuilder,
    positionMatcher = {
        SemanticsMatcher.expectValue(LazyListItemPositionSemantics, it)
    },
    lengthSemanticsPropertyKey = LazyListSizeSemantics,
)