package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText

object SearchScreen : KScreen<SearchScreen>() {
    override val layoutId = null
    override val viewClass = null

    val edit = KEditText {
        withId(androidx.appcompat.R.id.search_src_text)
    }
}