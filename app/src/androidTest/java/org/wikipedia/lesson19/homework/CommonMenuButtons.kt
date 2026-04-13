package org.wikipedia.lesson19.homework

import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson18.name

object CommonMenuButtons : NamedScreen<CommonMenuButtons>() {

    override val screenName = "Нижнее меню"
    override val layoutId = null
    override val viewClass = null


    val moreButton by lazy {
        KButton {
            withId(R.id.nav_tab_more)
        }.name(withParent("Кнопка More"))
    }


    val settingsButton by lazy {
        KButton {
            withId(R.id.main_drawer_settings_container)
        }.name(withParent("Кнопка Settings"))
    }
}