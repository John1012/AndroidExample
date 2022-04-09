package com.example.androidexample.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val MediumGray = Color(0xFF9C9C9C)

val Colors.topAppBarContentColor: Color
    @Composable
    get() = Color.White

val Colors.topAppBarBackgroundColor: Color
    @Composable
    get() = Color.Red

val Colors.newsTitleTextColor: Color
    @Composable
    get() = Color.Black

val Colors.newsDescTextColor: Color
    @Composable
    get() = Color.Black