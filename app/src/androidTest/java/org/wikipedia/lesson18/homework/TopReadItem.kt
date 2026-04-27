package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent
import org.wikipedia.lesson18.invokeAtIndex
import org.wikipedia.lesson18.invokeWithText

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem> (matcher) {
    val headerTitle by lazy {
        KTextView(matcher) { withId(R.id.view_card_header_title) }
            .name(withParent("headerTitle"))
    }
    val headerMenu by lazy {
        KImageView(matcher) { withId(R.id.view_list_card_header_menu) }
            .name(withParent("headerMenu"))
    }
    val cardListItems by lazy {
        KRecyclerView(
            parent = matcher,
            builder = { withId(R.id.view_list_card_list) },
            itemTypeBuilder = {itemType(::CardListItem)}
        ).name(withParent("cardListItems"))
    }


    val moreButton by lazy {
        KButton(matcher) { withId(R.id.footerActionButton) }
            .name(withParent("moreButton"))
    }

    fun cardListItem(index: Int, fnc: CardListItem.() -> Unit) {
        cardListItems.invokeAtIndex(index, fnc)
    }

    fun cardListItemWithText(text: String, fnc: CardListItem.() -> Unit) {
        cardListItems.invokeWithText(text, fnc)
    }
}