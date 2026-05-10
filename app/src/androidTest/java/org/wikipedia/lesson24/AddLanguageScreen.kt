package org.wikipedia.lesson24

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import org.wikipedia.compose.uiTests.Tags.CANONICAL_LANG_NAME
import org.wikipedia.compose.uiTests.Tags.LANGUAGE_LIST
import org.wikipedia.compose.uiTests.Tags.LOCALIZED_LANG_NAME


object AddLanguageScreen : ComposeNamedScreen<AddLanguageScreen>() {
    override val screenName: String = "Экран добавления языка"

    val items by lazy {
        createLazyList(
            viewBuilderAction = {
                hasTestTag(LANGUAGE_LIST)
            },
            itemTypeBuilder = {
                itemType(::LanguageItem)
            },
        ).name(withParent("Список доступных для выбора языков"))
    }

    fun itemWithText(text: String, fnc: LanguageItem.() -> Unit) {
        items.invokeWithText<LanguageItem>(text, fnc)
    }
}


class LanguageItem(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider? = null
) : KLazyListItemNode<LanguageItem>(semanticNode, semanticsProvider) {

    val localName by lazy {
        child<KNode> {
            hasTestTag(LOCALIZED_LANG_NAME)
        }.name(withParent("Строка localName в списке языков"))
    }

    val canonicalName by lazy {
        child<KNode> {
            hasTestTag(CANONICAL_LANG_NAME)
        }.name(withParent("Строка canonicalName в списке языков"))
    }
}