package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class DateItem(matcher: Matcher<View>) : KRecyclerItem<DateItem>(matcher) {
    val date = KTextView(matcher) { withId(R.id.day_header_text) }
}