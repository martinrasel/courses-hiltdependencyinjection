package de.bembelnaut.courses.hiltdependencyinjection.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.bembelnaut.courses.hiltdependencyinjection.SomeInterface
import de.bembelnaut.courses.hiltdependencyinjection.SomeInterfaceImpl


@Module
@InstallIn(SingletonComponent::class)
abstract class BindedAppModule {

    /**
     * The @Binds annotation tells Hilt which implementation to use when it needs to provide an instance of an interface.
     *
     * The instance must be instantiated with a default constructor or provided by @Inject.
     */
    @Binds
    abstract fun bindString(someInterfaceImpl: SomeInterfaceImpl): SomeInterface

}