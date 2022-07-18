package de.bembelnaut.courses.hiltdependencyinjection.thirdparty

import android.content.Context
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

class ExampleOfSomethingLikeTheContentProvider(
    context: Context
) : SomethingLikeTheContentProvider(context) {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface ExampleEntryPoint {
        @Named(value = "ProvidedString")
        fun myString(): String
    }

    override fun doSomeThing(): String {
        val hiltEntryPoint =
            EntryPointAccessors.fromApplication(context, ExampleEntryPoint::class.java)

        return hiltEntryPoint.myString()
    }
}