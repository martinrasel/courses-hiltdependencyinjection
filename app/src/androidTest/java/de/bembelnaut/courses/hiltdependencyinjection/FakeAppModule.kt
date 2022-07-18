package de.bembelnaut.courses.hiltdependencyinjection

import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import de.bembelnaut.courses.hiltdependencyinjection.di.AppModule
import de.bembelnaut.courses.hiltdependencyinjection.di.OneString
import de.bembelnaut.courses.hiltdependencyinjection.di.OtherString
import javax.inject.Named

/**
 * If a module is replaced, then all provided methods must be replaced
 */
@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class],
)
object FakeAppModule {

    @Provides
    @Named(value = "ProvidedString")
    fun provideAProvideSting(): String {
        return "Provided Test test string"
    }

    @OneString
    @Provides
    fun provideOneString() = "Test test Blubb"

    @Provides
    @OtherString
    fun provideOtherString() = "Test test Blaaa"
}