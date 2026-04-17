package org.wikipedia.lesson20

import android.view.View
import android.widget.TextView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert

class EqualsWithTrimAssertion(private val expected: String) : ViewAssertion {

    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (view == null) {
            throw (noViewFoundException ?: IllegalStateException("No view found"))
        }
        val actual = (view as? TextView)?.text?.toString()?.trim()
        if (actual == null) {
            throw IllegalStateException("It is not text view")
        }
        Assert.assertEquals(expected, actual)
    }
}