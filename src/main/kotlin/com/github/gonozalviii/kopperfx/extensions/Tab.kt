/*
 * Copyright 2018 Peer Schoenhusen & Ramon Victor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.gonozalviii.kopperfx.extensions

import javafx.scene.control.Tab
import javafx.scene.control.TabPane


/**
 * TabPane
 */
operator fun TabPane.plusAssign(tab: Tab) {
    this.tabs += tab
}

operator fun TabPane.minusAssign(tab: Tab) {
    this.tabs -= tab
}

fun TabPane.addAll(vararg tabs: Tab) = this.tabs.addAll(tabs)

fun TabPane.removeAll(vararg tabs: Tab) = this.tabs.removeAll(tabs)

fun TabPane.addAt(index: Int, tab: Tab) = this.tabs.add(index, tab)

fun TabPane.removeAt(index: Int) = this.tabs.removeAt(index)

fun TabPane.removeRange(from: Int, to: Int) = this.tabs.remove(from, to)

fun TabPane.selectFirst() = this.selectionModel.selectFirst()

fun TabPane.selectLast() = this.selectionModel.selectLast()

fun TabPane.selectNext() = this.selectionModel.selectNext()

fun TabPane.selectPrevious() = this.selectionModel.selectPrevious()

var TabPane.selectedIndex: Int
    get() = this.selectionModel.selectedIndex
    set(index) = this.selectionModel.select(index)

var TabPane.selectedItem: Tab
    get() = this.selectionModel.selectedItem
    set(item) = this.selectionModel.select(item)