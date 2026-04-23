package org.wikipedia.lesson22.homework

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent
import org.wikipedia.lesson22.KWidget

class FontSettingsWidget(builder: ViewBuilder.() -> Unit) : KWidget<FontSettingsWidget>(builder) {

    val textSettingsCategory by lazy{
        KTextView(matcher){
            withId(R.id.textSettingsCategory)
        }.name(withParent("Заоголовок настроек чтения"))
    }

    val textSizePercent by lazy {
        KTextView(matcher){
            withId(R.id.text_size_percent)
        }.name(withParent("Масштаб текста"))
    }

    val buttonDecreaseTextSize by lazy {
        KTextView(matcher){
            withId(R.id.buttonDecreaseTextSize)
        }.name(withParent("Кнопка уменьшения размера шрифта"))
    }

    val buttonIncreaseTextSize by lazy {
        KTextView(matcher){
            withId(R.id.buttonIncreaseTextSize)
        }.name(withParent("Кнопка увеличения размера шрифта"))
    }

    val textSizeSeekBar by lazy {
        KSeekBar(matcher){
            withId(R.id.text_size_seek_bar)
        }.name(withParent("Ползунок масштаба"))
    }

    val buttonFontFamilySansSerif by lazy {
        KButton(matcher){
            withId(R.id.button_font_family_sans_serif)
        }.name(withParent("Кнопка шрифта Sans Serif"))
    }

    val buttonFontFamilySerif by lazy {
        KButton(matcher){
            withId(R.id.button_font_family_serif)
        }.name(withParent("Кнопка шрифта Serif"))
    }
}