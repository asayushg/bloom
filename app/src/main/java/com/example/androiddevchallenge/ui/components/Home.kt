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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.utils.Helper

@Composable
fun Home(
    dark: Boolean
) {
    val query = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        topBar = {
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .height(56.dp)
                    .fillMaxWidth(),
                value = query.value,
                onValueChange = {
                    query.value = it
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = "Search",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            )
        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .fillMaxWidth()
            ) {

                for (item in Helper.navigationItems) {
                    BottomNavigationItem(
                        selected = item.selected.value,
                        onClick = {
                            resetItems()
                            item.selected.value = true
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        icon = {
                            Icon(
                                painter = painterResource(id = item.id),
                                contentDescription = null,
                            )
                        },
                        label = {
                            Text(
                                text = item.name,
                                style = MaterialTheme.typography.caption
                            )
                        }
                    )
                }
            }
        }
    ) {
        Column {

            Text(
                text = "Browse themes",
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 32.dp)
                    .padding(start = 16.dp, bottom = 16.dp),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary
            )

            LazyRow {
                itemsIndexed(
                    Helper.rowList
                ) { index, item ->
                    ImageCardItem(
                        dark = dark,
                        photoId = item.id,
                        name = item.name,
                        indexFirst = index == 0,
                        indexLast = index == (Helper.rowList.size - 1)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 32.dp)
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Design your home garden",
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onPrimary,
                )

                IconButton(
                    modifier = Modifier

                        .height(24.dp)
                        .width(24.dp),
                    onClick = { }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_filter_list),
                        contentDescription = "Filter"
                    )
                }
            }

            LazyColumn {
                itemsIndexed(Helper.columnList) { _, item ->
                    DesignListItem(
                        photoId = item.id,
                        name = item.name,
                        selected = item.selected
                    )
                }
            }
        }
    }
}

fun resetItems() {
    for (item in Helper.navigationItems) {
        item.selected.value = false
    }
}
