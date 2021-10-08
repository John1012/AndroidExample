import library.*

object Build {
    private const val gradleBuildTools = "7.0.2"
    private const val serialization = "1.5.21"
    const val buildTools = "com.android.tools.build:gradle:${gradleBuildTools}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    const val SerializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${serialization}"
}