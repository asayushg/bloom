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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.components.Home
import com.example.androiddevchallenge.ui.components.LogIn
import com.example.androiddevchallenge.ui.components.Welcome
import com.example.androiddevchallenge.ui.theme.AppTheme
import com.example.androiddevchallenge.ui.utils.Helper.HOME
import com.example.androiddevchallenge.ui.utils.Helper.LOGIN
import com.example.androiddevchallenge.ui.utils.Helper.WELCOME

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val screen = remember { mutableStateOf(WELCOME) }
            val dark = remember { mutableStateOf(true) }
            AppTheme(darkTheme = dark.value) {
                MyApp(screen, dark = dark.value)
            }
        }
    }
}

// Start building your app here!

@Composable
fun MyApp(screen: MutableState<Int>, dark: Boolean) {
    when (screen.value) {
        WELCOME -> Welcome(
            dark = dark,
            logIn = { screen.value = LOGIN }
        )
        LOGIN -> LogIn(
            logIn = { screen.value = HOME }
        )
        else -> Home(
            dark = dark
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    AppTheme(darkTheme = false) {
        MyApp(mutableStateOf(HOME), false)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    AppTheme(darkTheme = true) {
        MyApp(mutableStateOf(HOME), true)
    }
}
