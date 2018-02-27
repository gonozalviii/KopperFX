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

import javafx.scene.control.Menu
import javafx.scene.control.MenuBar


/**
 * MenuBar
 */
operator fun MenuBar.plusAssign(menu: Menu) {
    this.menus += menu
}

operator fun MenuBar.minusAssign(menu: Menu) {
    this.menus -= menu
}

fun MenuBar.addAll(vararg menues: Menu) {
    this.menus.addAll(menues)
}

fun MenuBar.removeAll(vararg menues: Menu) {
    this.menus.removeAll(menues)
}