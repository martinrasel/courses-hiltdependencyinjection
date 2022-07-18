package de.bembelnaut.courses.hiltdependencyinjection

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

// HiltTestApplication must be created by the runner. Set custom runner in build.gradle
// HiltTestApplication is the default test application...
class CustomTestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}