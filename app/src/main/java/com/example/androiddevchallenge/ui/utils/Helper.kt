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
package com.example.androiddevchallenge.ui.utils

import androidx.compose.runtime.mutableStateOf
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.model.ListItem

object Helper {

    const val WELCOME = 0
    const val LOGIN = 1
    const val HOME = 2

    var rowList = listOf(

        ListItem(
            id = R.drawable.desert_chic,
            name = "Desert chic"
        ),

        ListItem(
            id = R.drawable.tiny_terrariums,
            name = "Tiny terrariums"
        ),

        ListItem(
            id = R.drawable.jungle_vibes,
            name = "Jungle vibes"
        ),

        ListItem(
            id = R.drawable.easy_care,
            name = "Easy care"
        )

    )

    var columnList = listOf(
        ListItem(
            id = R.drawable.monstera,
            name = "Monstera"
        ),
        ListItem(
            id = R.drawable.aglaonema,
            name = "Aglaonema"
        ),
        ListItem(
            id = R.drawable.peace_lily,
            name = "Peace lily"
        ),
        ListItem(
            id = R.drawable.fiddle_leaf,
            name = "Fiddle Leaf Tree"
        ),
        ListItem(
            id = R.drawable.pothos,
            name = "Pothos"
        ),

    )

    var navigationItems = listOf(

        ListItem(
            id = R.drawable.ic_home,
            name = "Home",
            selected = mutableStateOf(true)
        ),
        ListItem(
            id = R.drawable.ic_favorite_border,
            name = "Favorite"
        ),
        ListItem(
            id = R.drawable.ic_account_circle,
            name = "Profile"
        ),
        ListItem(
            id = R.drawable.ic_shopping_cart,
            name = "Cart"
        ),

    )
}
