package org.wikipedia.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object GameScreen : KScreen<GameScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val close = KButton {
        withId(R.id.closeButton)
    }
}