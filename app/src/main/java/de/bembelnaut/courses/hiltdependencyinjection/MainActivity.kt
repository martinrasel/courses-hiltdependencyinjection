package de.bembelnaut.courses.hiltdependencyinjection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import de.bembelnaut.courses.hiltdependencyinjection.di.*
import de.bembelnaut.courses.hiltdependencyinjection.thirdparty.ExampleOfSomethingLikeTheContentProvider
import de.bembelnaut.courses.hiltdependencyinjection.ui.theme.HiltDependencyInjectionTheme
import de.bembelnaut.courses.someservicemodule.Answer
import javax.inject.Inject
import javax.inject.Named

/**
 * Markiert die Klasse für Dagger, dass diese Klasse in den Dagger-DI-Graph eingefügt werden soll, damit
 * Dagger @Inject ausführen kann.
 *
 * "Hilt can provide dependencies to other Android classes that have the @AndroidEntryPoint annotation..."
 *
 * "If you annotate an Android class with @AndroidEntryPoint, then you also must annotate Android classes that depend on it..."
 *
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /**
     * Field injection
     */
    @Inject
    lateinit var someClass: SomeClass

    @Inject
    @Named("ProvidedString")
    lateinit var someInjectedString: String

    @Inject
    @OneString
    lateinit var oneString: String

    @Inject
    @OtherString
    lateinit var otherString: String

    @Inject
    lateinit var unscopedClass: UnscopedClass

    @Inject
    lateinit var singeltonScopedClass: SingeltonScopedClass

    @Inject
    lateinit var activityScoped: ActivityScopedClass

    @Inject
    lateinit var someInterface: SomeInterface

    @Inject
    lateinit var answer: Answer

    // Dos not work because of the scope!
//    @Inject
//    lateinit var viewModelScoped: ViewModelScopedClass

    // Hilt will provide the viewmodel
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println(someClass.print())
        println(someClass.printAgain())
        println(someInjectedString)
        println(oneString)
        println(otherString)
        someInterface.aMethod()
        unscopedClass.printHello()
        singeltonScopedClass.printHello()
        activityScoped.printHello()
        myViewModel.viewModelScopedClass.printHello()

        answer.printAnswer()

        ExampleOfSomethingLikeTheContentProvider(this.applicationContext).printText()

        setContent {
            HiltDependencyInjectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        Modifier.testTag("helloTag")
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HiltDependencyInjectionTheme {
        Greeting("Android")
    }
}

/**
 * Konstruktor-Injektion
 *
 * The @Inject annotation on the constructor of a class to tell Hilt how to provide instances of that class
 *
 */
class SomeClass
@Inject
constructor(
    private val someOtherClass: SomeOtherClass,
) {
    fun print() = "Whoop Whoop!"

    fun printAgain() = someOtherClass.print()
}

class SomeOtherClass
@Inject
constructor() {
    fun print() = "Whoop Whoop, again!!"
}
