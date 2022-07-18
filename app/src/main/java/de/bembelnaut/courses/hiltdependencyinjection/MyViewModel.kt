package de.bembelnaut.courses.hiltdependencyinjection

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.bembelnaut.courses.hiltdependencyinjection.di.ViewModelScopedClass
import javax.inject.Inject

@HiltViewModel
class MyViewModel
@Inject
constructor(
    // This instance can only created in a viewmodel-scoped module!!!
    val viewModelScopedClass: ViewModelScopedClass,
    private val handle: SavedStateHandle,
) : ViewModel() {

    init {
        println("Get access to savestatehandle in viewmodel: $handle")
    }

}