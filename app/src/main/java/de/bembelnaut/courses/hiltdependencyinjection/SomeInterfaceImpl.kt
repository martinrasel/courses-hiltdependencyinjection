package de.bembelnaut.courses.hiltdependencyinjection

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

// Constructor-injected, because Hilt needs to know how to
// provide instances of AnalyticsServiceImpl, too.
class SomeInterfaceImpl
@Inject
constructor(): SomeInterface {

    override fun aMethod() {
        println("This is a mathod...")
    }
}