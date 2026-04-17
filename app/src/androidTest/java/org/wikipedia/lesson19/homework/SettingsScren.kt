package org.wikipedia.lesson19.homework

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson18.invokeWithText
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent


object SettingsScren : NamedScreen<SettingsScren>() {

    override val screenName = "Экран настроек"
    override val layoutId = null
    override val viewClass = null


    val recyclerSettings by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.recycler_view)
            },
            itemTypeBuilder = {
                itemType(::RecyclerSettingsItem)
            }
        ).name(withParent("Список настроек"))
    }

    fun settingsItem(text: String, fnc: RecyclerSettingsItem.() -> Unit) {
        recyclerSettings.invokeWithText(text, fnc)
    }
}

class RecyclerSettingsItem(matcher: Matcher<View>) : KRecyclerItem<RecyclerSettingsItem>(matcher) {

    val showLinkPreviewsSwitch by lazy {
        KCheckBox(matcher) {
            withId(R.id.switchWidget)
        }.name(withParent("Переключатель настройки Show link previews"))
    }
}