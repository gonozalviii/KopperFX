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
import javafx.scene.layout.Pane


/**
 * Pane
 */
operator fun Pane.plusAssign(child: Node) {
    this.children += child
}

operator fun Pane.minusAssign(child: Node) {
    this.children -= child
}

fun Pane.clear() = this.children.clear()

fun Pane.addAll(vararg nodes: Node) = this.children.addAll(nodes)

fun Pane.removeAll(vararg nodes: Node) = this.children.removeAll(nodes)

fun Pane.addAt(index: Int, node: Node) = this.children.add(index, node)

fun Pane.removeAt(index: Int): Node? {
    return this.children.removeAt(index)
}

fun Pane.removeRange(from: Int, to: Int) = this.children.remove(from, to)