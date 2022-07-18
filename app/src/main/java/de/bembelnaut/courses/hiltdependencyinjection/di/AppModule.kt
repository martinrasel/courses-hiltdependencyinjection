package de.bembelnaut.courses.hiltdependencyinjection.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.bembelnaut.courses.hiltdependencyinjection.SomeInterface
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Constructor injection is also not possible if you don't own the class because it comes
     * from an external library (classes like Retrofit, OkHttpClient, or Room databases),
     * or if instances must be created with the builder pattern.
     */
    @Provides
    @Named(value = "ProvidedString")
    fun provideAProvideSting(
        // Potential dependencies of this type...
        someInterface: SomeInterface,
    ): String {
        someInterface.aMethod()
        return "Provided string"
    }

    @OneString
    @Provides
    fun provideOneString() = "Blubb"

    @Provides
    @OtherString
    fun provideOtherString() = "Blaaa"

}