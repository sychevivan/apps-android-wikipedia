package org.wikipedia.lesson20.homework

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
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


object SettingsScren : KScreen<SettingsScren>() {

    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val recyclerSettings = KRecyclerView(
        builder = {
            withId(R.id.recycler_view)
        },
        itemTypeBuilder = {
            itemType(::RecyclerSettingsItem)
        }
    )

    fun settingsItem(text: String, fnc: RecyclerSettingsItem.() -> Unit) {
        recyclerSettings.invokeWithText(text, fnc)
    }


}

class RecyclerSettingsItem(matcher: Matcher<View>) : KRecyclerItem<RecyclerSettingsItem>(matcher) {

    val switch = KCheckBox(matcher) {
        withId(R.id.switchWidget)
    }
}