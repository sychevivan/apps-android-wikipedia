package org.wikipedia.lesson08.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object ExploreScreenHW : KScreen<ExploreScreenHW>() {
    override val layoutId: Int = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val customizeItems = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = { itemType(::CustomizeItem) }
    )

    val dateItems = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = { itemType(::DateItem) }
    )

    val topReadItems = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = { itemType(::TopReadItem) }
    )

    val inTheNewsItems = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = { itemType(::InTheNewsItem) }
    )
}