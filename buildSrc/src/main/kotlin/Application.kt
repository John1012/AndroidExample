import library.AndroidX
import library.Compose
import library.Espresso
import library.Google
import library.JUnit
import library.Kotlinx
import library.Ktor
import org.gradle.api.artifacts.dsl.DependencyHandler

object Application {
    const val appId = "com.example.androidexample"
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val minSdk = 21
    const val compileSdk = 30
    const val targetSdk = 30
    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"

    val appLibraries = listOf(
        AndroidX.appCompat,
        AndroidX.core,
        AndroidX.constraintLayout,
        AndroidX.lifecycleScope,
        Google.material,
        Compose.ui,
        Compose.material,
        Compose.activity,
        Ktor.ktorClientCore,
        Ktor.ktorClientAndroid,
        Ktor.ktorClientSerialization,
        Ktor.ktorClientLogging,
        Kotlinx.serialization
    )

    val debugLibraries = listOf(
        Compose.uiTooling
    )
    val testLibraries = listOf(
        JUnit.junit,
        Compose.uiTooling
    )

    val androidTestLibraries = listOf(
        JUnit.extJUnit,
        Espresso.espresso,
        Compose.uiTest
    )
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}
