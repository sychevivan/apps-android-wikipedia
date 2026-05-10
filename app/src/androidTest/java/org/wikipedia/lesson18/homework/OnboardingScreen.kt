package org.wikipedia.lesson18.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.NameHierarchy
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson18.invokeAtIndex
import org.wikipedia.lesson18.invokeWithText
import org.wikipedia.lesson18.invokeByIndex
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent
import org.wikipedia.onboarding.OnboardingPageView

object OnboardingScreen : NamedScreen<OnboardingScreen>() {

    override val screenName = "Экран онбординга"
    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = OnboardingPageView::class.java

    fun page(index: Int, fnc: PagerItem.() -> Unit) {
        pager.invokeByIndex(index, fnc)
    }

    val pager by lazy {
        KViewPager2(
            builder = {
                withId(R.id.fragment_pager)
            },
            itemTypeBuilder = {
                itemType(::PagerItem)
            }
        ).name(withParent("Слайдер"))
    }

    val skip by lazy {
        KButton {
            withId(R.id.fragment_onboarding_skip_button)
        }.name(withParent("Кнопка Skip"))
    }

    val tab by lazy {
        KTabLayout {
            withId(R.id.view_onboarding_page_indicator)
        }.name(withParent("Табы"))
    }

    val backToolbarButton = KButton {
        withParent { withId(R.id.toolbar) }
        isInstanceOf(AppCompatImageButton::class.java)
    }.name(withParent("Кнопка назад на тулбаре"))
}

class PagerItem(matcher: Matcher<View>) : KViewPagerItem<PagerItem>(matcher) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.imageViewCentered)
        }.name(withParent("Картинка"))
    }

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.primaryTextView)
        }.name(withParent("Заголовок"))
    }

    val languages by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.languagesList)
            },
            itemTypeBuilder = {
                itemType(::LanguageItem)
            }
        ).name(withParent("Список языков"))
    }

    val addLanguages by lazy {
        KButton(matcher) {
            withId(R.id.addLanguageButton)
        }.name(withParent("Кнопка добавления языка"))
    }

    fun languagesBlockByIndex(index: Int, fnc: LanguageItem.() -> Unit) {
        languages.invokeAtIndex<LanguageItem>(index, fnc)
    }

    fun languagesBlockByText(text: String, fnc: LanguageItem.() -> Unit) {
        languages.invokeWithText<LanguageItem>(text, fnc)
    }
}

class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<LanguageItem>(matcher), TextViewAssertions