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

import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane


/**
 * Accordion
 */
operator fun Accordion.plusAssign(pane: TitledPane) {
    this.panes += pane
}

operator fun Accordion.minusAssign(pane: TitledPane) {
    this.panes -= pane
}

fun Accordion.addAt(index: Int, pane: TitledPane) = this.panes.add(index, pane)

fun Accordion.removeAt(index: Int): TitledPane? {
    return this.panes.removeAt(index)
}

fun Accordion.removeRange(from: Int, to: Int) = this.panes.remove(from, to)

fun Accordion.removeRange(range: IntRange) = this.panes.remove(range.first, range.last)

fun Accordion.addAll(vararg panes: TitledPane) = this.panes.addAll(panes)

fun Accordion.removeAll(vararg panes: TitledPane) = this.panes.removeAll(panes)