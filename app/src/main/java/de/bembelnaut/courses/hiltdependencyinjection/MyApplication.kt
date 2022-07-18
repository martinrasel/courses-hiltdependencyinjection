package de.bembelnaut.courses.hiltdependencyinjection

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*
 * Generiert die AppComponent, SubComponents, Module... und verknüpft sie miteinander
 */
@HiltAndroidApp
class MyApplication : Application() {
}