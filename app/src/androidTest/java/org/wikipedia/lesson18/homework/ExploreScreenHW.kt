package org.wikipedia.lesson18.homework

import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson18.invokeAtIndex
import org.wikipedia.lesson18.invokeWithText
import org.wikipedia.lesson18.name
import org.wikipedia.lesson21.invokeAtIndexAndClass
import org.wikipedia.lesson22.SearchWidget

object ExploreScreenHW : NamedScreen<ExploreScreenHW>() {
    override val screenName = "Экран Explore"
    override val layoutId: Int = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    fun customizeItem(index: Int, fnc: CustomizeItem.() -> Unit) {
        customizeItems.invokeAtIndex(index, fnc)
    }

    fun customizeBlock(fnc: CustomizeItem.() -> Unit) {
        customizeItems.invokeWithText("Customize", fnc)
    }

    fun dateItem(index: Int, fnc: DateItem.() -> Unit) {
        dateItems.invokeAtIndex(index, fnc)
    }

    fun topReadItem(index: Int, fnc: TopReadItem.() -> Unit) {
        topReadItems.invokeAtIndex(index, fnc)
    }

    fun topReadBlock(fnc: TopReadItem.() -> Unit) {
        topReadItems.invokeWithText("Top read", fnc)
    }

    fun topReadItemWithText(text: String, fnc: TopReadItem.() -> Unit) {
        topReadItems.invokeWithText(text, fnc)
    }

    fun inTheNewsItem(index: Int, fnc: InTheNewsItem.() -> Unit) {
        inTheNewsItems.invokeAtIndex(index, fnc)
    }

    fun inTheNewsItemWithText(text: String, fnc: InTheNewsItem.() -> Unit) {
        inTheNewsItems.invokeWithText(text, fnc)
    }

    fun featuredArticleItem(index: Int, fnc: FeaturedArticleItem.() -> Unit) {
        featuredArticleItems.invokeAtIndex(index, fnc)
    }

    fun featuredArticle(index: Int, fnc: FeaturedArticleItem.() -> Unit) {
        items.invokeAtIndexAndClass(
            index,
            FeaturedArticleCardView::class.java,
            (index + 1) * 10,
            1,
            "$index блок Featured Article",
            fnc
        )
    }

    val customizeItems by lazy {
        KRecyclerView(
            builder = { withId(R.id.feed_view) },
            itemTypeBuilder = { itemType(::CustomizeItem) }
        ).name(withParent("Customize Items"))
    }

    val dateItems by lazy {
        KRecyclerView(
            builder = { withId(R.id.feed_view) },
            itemTypeBuilder = { itemType(::DateItem) }
        ).name(withParent("Date Items"))
    }

    val topReadItems by lazy {
        KRecyclerView(
            builder = { withId(R.id.feed_view) },
            itemTypeBuilder = { itemType(::TopReadItem) }
        ).name(withParent("Top Read Items"))
    }

    val inTheNewsItems by lazy {
        KRecyclerView(
            builder = { withId(R.id.feed_view) },
            itemTypeBuilder = { itemType(::InTheNewsItem) }
        ).name(withParent("In The News Items"))
    }

    val featuredArticleItems by lazy {
        KRecyclerView(
            builder = { withId(R.id.feed_view) },
            itemTypeBuilder = { itemType(::FeaturedArticleItem) }
        ).name(withParent("Featured Article Items"))
    }

    val search by lazy {
        KButton {
            withText(R.string.search_hint)
        }.name(withParent("Поиск"))
    }

    val items by lazy {
        KRecyclerView(
            builder = { withId(R.id.feed_view) },
            itemTypeBuilder = {
                itemType(::DateItem)
                itemType(::TopReadItem)
                itemType(::InTheNewsItem)
                itemType(::FeaturedArticleItem)
                itemType(::CustomizeItem)
            }).name(withParent("Список блоков"))
    }

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_container)
        }.name(withParent("Виджет поиска"))
    }
}

