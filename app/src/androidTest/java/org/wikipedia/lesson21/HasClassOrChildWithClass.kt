package org.wikipedia.lesson21

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class HasClassOrChildWithClass(private val expectedClass: Class<out View>) : ViewAction {

    private var result = false

    override fun getDescription() = "Check that view has class or contains view with class"

    override fun getConstraints(): Matcher<View> = ViewMatchers.isAssignableFrom(View::class.java)

    override fun perform(uiController: UiController?, view: View?) {
        result = view?.let {
            checkInnerViewsClassContains(it, expectedClass)
        } ?: throw IllegalStateException("View not submitted")
    }

    private fun checkInnerViewsClassContains(view: View, expectedClass: Class<out View>): Boolean {
        if (expectedClass.isAssignableFrom(view::class.java)) return true
        if (view is ViewGroup) {
            view.children.forEach {
                if (checkInnerViewsClassContains(it, expectedClass)) return true
            }
        }
        return false
    }

    fun getResult() = result
}