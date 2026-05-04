package org.wikipedia.lesson18.homework

import androidx.appcompat.widget.AppCompatImageButton
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson18.invokeAtIndex
import org.wikipedia.lesson18.invokeWithText
import org.wikipedia.lesson18.name
import org.wikipedia.lesson21.invokeAtIndexAndClass
import org.wikipedia.lesson22.SearchWidget

/**
 * Экран Explore — главный фид Википедии.
 *
 * В фиде один и тот же RecyclerView (R.id.feed_view) содержит блоки разных типов:
 * Customize, Date, Top read, In the news, Featured article и т.д.
 *
 * Доступ к блокам идёт через единственный универсальный ресайклер [items], где
 * зарегистрированы конструкторы всех типов карточек. Каждая DSL-функция явно
 * указывает Kakao нужный тип через `<TypeItem>` — например
 * `items.invokeAtIndex<TopReadItem>(index, fnc)`. Раньше для каждого типа
 * блоков существовала отдельная «узкая» KRecyclerView-проекция с одним
 * itemType (см. закомментированные блоки в коде), но поведенчески они были
 * эквивалентны вызовам на [items], отличались только именем в Allure-отчёте.
 *
 * Высокоуровневый DSL: функции <name>Block / <name>Item / <name>ItemWithText
 * / <name>(index) — «найти блок и выполнить действия внутри него». Сам
 * ресайклер [items] обычно не нужен напрямую — исключение составляет
 * [featuredArticle], который сканирует фид по классу карточки через
 * [invokeAtIndexAndClass].
 */
object ExploreScreenHW : NamedScreen<ExploreScreenHW>() {

    // region ─── Метаданные экрана ───
    override val screenName = "Экран Explore"
    override val layoutId: Int = R.layout.fragment_feed
    override val viewClass = FeedView::class.java
    // endregion

    // region ─── Универсальный ресайклер фида ───
    /**
     * Список всех блоков фида со всеми зарегистрированными типами карточек.
     * Используется там, где блоки нужно искать не по тексту, а по классу
     * самой view-карточки (см. [featuredArticle]).
     */
    val items by lazy {
        KRecyclerView(
            builder = { withId(R.id.feed_view) },
            itemTypeBuilder = {
                itemType(::DateItem)
                itemType(::TopReadItem)
                itemType(::InTheNewsItem)
                itemType(::FeaturedArticleItem)
                itemType(::CustomizeItem)
            }).name(withParent("Список блоков"))
    }
    // endregion

    // region ─── Customize — баннер «Customize the feed» ───
    // Отдельный ресайклер с itemType(::CustomizeItem) больше не объявляется:
    // все запросы идут через универсальный [items], где CustomizeItem уже
    // зарегистрирован. Поведение функций ниже от этого не меняется — отличается
    // только имя в Allure-отчёте (вместо «Customize Items» — «Список блоков»).
    //
    // val customizeItems by lazy {
    //     KRecyclerView(
    //         builder = { withId(R.id.feed_view) },
    //         itemTypeBuilder = { itemType(::CustomizeItem) }
    //     ).name(withParent("Customize Items"))
    // }

    /**
     * Основной способ доступа: ищет единственный Customize-блок по тексту "Customize"
     * в шапке. Используйте, когда нужно открыть/проверить настройки фида.
     */
    fun customizeBlock(fnc: CustomizeItem.() -> Unit) {
        items.invokeWithText<CustomizeItem>("Customize", fnc)
    }

    /**
     * Доступ по абсолютной позиции в feed_view. Нужен редко — например, когда
     * Customize-блок специально размещён на конкретной позиции в тесте.
     */
    fun customizeItem(index: Int, fnc: CustomizeItem.() -> Unit) {
        items.invokeAtIndex<CustomizeItem>(index, fnc)
    }
    // endregion

    // region ─── Date — заголовки-разделители ("Today", "Yesterday", ...) ───
    // Отдельный ресайклер с itemType(::DateItem) больше не объявляется:
    // все запросы идут через универсальный [items], где DateItem уже
    // зарегистрирован. Поведение функций ниже от этого не меняется — отличается
    // только имя в Allure-отчёте (вместо «Date Items» — «Список блоков»).
    //
    // val dateItems by lazy {
    //     KRecyclerView(
    //         builder = { withId(R.id.feed_view) },
    //         itemTypeBuilder = { itemType(::DateItem) }
    //     ).name(withParent("Date Items"))
    // }

    /** Доступ к N-му дате-разделителю по абсолютной позиции в feed_view. */
    fun dateItem(index: Int, fnc: DateItem.() -> Unit) {
        items.invokeAtIndex<DateItem>(index, fnc)
    }
    // endregion

    // region ─── Top read — блок трендов дня ───
    // Отдельный ресайклер с itemType(::TopReadItem) больше не объявляется:
    // все запросы идут через универсальный [items], где TopReadItem уже зарегистрирован.
    // Поведение функций ниже от этого не меняется — отличается только имя в Allure-отчёте
    // (вместо «Top Read Items» в цепочке появляется «Список блоков»).
    //
    // val topReadItems by lazy {
    //     KRecyclerView(
    //         builder = { withId(R.id.feed_view) },
    //         itemTypeBuilder = { itemType(::TopReadItem) }
    //     ).name(withParent("Top Read Items"))
    // }

    /**
     * Основной способ доступа: ищет единственный блок «Top read» по тексту шапки.
     * Внутри лямбды доступны действия над TopReadItem (включая внутренний список
     * статей через cardListItem(index) / cardListItemWithText(text)).
     */
    fun topReadBlock(fnc: TopReadItem.() -> Unit) {
        items.invokeWithText<TopReadItem>("Top read", fnc)
    }

    /** Доступ к Top read по произвольному тексту внутри блока (например, по заголовку статьи). */
    fun topReadItemWithText(text: String, fnc: TopReadItem.() -> Unit) {
        items.invokeWithText<TopReadItem>(text, fnc)
    }

    /**
     * Доступ по абсолютной позиции в feed_view. Использовать осторожно: индекс
     * относится ко всему фиду, а не «к N-му блоку Top read».
     */
    fun topReadItem(index: Int, fnc: TopReadItem.() -> Unit) {
        items.invokeAtIndex<TopReadItem>(index, fnc)
    }
    // endregion

    // region ─── In the news — лента новостей ───
    // Отдельный ресайклер с itemType(::InTheNewsItem) больше не объявляется:
    // все запросы идут через универсальный [items], где InTheNewsItem уже
    // зарегистрирован. Поведение функций ниже от этого не меняется — отличается
    // только имя в Allure-отчёте (вместо «In The News Items» — «Список блоков»).
    //
    // val inTheNewsItems by lazy {
    //     KRecyclerView(
    //         builder = { withId(R.id.feed_view) },
    //         itemTypeBuilder = { itemType(::InTheNewsItem) }
    //     ).name(withParent("In The News Items"))
    // }

    /** Доступ к блоку «In the news» по любому тексту внутри (заголовку новости и т.п.). */
    fun inTheNewsItemWithText(text: String, fnc: InTheNewsItem.() -> Unit) {
        items.invokeWithText<InTheNewsItem>(text, fnc)
    }

    /** Доступ по абсолютной позиции в feed_view. */
    fun inTheNewsItem(index: Int, fnc: InTheNewsItem.() -> Unit) {
        items.invokeAtIndex<InTheNewsItem>(index, fnc)
    }
    // endregion

    // region ─── Featured article — статья дня ───
    // Отдельный ресайклер с itemType(::FeaturedArticleItem) больше не объявляется:
    // все запросы идут через универсальный [items], где FeaturedArticleItem уже
    // зарегистрирован. Поведение идентично — отличается только имя в Allure-отчёте.
    //
    // val featuredArticleItems by lazy {
    //     KRecyclerView(
    //         builder = { withId(R.id.feed_view) },
    //         itemTypeBuilder = { itemType(::FeaturedArticleItem) }
    //     ).name(withParent("Featured Article Items"))
    // }

    /**
     * Основной способ доступа: ищет N-й блок Featured Article по классу
     * FeaturedArticleCardView в общем ресайклере [items]. Использовать, когда
     * заголовок статьи дня заранее неизвестен (меняется по дате/локали),
     * а в фиде есть несколько таких блоков на разные дни.
     *
     * Скан ограничен диапазоном позиций [skipItems = 1, limit = (index + 1) * 10],
     * чтобы не перебирать весь фид.
     */
    fun featuredArticle(index: Int, fnc: FeaturedArticleItem.() -> Unit) {
        items.invokeAtIndexAndClass(
            index,
            FeaturedArticleCardView::class.java,
            (index + 1) * 10,
            1,
            "$index блок Featured Article",
            fnc
        )
    }

    /** Доступ к Featured Article по абсолютной позиции в feed_view. */
    fun featuredArticleItem(index: Int, fnc: FeaturedArticleItem.() -> Unit) {
        items.invokeAtIndex<FeaturedArticleItem>(index, fnc)
    }
    // endregion

    // region ─── Самостоятельные элементы экрана ───
    /** Кнопка поиска в верхней панели фида. */
    val search by lazy {
        KButton {
            withText(R.string.search_hint)
        }.name(withParent("Поиск"))
    }

    /** Карточка-виджет поиска внутри фида (поле ввода + микрофон). */
    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_container)
        }.name(withParent("Виджет поиска"))
    }
    // endregion
}
