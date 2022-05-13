package com.example.util

import androidx.annotation.PluralsRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
// reference from https://issuetracker.google.com/issues/171516623

/**
 * Load a quantiy string resource.
 *
 * @param id the resource identifier
 * @return the string data associated with the resource
 */
@Composable
fun quantityStringResource(@PluralsRes id: Int, quantity: Int): String {
    val context = LocalContext.current
    return context.resources.getQuantityString(id, quantity)
}

/**
 * Load a quantiy string resource with formatting.
 *
 * @param id the resource identifier
 * @param formatArgs the format arguments
 * @return the string data associated with the resource
 */
@Composable
fun quantityStringResource(@PluralsRes id: Int, quantity: Int, vararg formatArgs: Any): String {
    val context = LocalContext.current
    return context.resources.getQuantityString(id, quantity, *formatArgs)
}