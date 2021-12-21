package com.example.androidexample.data.models

import androidx.compose.ui.graphics.Color
import com.example.ktorexample.ui.theme.HighPriorityColor
import com.example.ktorexample.ui.theme.LowPriorityColor
import com.example.ktorexample.ui.theme.MediumPriorityColor
import com.example.ktorexample.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}