package library

object Kotlinx {
    private const val serializationVersion = "1.3.1"
    private const val coroutineVersion = "1.6.0"
    private const val dateTimeVersion = "0.3.2"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion"
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion"
    const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion"
}