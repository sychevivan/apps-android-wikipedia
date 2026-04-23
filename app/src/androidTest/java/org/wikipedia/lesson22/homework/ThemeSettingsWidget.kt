package org.wikipedia.lesson22.homework

import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent
import org.wikipedia.lesson22.KWidget

class ThemeSettingsWidget(builder: ViewBuilder.() -> Unit) : KWidget<ThemeSettingsWidget>(builder) {

    val textDisplayCategory by lazy {
        KTextView(matcher) {
            // withText("Оформление")
            isInstanceOf(MaterialTextView::class.java)
            isDisplayed()
        }.name(withParent("Заголовок категории оформления"))
    }

    val buttonThemeLight by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_light)
        }.name(withParent("Кнопка светлой темы"))
    }

    val buttonThemeSepia by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_sepia)
        }.name(withParent("Кнопка темы сепия"))
    }

    val buttonThemeDark by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_dark)
        }.name(withParent("Кнопка тёмной темы"))
    }

    val buttonThemeBlack by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_black)
        }.name(withParent("Кнопка чёрной темы"))
    }

    val themeChooserMatchSystemThemeSwitch by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_match_system_theme_switch)
        }.name(withParent("Переключатель соответствия системной теме"))
    }

    val themeChooserDarkModeDimImagesSwitch by lazy {
        KCheckBox(matcher) {
            withId(R.id.theme_chooser_dark_mode_dim_images_switch)
        }.name(withParent("Переключатель затемнения изображений"))
    }
}
