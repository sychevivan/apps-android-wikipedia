package org.wikipedia.lesson22.homework

import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent
import org.wikipedia.lesson22.KWidget

class ReadingFocusModeWidget(builder: ViewBuilder.() -> Unit) :
    KWidget<ReadingFocusModeWidget>(builder) {

    val iamgeGlasses by lazy{
        KImageView(matcher){
            isInstanceOf(AppCompatImageView::class.java)
            isDisplayed()
        }.name(withParent("Картинка с очками"))
    }

    val themeChooserReadingFocusModeSwitch by lazy{
        KSwitch(matcher){
            withId(R.id.theme_chooser_reading_focus_mode_switch)
        }.name(withParent("Переключатель режима фокусировки чтения"))
    }

    val themeChooserReadingFocusModeDescription by lazy{
        KTextView(matcher){
            withId(R.id.theme_chooser_reading_focus_mode_description)
        }.name(withParent("Описание переключателя"))
    }
}