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

import javafx.scene.control.TreeItem


/**
 * TreeItem
 */
operator fun <T> TreeItem<T>.plusAssign(child: TreeItem<T>) {
    this.children += child
}

operator fun <T> TreeItem<T>.minusAssign(child: TreeItem<T>) {
    this.children -= child
}

fun <T> TreeItem<T>.addAll(vararg children: TreeItem<T>) = this.children.addAll(children)

fun <T> TreeItem<T>.removeAll(vararg children: TreeItem<T>) = this.children.removeAll(children)

fun <T> TreeItem<T>.addAt(index: Int, child: TreeItem<T>) = this.children.add(index, child)

fun <T> TreeItem<T>.removeAt(index: Int): TreeItem<T>? {
    return this.children.removeAt(index)
}

fun <T> TreeItem<T>.removeRange(from: Int, to: Int) = this.children.remove(from, to)