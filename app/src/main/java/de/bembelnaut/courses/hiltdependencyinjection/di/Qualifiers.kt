package de.bembelnaut.courses.hiltdependencyinjection.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OneString

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OtherString