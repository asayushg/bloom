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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.white
import com.example.androiddevchallenge.ui.theme.white150
import com.example.androiddevchallenge.ui.utils.loadPicture

@Composable
fun ImageCardItem(
    dark: Boolean,
    photoId: Int,
    name: String,
    indexFirst: Boolean,
    indexLast: Boolean
) {

    if (indexFirst) Spacer(modifier = Modifier.padding(start = 8.dp))

    Card(
        modifier = Modifier
            .width(150.dp)
            .wrapContentHeight()
            .padding(start = 8.dp, bottom = 4.dp),
        elevation = 1.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = if (dark) white150 else white
    ) {
        Column {
            val img = loadPicture(defaultImage = photoId)
            img.value?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "Photo",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(150.dp)
                        .height(100.dp)
                )
            }

            Text(
                text = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }

    if (indexLast) Spacer(modifier = Modifier.padding(start = 16.dp))
}
