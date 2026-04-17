package org.wikipedia.lesson20.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object SearchScreen : KScreen<SearchScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchField = KButton{
        withText(R.string.search_hint)
    }

    val searchFieldAfterClick = KEditText{
        withId(androidx.appcompat.R.id.search_src_text)
    }
}