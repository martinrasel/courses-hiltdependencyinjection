package de.bembelnaut.courses.someservicemodule

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SomeServiceModule {

    @Provides
    fun provideAnswer() = Answer()

}