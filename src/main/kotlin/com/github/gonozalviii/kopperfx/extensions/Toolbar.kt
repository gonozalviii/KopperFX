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

import javafx.scene.Node
import javafx.scene.control.ToolBar


/**
 * Toolbar
 */
operator fun ToolBar.plusAssign(item: Node) {
    this.items += item
}

operator fun ToolBar.minusAssign(item: Node) {
    this.items -= item
}

fun ToolBar.addAll(vararg items: Node) = this.items.addAll(items)

fun ToolBar.removeAll(vararg items: Node) = this.items.removeAll(items)

fun ToolBar.addAt(index: Int, item: Node) = this.items.add(index, item)

fun ToolBar.removeAt(index: Int) = this.items.removeAt(index)

fun ToolBar.removeRange(from: Int, to: Int) = this.items.remove(from, to)