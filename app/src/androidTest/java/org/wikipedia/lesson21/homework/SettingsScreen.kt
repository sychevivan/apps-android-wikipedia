package org.wikipedia.lesson21.homework

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

object SettingsScreenHW : NamedScreen<SettingsScreenHW>() {
    override val screenName = "Настройки"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val items = KRecyclerView(
        builder = { withId(R.id.recycler_view) },
        itemTypeBuilder = {
            itemType(::SettingsItemHW)
        }
    ).name(withParent("Settings Items"))

    fun blockWithCheckBox(index: Int, fnc: SettingsItemHW.() -> Unit) {
        items.invokeAtIndexAndResId(
            index,
            R.id.switchWidget,
            (index + 1) * 10,
            1,
            "$index блок с чекбоксом",
            fnc
        )
    }

    fun blockWithIcon(index: Int, fnc: SettingsItemHW.() -> Unit) {
        items.invokeAtIndexAndResId(
            index,
            R.id.right_icon,
            (index + 1) * 10,
            1,
            "$index блок с иконкой справа",
            fnc
        )
    }
}

class SettingsItemHW(matcher: Matcher<View>) : KRecyclerItem<SettingsItemHW>(matcher) {
    val title by lazy {
        KTextView(matcher) {
            withId(android.R.id.title)
        }.name(withParent("title"))
    }

    val switch by lazy {
        KCheckBox(matcher) {
            withId(R.id.switchWidget)
        }.name(withParent("switch"))
    }

    val rightIcon by lazy {
        KImageView(matcher) {
            withId(R.id.right_icon)
        }.name(withParent("rightIcon"))
    }
}


