package org.wikipedia.lesson20.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

object NavBarElements : KScreen<NavBarElements>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchButton = KButton {
        withId(R.id.nav_tab_search)
    }

    val moreButton = KButton {
        withId(R.id.nav_tab_more)
    }

    val settingsButton = KButton {
        withId(R.id.main_drawer_settings_container)
    }
}