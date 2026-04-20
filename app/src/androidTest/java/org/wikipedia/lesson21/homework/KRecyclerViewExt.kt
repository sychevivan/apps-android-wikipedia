package org.wikipedia.lesson21.homework

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.lesson18.getName
import org.wikipedia.lesson18.name
import org.wikipedia.lesson21.hasIdOrChildWithId

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndexAndResId(
    index: Int,
    resourceIdContains: Int,
    limit: Int = 10,
    skipItems: Int = 0,
    name: String = "$index",
    function: T.() -> Unit
) {
    val recycler = this
    val size = getSize()

    if (size == 0 || skipItems >= size) {
        throw IllegalStateException("Невозможно пропустить $skipItems элементов в списке размером $size")
    }

    var currentIndex = 0
    var isElementFoundByIndex = false

    val lastIndex = minOf(skipItems + limit, size) - 1
    val firstIndex = minOf(skipItems, lastIndex)

    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementContainsView = this.hasIdOrChildWithId(resourceIdContains)
            if (isElementContainsView && index == currentIndex++) {
                isElementFoundByIndex = true
                name(recycler.getName().withParent(name))
                function()
            }
        }
        if (isElementFoundByIndex) break
    }

    if (!isElementFoundByIndex) {
        throw IllegalStateException("Элемент с индексом $index в пределах ${lastIndex + 1} элементов не найден")
    }
}