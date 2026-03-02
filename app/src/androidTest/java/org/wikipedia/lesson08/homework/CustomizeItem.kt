package org.wikipedia.lesson08.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeItem>(matcher) {
    val headerImage = KImageView(matcher) { withId(R.id.view_announcement_header_image) }
    val announcementText = KImageView(matcher) { withId(R.id.view_announcement_text) }
    val customizeButton = KButton(matcher) { withId(R.id.view_announcement_action_positive) }
    val gotItButton = KButton(matcher) { withId(R.id.view_announcement_action_negative) }
}