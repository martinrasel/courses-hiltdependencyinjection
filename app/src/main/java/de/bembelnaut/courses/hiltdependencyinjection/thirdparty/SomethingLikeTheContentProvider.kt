package de.bembelnaut.courses.hiltdependencyinjection.thirdparty

import android.content.Context

abstract class SomethingLikeTheContentProvider(
    protected val context: Context
) {

    private val myText: String

    init {
        myText = "Entry point... ${this.doSomeThing()}"
    }

    protected abstract fun doSomeThing(): String

    fun printText() {
        println(myText)
    }
}