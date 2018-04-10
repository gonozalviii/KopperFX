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

import javafx.scene.control.ChoiceBox


/**
 * ChoiceBox
 */
operator fun <T> ChoiceBox<T>.plusAssign(item: T) {
    this.items.add(item)
}

operator fun <T> ChoiceBox<T>.minusAssign(item: T) {
    this.items.remove(item)
}

fun <T> ChoiceBox<T>.addAll(vararg items: T) = this.items.addAll(items)

fun <T> ChoiceBox<T>.addAt(index: Int, item: T) = this.items.add(index, item)

fun <T> ChoiceBox<T>.removeAt(index: Int): T? {
    return this.items.removeAt(index)
}

fun <T> ChoiceBox<T>.removeRange(from: Int, to: Int) = this.items.remove(from, to)

fun <T> ChoiceBox<T>.removeRange(range: IntRange) = this.items.remove(range.first, range.last)

fun <T> ChoiceBox<T>.removeAll(vararg items: T) = this.items.removeAll(items)

var <T> ChoiceBox<T>.selectedIndex: Int
    get() = this.selectionModel.selectedIndex
    set(index) = this.selectionModel.select(index)

var <T> ChoiceBox<T>.selectedItem: T
    get() = this.selectionModel.selectedItem
    set(item) = this.selectionModel.select(item)