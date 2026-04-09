package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class featuredArticleItem(matcher: Matcher<View>) : KRecyclerItem<featuredArticleItem>(matcher) {
    val articleImage by lazy {
        KImageView(matcher) { withId(R.id.articleImage) }
            .name(withParent("articleImage"))
    }
    val articleTitle by lazy {
        KTextView(matcher) { withId(R.id.articleTitle) }
            .name(withParent("articleTitle"))
    }
    val articleDescription by lazy {
        KImageView(matcher) { withId(R.id.articleDescription) }
            .name(withParent("articleDescription"))
    }
    val articleExtract by lazy {
        KTextView(matcher) { withId(R.id.articleExtract) }
            .name(withParent("articleExtract"))
    }
}