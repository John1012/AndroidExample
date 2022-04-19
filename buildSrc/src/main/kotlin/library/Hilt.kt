package library

object Hilt {
    private const val hiltVersion = "2.40.2"
    val plugin = "com.google.dagger:hilt-android-gradle-plugin:${hiltVersion}"
    val hilt = "com.google.dagger:hilt-android:${hiltVersion}"
    val hiltProcessor = "com.google.dagger:hilt-android-compiler:${hiltVersion}"
    val processor = "com.google.dagger:hilt-compiler:${hiltVersion}"
}