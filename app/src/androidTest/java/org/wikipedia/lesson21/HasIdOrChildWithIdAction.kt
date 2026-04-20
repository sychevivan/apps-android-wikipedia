package org.wikipedia.lesson21

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class HasIdOrChildWithIdAction(private val resourceId: Int) : ViewAction {

    private var result = false

    override fun getDescription() = "Check that view contains view with specified resource id"

    override fun getConstraints(): Matcher<View> = ViewMatchers.isAssignableFrom(View::class.java)

    override fun perform(uiController: UiController?, view: View?) {
        if (view == null) throw IllegalStateException("View not submitted")
        if (view.id == resourceId) {
            result = true
        } else {
            val foundView = view.findViewById<View>(resourceId)
            result = foundView != null
        }
    }

    fun getResult() = result
}