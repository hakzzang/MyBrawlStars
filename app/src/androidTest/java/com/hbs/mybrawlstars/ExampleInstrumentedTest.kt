package com.hbs.mybrawlstars

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.hbs.mybrawlstars.ui.main.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ExampleInstrumentedTest {
    @get:Rule
    var testRule = RuleChain.outerRule(HiltAndroidRule(this))
        .around(ActivityTestRule(MainActivity::class.java))

    @Test
    fun `메인액티비티_초기화면이_보이는지_테스트`() {
        Espresso.onView(
            withId(R.id.tv_information_api_test)
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun `메인액티비티에_TITLE이_출력되는지_테스트`(){
        Espresso.onView(withId(R.id.tv_title)).check(ViewAssertions.matches(ViewMatchers.withText("TITLE")))
    }

}
