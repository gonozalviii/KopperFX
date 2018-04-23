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

package com.github.gonozalviii.kopperfx.utility

import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.application.Platform
import javafx.application.Preloader
import javafx.fxml.FXMLLoader
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import java.io.File
import kotlin.reflect.KClass


/**
 * Utility
 */
fun fxThread(block: () -> Unit) = Platform.runLater { block() }

fun animationTimer(start: Boolean = true, block: () -> Unit): AnimationTimer {
    return object : AnimationTimer() {
        override fun handle(now: Long) {
            block()
        }
    }.apply {
        if (start) start()
    }
}

inline fun <reified T: Application> launch(args: Array<String>) = Application.launch(T::class.java, *args)

inline fun <reified T: Application> launch(args: Array<String>, preloader: Class<out Preloader>) {
    System.setProperty("javafx.preloader", preloader.name)
    Application.launch(T::class.java, *args)
}

inline fun <reified T> loadFXML(url: String, noinline controllerFactory: ((Class<*>) -> Any)? = null): T {
    val resource = KClass::class.java.getResource(url) ?: throw RuntimeException("FXML file not found: <$url>")
    val loader = FXMLLoader(resource)
    if (controllerFactory != null) {
        loader.setControllerFactory(controllerFactory)
    }
    return loader.load()
}

fun mediaPlayer(url: String): MediaPlayer {
    val media = Media(File(url).toURI().toString())
    return MediaPlayer(media)
}

fun mediaView(url: String): MediaView {
    val mediaPlayer = mediaPlayer(url)
    return MediaView(mediaPlayer)
}