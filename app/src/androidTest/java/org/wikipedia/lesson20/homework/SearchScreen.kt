package org.wikipedia.lesson20.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson18.name
import org.wikipedia.lesson22.HistoryEmptyWidget
import org.wikipedia.lesson22.SearchWidget

object SearchScreen : NamedScreen<SearchScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null
    override val screenName: String = "Экран поиска"

    val searchField = KButton{
        withText(R.string.search_hint)
    }

    val searchFieldAfterClick = KEditText{
        withId(androidx.appcompat.R.id.search_src_text)
    }

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_card)
        }.name(withParent("Виджет поиска"))
    }

    val historyEmptyWidget by lazy {
        HistoryEmptyWidget{
            withId(R.id.history_empty_container)
        }.name(withParent("Виджет пустой истории"))
    }

}