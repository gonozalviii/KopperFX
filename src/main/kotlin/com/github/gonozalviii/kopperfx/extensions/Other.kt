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

import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.FileChooser
import javafx.stage.Stage


/**
 * Other
 */
fun FileChooser.addExtensionFilter(description: String, vararg extensions: String) =
    this.extensionFilters.add(FileChooser.ExtensionFilter(description, *extensions))

fun Stage.addIcons(vararg icons: String) = icons.forEach { this.icons += Image(it) }

fun Scene.addStylesheet(stylesheet: String) = stylesheets.add(stylesheet)