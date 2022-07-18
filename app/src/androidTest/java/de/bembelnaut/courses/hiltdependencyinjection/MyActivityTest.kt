package de.bembelnaut.courses.hiltdependencyinjection

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.activityScenarioRule
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import de.bembelnaut.courses.hiltdependencyinjection.di.BindedAppModule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
// uninstall a module only for a test
@UninstallModules(BindedAppModule::class)
class MyActivityTest {

    // Hilt rule must executed first
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    // optional!
    private val intent =
        Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
            .putExtra("title", "Testing rules!")

    @get:Rule(order = 1)
    val rule = activityScenarioRule<MainActivity>(intent)

    // Create or injekt the uninstalled components in the test itself
    @BindValue @JvmField
    val someInterfaceFake = object : SomeInterface {
        override fun aMethod() {
            println("Teeeeeeeeeeeeeeeeeeeeeeeeeest bindvalue")
        }
    }

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun myTest() {
        val scenario = rule.scenario

        scenario.onActivity {

        }

        scenario.close()
    }
}