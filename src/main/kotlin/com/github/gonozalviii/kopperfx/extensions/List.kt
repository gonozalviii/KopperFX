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

import javafx.collections.ObservableList
import javafx.scene.control.ListView


/**
 * Observable lists
 */
operator fun <T> ObservableList<T>.plusAssign(list: ObservableList<T>) {
    this.addAll(list)
}

operator fun <T> ObservableList<T>.minusAssign(list: ObservableList<T>) {
    this.removeAll(list)
}

/**
 * ListView
 */
operator fun <T> ListView<T>.plusAssign(item: T) {
    this.items.add(item)
}

operator fun <T> ListView<T>.minusAssign(item: T) {
    this.items.remove(item)
}

fun <T> ListView<T>.addAt(index: Int, item: T) = this.items.add(index, item)

fun <T> ListView<T>.removeAt(index: Int): T? {
    return this.items.removeAt(index)
}

fun <T> ListView<T>.getItemFrom(index: Int): T = this.items[index]

fun <T> ListView<T>.addAll(vararg items: T) = this.items.addAll(items)

fun <T> ListView<T>.removeAll(vararg items: T) = this.items.removeAll(items)

fun <T> ListView<T>.removeRange(from: Int, to: Int) = this.items.remove(from, to)

fun <T> ListView<T>.removeRange(range: ClosedRange<Int>) = this.items.remove(range.start, range.endInclusive)

var <T> ListView<T>.focusedIndex
    get() = this.focusModel.focusedIndex
    set(index) = this.focusModel.focus(index)

val <T> ListView<T>.focusedItem: T?
    get() = this.focusModel.focusedItem

fun <T> ListView<T>.focusNext() = this.focusModel.focusNext()

fun <T> ListView<T>.focusPrevious() = this.focusModel.focusPrevious()

fun <T> ListView<T>.isFocused(index: Int) = this.focusModel.isFocused(index)

fun <T> ListView<T>.selectItem(item: T) = this.selectionModel.select(item)

fun <T> ListView<T>.selectIndex(index: Int) = this.selectionModel.select(index)

fun <T> ListView<T>.selectFirst() = this.selectionModel.selectFirst()

fun <T> ListView<T>.selectLast() = this.selectionModel.selectLast()

fun <T> ListView<T>.selectAll() = this.selectionModel.selectAll()

fun <T> ListView<T>.selectRange(start: Int, end: Int) = this.selectionModel.selectRange(start, end)

fun <T> ListView<T>.selectRange(range: ClosedRange<Int>) = this.selectionModel.selectRange(range.start, range.endInclusive)