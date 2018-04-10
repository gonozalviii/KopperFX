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
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar


/**
 * ButtonBar
 */
operator fun ButtonBar.plusAssign(button: Button) {
    this.buttons += button
}

operator fun ButtonBar.minusAssign(button: Button) {
    this.buttons -= button
}

fun ButtonBar.addAt(index: Int, button: Button) = this.buttons.add(index, button)

fun ButtonBar.removeAt(index: Int): Node? {
    return this.buttons.removeAt(index)
}

fun ButtonBar.removeRange(from: Int, to: Int) = this.buttons.remove(from, to)

fun ButtonBar.removeRange(range: ClosedRange<Int>) = this.buttons.remove(range.start, range.endInclusive)

fun ButtonBar.addAll(vararg buttons: Button) = this.buttons.addAll(buttons)

fun ButtonBar.removeAll(vararg buttons: Button) = this.buttons.removeAll(buttons)