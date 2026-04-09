package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson08.homework.NewsItem
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent
import org.wikipedia.lesson18.invokeAtIndex
import org.wikipedia.lesson18.invokeWithText

class InTheNewsItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsItem>(matcher) {
    val headerTitle by lazy {
        KTextView(matcher) { withId(R.id.view_card_header_title) }
            .name(withParent("headerTitle"))
    }
    val headerMenu by lazy {
        KImageView(matcher) { withId(R.id.view_list_card_header_menu) }
            .name(withParent("headerMenu"))
    }
    val newsItems by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {withId(R.id.news_cardview_recycler_view)},
            itemTypeBuilder = {itemType(::NewsItem)}
        ).name(withParent("newsItems"))
    }

    fun newsItem(index: Int, fnc: NewsItem.() -> Unit) {
        newsItems.invokeAtIndex(index, fnc)
    }

    fun newsItemWithText(text: String, fnc: NewsItem.() -> Unit) {
        newsItems.invokeWithText(text, fnc)
    }
}