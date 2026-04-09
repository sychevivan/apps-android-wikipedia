package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class CustomizeItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeItem>(matcher) {
    val headerImage by lazy {
        KImageView(matcher) { withId(R.id.view_announcement_header_image) }
            .name(withParent("headerImage"))
    }
    val announcementText by lazy {
        KImageView(matcher) { withId(R.id.view_announcement_text) }
            .name(withParent("announcementText"))
    }
    val customizeButton by lazy {
        KButton(matcher) { withId(R.id.view_announcement_action_positive) }
            .name(withParent("customizeButton"))
    }
    val gotItButton by lazy {
        KButton(matcher) { withId(R.id.view_announcement_action_negative) }
            .name(withParent("gotItButton"))
    }
}