package com.hbs.mybrawlstars

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.hbs.mybrawlstars.domain.remote.api.HttpStatus
import com.hbs.mybrawlstars.ui.main.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
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
    var testRule = RuleChain.outerRule(HiltAndroidRule(this)).around(ActivityTestRule(MainActivity::class.java))

    @Test
    fun `IS_DISPLAY_TV_INFORMATION_API_TEST_IN_MAIN_ACTIVITY`() {
        //메인액티비티에서 tvInformationApiTest 뷰가 보이는지
        Espresso.onView(
            withId(R.id.tv_information_api_test)
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun `IS_MATCHING_TV_TITLE_EQUALS_TITLE_IN_MAIN_ACTIVITY`(){
        //메인액티비티에서 tvTitle 뷰에 값이 셋팅되어 있는지.
        Espresso.onView(withId(R.id.tv_title)).check(ViewAssertions.matches(ViewMatchers.withText("TITLE")))
    }

    @Test
    fun `IS_SUCCESS_API_RESULT`(){
        //API가 연결되었으면, 나오는 Text 확인
        runBlocking {
            delay(2000)
            Espresso.onView(withId(R.id.tv_information_api_test))
                .check(ViewAssertions.matches(ViewMatchers.withText(HttpStatus.SUCCESS.name)))
        }
    }
}
