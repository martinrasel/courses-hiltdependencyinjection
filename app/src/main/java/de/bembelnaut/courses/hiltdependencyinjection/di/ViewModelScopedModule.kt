package de.bembelnaut.courses.hiltdependencyinjection.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelScopedModule {

    @Provides
    fun provideViewModelScopedClass(
        viewModelScopedClassImpl: ViewModelScopedClassImpl,
    ): ViewModelScopedClass {
        return viewModelScopedClassImpl
    }

}


interface ViewModelScopedClass {
    fun printHello()
}

@ViewModelScoped
class ViewModelScopedClassImpl
@Inject
constructor() : ViewModelScopedClass {
    private val randomInt: Int = IntRange(1, 1000).random()

    init {
        println("Created ViewModelScopedClass")
    }

    override fun printHello() {
        println("Hello!!! ${randomInt}")
    }
}