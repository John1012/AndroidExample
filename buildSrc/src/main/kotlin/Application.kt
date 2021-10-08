import library.*
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
        Ktor.ktorClientCore,
        Ktor.ktorClientAndroid,
        Ktor.ktorClientSerialization,
        Ktor.ktorClientLogging,
        Kotlinx.serialization
    )

    val testLibraries = listOf(
        JUnit.junit
    )

    val androidTestLibraries = listOf(
        JUnit.extJUnit,
        Espresso.espresso
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
