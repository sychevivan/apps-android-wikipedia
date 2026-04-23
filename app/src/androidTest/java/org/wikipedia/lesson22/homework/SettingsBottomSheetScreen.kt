package org.wikipedia.lesson22.homework


import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson18.name

object SettingsBottomSheetScreen : NamedScreen<SettingsBottomSheetScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null
    override val screenName: String = "Экран с нижней панелью с настройками темы"

    val designBottomSheet by lazy {
        KView {
            withId(com.google.android.material.R.id.design_bottom_sheet)
        }.name(withParent("Нижняя панель с настройками темы"))
    }

    val fontSettingsWidget by lazy {
        FontSettingsWidget{
            withId(com.google.android.material.R.id.design_bottom_sheet)
        }.name(withParent("Виджет настроек шрифта"))
    }

    val themeSettingsWidget by lazy {
        ThemeSettingsWidget{
            withId(com.google.android.material.R.id.design_bottom_sheet)
        }.name(withParent("Виджет настроек тем"))
    }

    val readingFocusModeWidget by lazy {
        ReadingFocusModeWidget{
            withId(com.google.android.material.R.id.design_bottom_sheet)
        }.name(withParent("Виджет настроек режима фокусировки чтения"))
    }
}