package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class DateItem(matcher: Matcher<View>) : KRecyclerItem<DateItem>(matcher) {
    val date by lazy {
        KTextView(matcher) { withId(R.id.day_header_text) }
            .name(withParent("date"))
    }
}