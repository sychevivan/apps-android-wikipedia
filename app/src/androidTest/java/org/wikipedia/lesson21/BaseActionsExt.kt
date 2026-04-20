package org.wikipedia.lesson21

import android.view.View
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.lesson18.getName
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent
import kotlin.math.min

fun BaseActions.hasIdOrChildWithId(resourceId: Int): Boolean {
    val hasIdOrChildWithIdIdAction = HasIdOrChildWithIdAction(resourceId)
    view.perform(hasIdOrChildWithIdIdAction)
    return hasIdOrChildWithIdIdAction.getResult()
}

fun BaseActions.hasClassOrChildWithClass(clazz: Class<out View>): Boolean {
    val hasClassOrChildWithClass = HasClassOrChildWithClass(clazz)
    view.perform(hasClassOrChildWithClass)
    return hasClassOrChildWithClass.getResult()
}

// inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndexAndClass(
//     index: Int,
//     limit: Int,
//     startWith: Int,
//     clazz: Class<out View>,
//     blokName: String = "$index",
//     fnc: T.() -> Unit
// ) {
//     val numberOfElements = this.getSize()
//     val lastIndex = min(limit, numberOfElements - 1)
//     val firstIndex = min(startWith, lastIndex)
//     var counter = 0
//     val recycler = this
//     for (i in firstIndex..lastIndex) {
//         childAt<T>(i) {
//             val isElementWithClass = hasClassOrChildWithClass(clazz)
//             if (isElementWithClass && counter == index) {
//                 counter++
//                 name(recycler.getName().withParent(blokName))
//                 fnc()
//                 return
//             }
//         }
//     }
// }

// inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndexAndClass(
//     index: Int,
//     clazz: Class<out View>,
//     limit: Int = 10,
//     skipItems: Int = 0,
//     name: String = "$index",
//     function: T.() -> Unit
// ) {
//     val recycler = this
//     var currentIndex = 0
//     var isElementFoundByIndex = false
//     val lastIndex = (limit + skipItems).coerceAtMost(getSize()) - 1
//     val firstIndex = skipItems.coerceAtMost(lastIndex)
//     for (i in firstIndex..lastIndex) {
//         childAt<T>(i) {
//             val isElementContainsView = this.hasClassOrChildWithClass(clazz)
//             if (isElementContainsView && index == currentIndex++) {
//                 isElementFoundByIndex = true
//                 name(recycler.getName().withParent(name))
//                 function()
//             }
//         }
//         if (isElementFoundByIndex) break
//     }
//     if (!isElementFoundByIndex) {
//         throw IllegalStateException("Элемент с индексом $index в пределах ${lastIndex + 1} элементов не найден")
//     }
// }


inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndexAndClass(
    index: Int,
    clazz: Class<out View>,
    limit: Int = 10,
    skipItems: Int = 0,
    name: String = "$index",
    function: T.() -> Unit
) {
    val recycler = this
    val size = getSize()

    // Защита от пустого списка или выхода за границы
    if (size == 0 || skipItems >= size) {
        throw IllegalStateException("Невозможно пропустить $skipItems элементов в списке размером $size")
    }

    var currentIndex = 0
    var isElementFoundByIndex = false
    val firstIndex = skipItems
    val lastIndex = minOf(skipItems + limit, size) - 1

    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementContainsView = this.hasClassOrChildWithClass(clazz)
            if (isElementContainsView && index == currentIndex++) {
                isElementFoundByIndex = true
                name(recycler.getName().withParent(name))
                function()
            }
        }
        if (isElementFoundByIndex) break
    }

    if (!isElementFoundByIndex) {
        throw IllegalStateException("Элемент с индексом $index не найден")
    }
}
