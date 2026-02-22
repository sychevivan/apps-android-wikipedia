package org.wikipedia.lesson06.homework

import androidx.appcompat.widget.AppCompatImageView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object Settings : KScreen<Settings>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val textSettingsCategory = KTextView {
        withId(R.id.textSettingsCategory)
    }

    val textSizePercent = KTextView {
        withId(R.id.text_size_percent)
    }

    val buttonDecreaseTextSize = KTextView {
        withId(R.id.buttonDecreaseTextSize)
    }

    val buttonIncreaseTextSize = KTextView {
        withId(R.id.buttonIncreaseTextSize)
    }

    val textSizeSeekBar = KSeekBar {
        withId(R.id.text_size_seek_bar)
    }

    val buttonFontFamilySansSerif = KButton {
        withId(R.id.button_font_family_sans_serif)
    }

    val buttonFontFamilySerif = KButton {
        withId(R.id.button_font_family_serif)
    }

    val imageView = KImageView {
        withParent {
            withId(R.id.readingFocusModeContainer)
        }
        isInstanceOf(AppCompatImageView::class.java)
    }

    val themeChooserReadingFocusModeSwitch = KCheckBox {
        withId(R.id.theme_chooser_reading_focus_mode_switch)
    }

    val themeChooserReadingFocusModeDescription = KTextView {
        withId(R.id.theme_chooser_reading_focus_mode_description)
    }

    val colorThemeSelect = KTextView {
        withText(R.string.color_theme_select)
    }

    val buttonThemeLight = KTextView {
        withId(R.id.button_theme_light)
    }

    val buttonThemeSepia = KTextView {
        withId(R.id.button_theme_sepia)
    }

    val buttonThemeDark = KTextView {
        withId(R.id.button_theme_dark)
    }

    val buttonThemeBlack = KTextView {
        withId(R.id.button_theme_black)
    }

    val themeChooserDarkModeDimImagesSwitch = KCheckBox {
        withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    }
}

