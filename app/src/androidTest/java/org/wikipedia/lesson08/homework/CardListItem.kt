package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class CardListItem(matcher: Matcher<View>) : KRecyclerItem<CardListItem>(matcher){
    val cardNumber = KTextView(matcher) { withId(R.id.numberView) }
    val cardTitle = KTextView(matcher) { withId(R.id.view_list_card_item_title) }
    val cardSubtitle = KTextView(matcher) { withId(R.id.view_list_card_item_subtitle) }
    val cardGraf = KImageView(matcher) { withId(R.id.view_list_card_item_graph) }
    val cardPageView = KTextView(matcher) { withId(R.id.view_list_card_item_pageviews) }
    val cardImage = KImageView(matcher) { withId(R.id.view_list_card_item_image) }
}