package org.wikipedia.lesson09.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import androidx.compose.ui.test.hasText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher
import org.wikipedia.R

object CustomizeTheFeedScreen : KScreen<CustomizeTheFeedScreen>() {
    override val layoutId = null
    override val viewClass = null

    val contentTypesRecyclers = KRecyclerView(
        builder = { withId(R.id.content_types_recycler) },
        itemTypeBuilder = { itemType(::ContentTypesItem) }
    )

    val backToolbarButton = KButton {
        withParent { withId(R.id.toolbar) }
        isInstanceOf(AppCompatImageButton::class.java)
    }
}

class ContentTypesItem(matcher: Matcher<View>) : KRecyclerItem<ContentTypesItem>(matcher) {
    val switch = KCheckBox(matcher) { withId(R.id.feed_content_type_checkbox) }
}