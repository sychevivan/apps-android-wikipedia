package org.wikipedia.lesson13.homework

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

object ReferencesScreen : KScreen<ReferencesScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val referenceTitle = KTextView {
        withId(R.id.reference_title_text)
    }

    val items = KRecyclerView(
        builder = { withParent { withId(R.id.reference_pager) } },
        itemTypeBuilder = { itemType(::ReferenceItem) }
    )
}

class ReferenceItem(matcher: Matcher<View>) : KRecyclerItem<ReferenceItem>(matcher) {
    val referenceId = KTextView(matcher) {
        withId(R.id.reference_id)
    }
    
    val referenceText = KTextView(matcher) {
        withId(R.id.reference_text)
    }
}