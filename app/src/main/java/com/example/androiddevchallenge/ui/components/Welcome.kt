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
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun Welcome(
    dark: Boolean,
    logIn: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(
                    id = if (dark) R.drawable.dark_welcome_bg else R.drawable.light_welcome_bg
                ),
                contentDescription = "Background"
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Image(
                    painter = painterResource(
                        id = if (dark) R.drawable.dark_welcome_illos else R.drawable.light_welcome_illos
                    ),
                    contentDescription = "Illos",
                    modifier = Modifier
                        .padding(top = 72.dp, start = 88.dp)
                        .fillMaxWidth()
                        .offset(
                            x = 16.dp
                        )
                        .wrapContentHeight()
                )

                Image(
                    painter = painterResource(
                        id = if (dark) R.drawable.dark_logo else R.drawable.light_logo
                    ),
                    contentDescription = "Bloom",
                    modifier = Modifier
                        .padding(top = 48.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                )

                Text(
                    text = "Beautiful home garden solutions",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .wrapContentHeight()
                        .paddingFromBaseline(top = 32.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.onPrimary,
                    textAlign = TextAlign.Center,
                )

                Button(
                    onClick = {
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                        .height(48.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        MaterialTheme.colors.secondary
                    )
                ) {
                    Text(
                        text = "Create account",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onSecondary,
                    )
                }

                TextButton(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    onClick = { logIn() }
                ) {
                    Text(
                        text = "Log in",
                        style = MaterialTheme.typography.button,
                        color = if (dark) white else pink900,
                        textAlign = TextAlign.Center,

                    )
                }
            }
        }
    }
}
