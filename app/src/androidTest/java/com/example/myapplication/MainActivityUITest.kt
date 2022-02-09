package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.ui.MainActivity
import com.jakewharton.espresso.OkHttp3IdlingResource
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityUITest {

    private val viewScreen = PostViewScreen()

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    private lateinit var activityRule: ActivityScenario<MainActivity>

    private val mockWebServer by lazy { MockWebServer() }

    @Before
    fun setUp() {
        mockWebServer.start(8080)
        hiltRule.inject()
        activityRule = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun inflate_view_onStart() {
        mockWebServer.dispatcher = SuccessDispatchers()
        viewScreen {
            recycler {
                isDisplayed()
                for (i in 0..2) {
                    childAt<PostItem>(i) {
                        title.hasText("ankit " + (i + 1))
                    }
                }
            }
        }

    }
}