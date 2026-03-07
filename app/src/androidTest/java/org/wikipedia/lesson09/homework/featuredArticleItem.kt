package org.wikipedia.lesson09.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class featuredArticleItem(matcher: Matcher<View>) : KRecyclerItem<featuredArticleItem>(matcher) {
    val articleImage = KImageView(matcher) { withId(R.id.articleImage) }
    val articleTitle = KTextView(matcher) { withId(R.id.articleTitle) }
    val articleDescription = KImageView(matcher) { withId(R.id.articleDescription) }
    val articleExtract = KTextView(matcher) { withId(R.id.articleExtract) }
}