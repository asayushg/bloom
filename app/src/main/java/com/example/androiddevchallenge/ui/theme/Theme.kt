/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightThemeColors = lightColors(
    primary = pink100,
    onPrimary = gray,
    secondary = pink900,
    onSecondary = Color.White,
    background = Color.White,
    onBackground = gray,
    surface = white850,
    onSurface = gray,
)

private val DarkThemeColors = darkColors(
    primary = green900,
    onPrimary = Color.White,
    secondary = green300,
    onSecondary = gray,
    background = gray,
    onBackground = Color.White,
    surface = white150,
    onSurface = white850,
)

@Composable
fun AppTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit,
) {

    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = NunitoSansTypography,
        shapes = AppShapes
    ) {
        content()
    }
}
