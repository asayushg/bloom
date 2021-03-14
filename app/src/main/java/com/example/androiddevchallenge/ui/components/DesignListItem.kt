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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.utils.loadPicture

@Composable
fun DesignListItem(
    photoId: Int,
    name: String,
    selected: MutableState<Boolean>
) {

    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
    ) {

        val img = loadPicture(defaultImage = photoId)
        img.value?.let {
            Card(
                modifier = Modifier
                    .height(64.dp)
                    .width(64.dp),
                shape = MaterialTheme.shapes.small,
                elevation = 1.dp
            ) {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "Photo",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(64.dp)
                        .width(64.dp),
                )
            }
        }

        Row {

            Column {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = name,
                            modifier = Modifier
                                .wrapContentWidth()
                                .padding(start = 8.dp)
                                .paddingFromBaseline(top = 24.dp),
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.h2,
                            color = MaterialTheme.colors.onPrimary
                        )

                        Text(
                            text = "This is a description",
                            modifier = Modifier
                                .wrapContentWidth()
                                .padding(start = 8.dp)
                                .paddingFromBaseline(bottom = 24.dp),
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }

                    Checkbox(
                        modifier = Modifier
                            .fillMaxHeight()
                            .align(Alignment.CenterVertically),
                        checked = selected.value,
                        onCheckedChange = {
                            selected.value = it
                        }
                    )
                }

                Divider(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth()
                        .height(1.dp),
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}
