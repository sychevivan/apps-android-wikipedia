package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem> (matcher) {
    val headerTitle = KTextView(matcher) { withId(R.id.view_card_header_title) }
    val headerMenu = KImageView(matcher) { withId(R.id.view_list_card_header_menu) }
    val cardListItems = KRecyclerView(
        parent = matcher,
        builder = { withId(R.id.view_list_card_list) },
        itemTypeBuilder = {itemType(::CardListItem)}
    )
    val moreButton = KButton(matcher) { withId(R.id.footerActionButton) }
}