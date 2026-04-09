package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class CardListItem(matcher: Matcher<View>) : KRecyclerItem<CardListItem>(matcher){
    val cardNumber by lazy {
        KTextView(matcher) { withId(R.id.numberView) }
            .name(withParent("cardNumber"))
    }
    val cardTitle by lazy {
        KTextView(matcher) { withId(R.id.view_list_card_item_title) }
            .name(withParent("cardTitle"))
    }
    val cardSubtitle by lazy {
        KTextView(matcher) { withId(R.id.view_list_card_item_subtitle) }
            .name(withParent("cardSubtitle"))
    }
    val cardGraf by lazy {
        KImageView(matcher) { withId(R.id.view_list_card_item_graph) }
            .name(withParent("cardGraf"))
    }
    val cardPageView by lazy {
        KTextView(matcher) { withId(R.id.view_list_card_item_pageviews) }
            .name(withParent("cardPageView"))
    }
    val cardImage by lazy {
        KImageView(matcher) { withId(R.id.view_list_card_item_image) }
            .name(withParent("cardImage"))
    }
}