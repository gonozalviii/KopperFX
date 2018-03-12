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

import javafx.scene.control.TableView


/**
 * TableView
 */
operator fun <T> TableView<T>.plusAssign(item: T) {
    this.items.add(item)
}

operator fun <T> TableView<T>.minusAssign(item: T) {
    this.items.remove(item)
}

fun <T> TableView<T>.addAll(vararg items: T) = this.items.addAll(items)

fun <T> TableView<T>.removeAll(vararg items: T) = this.items.removeAll(items)

fun <T> TableView<T>.getSelectedItems() = this.selectionModel.selectedItems

fun <T> TableView<T>.focusIndex(index: Int) = this.focusModel.focus(index)

fun <T> TableView<T>.getIndexOf(item: T) = this.items.indexOf(item)

var <T> TableView<T>.selectedIndex: Int
    get() = this.selectionModel.selectedIndex
    set(index) = this.selectionModel.select(index)

var <T> TableView<T>.selectedItem: T
    get() = this.selectionModel.selectedItem
    set(item) = this.selectionModel.select(item)