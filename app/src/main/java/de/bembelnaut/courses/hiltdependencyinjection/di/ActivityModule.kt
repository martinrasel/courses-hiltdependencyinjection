package de.bembelnaut.courses.hiltdependencyinjection.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

/**
 * For each Android class in which you can perform field injection,
 * there's an associated Hilt component that you can refer to in the @InstallIn annotation.
 *
 * SingletonComponent -> Application
 * ActivityRetainedComponent -> n/A
 * ViewModelComponent -> ViewModel
 * ActivityComponent -> Activity
 * FragmentComponent -> Fragment
 * ViewComponent -> View
 * ViewWithFragmentComponent -> View annotated with @WithFragmentBindings
 * ServiceComponent -> Service
 *
 * Hilt automatically creates and destroys instances of generated component classes:
 * SingletonComponent	Application#onCreate()	Application destroyed
 * ...
 *
 * By default, all bindings in Hilt are unscoped. This means that each time your
 * app requests the binding, Hilt creates a *new instance* of the needed type.
 *
 * Hilt also allows a binding to be scoped to a particular component.
 *
 */
@Module
@InstallIn(ActivityComponent::class)
object SomeActivityModule {

    // Hilt created each time a new instance
    @Provides
    fun provideUnscopedClass(
        unscopedClassImpl: UnscopedClassImpl,
    ): UnscopedClass {
        return unscopedClassImpl
    }

    // Hilt create only once this instance
    @Provides
    fun provideSingeltonScopedClass(
        singeltonScopedClassImpl: SingeltonScopedClassImpl,
    ): SingeltonScopedClass {
        return singeltonScopedClassImpl
    }

    // Hilt create after this instance for each new activity
    @Provides
    fun provideActivityScopedClass(
        activityScopedClassImpl: ActivityScopedClassImpl,
    ): ActivityScopedClass {
        return activityScopedClassImpl
    }

    // Hilt cannot create this instance, because the scope viewmodel is below activity.
    // --> it must be instanciated in viewmodel-scoped module!!!
//    @Provides
//    fun provideViewModelScopedClass(
//        viewModelScopedClassImpl: ViewModelScopedClassImpl,
//    ): ViewModelScopedClass {
//        return viewModelScopedClassImpl
//    }
}

interface UnscopedClass {
    fun printHello()
}

class UnscopedClassImpl
@Inject
constructor() : UnscopedClass {
    private val randomInt: Int = IntRange(1, 1000).random()

    init {
        println("Created UnscopedClass")
    }

    override fun printHello() {
        println("Hello!!! ${randomInt}")
    }
}


interface SingeltonScopedClass {
    fun printHello()
}

@Singleton
class SingeltonScopedClassImpl
@Inject
constructor() : SingeltonScopedClass {
    private val randomInt: Int = IntRange(1, 1000).random()

    init {
        println("Created SingeltonScopedClass")
    }

    override fun printHello() {
        println("Hello!!! ${randomInt}")
    }
}


interface ActivityScopedClass {
    fun printHello()
}

@ActivityScoped
class ActivityScopedClassImpl
@Inject
constructor() : ActivityScopedClass {
    private val randomInt: Int = IntRange(1, 1000).random()

    init {
        println("Created ActivityScopedClass")
    }

    override fun printHello() {
        println("Hello!!! ${randomInt}")
    }
}
