package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson09.homework.CustomizeItem
import org.wikipedia.lesson09.homework.DateItem
import org.wikipedia.lesson09.homework.InTheNewsItem
import org.wikipedia.lesson09.homework.TopReadItem
import org.wikipedia.lesson09.homework.featuredArticleItem

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

    val featuredArticleItems = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = { itemType(::featuredArticleItem) }
    )

    val search = KButton{
        withText(R.string.search_hint)
    }
}

