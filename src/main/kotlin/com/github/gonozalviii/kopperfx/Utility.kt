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

package com.github.gonozalviii.kopperfx

import javafx.animation.AnimationTimer
import javafx.application.Platform
import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import java.util.concurrent.Executor
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

fun loadFXML(url: String, controllerFactory: ((Class<*>) -> Any)? = null): Node {
    val resource = KClass::class.java.getResource(url) ?: throw RuntimeException("FXML file not found: <$url>")
    val loader = FXMLLoader(resource)
    if (controllerFactory != null) {
        loader.setControllerFactory(controllerFactory)
    }
    return loader.load()
}

fun <T> task(block: TaskWrapper<T>.() -> T): Task<T> {
    return TaskWrapper<T>().apply {
        block()
    }.task
}

class DslTask<T> : Task<T>() {

    internal var callBlock: () -> T = { throw RuntimeException("nothing to execute for this task") }

    override fun call(): T {
        return callBlock()
    }

    fun updateTaskProgress(workDone: Double, max: Double) {
        super.updateProgress(workDone, max)
    }

    fun updateTaskMessage(message: String) {
        super.updateMessage(message)
    }

    fun setTaskException(value: Throwable?) {
        super.setException(value)
    }
}

class TaskWrapper<T> {
    val task = DslTask<T>()

    var progressMax = 1.0
    var progress
        get() = task.progress
        set(value) = task.updateTaskProgress(value, progressMax)

    var message
        get() = task.message
        set(value) = task.updateTaskMessage(value)

    var exception: Throwable?
        get() = task.exception
        set(value) = task.setTaskException(value)

    fun execute(block: () -> T) {
        task.callBlock = block
    }
    fun onScheduled(block: () -> Unit) {
        task.setOnScheduled { block() }
    }
    fun onCancelled(block:  () -> Unit) {
        task.setOnCancelled { block() }
    }
    fun onFailed(block: () -> Unit) {
        task.setOnFailed { block() }
    }
    fun onRunning(block: () -> Unit) {
        task.setOnRunning { block() }
    }
    fun onSucceeded(block: () -> Unit) {
        task.setOnSucceeded { block() }
    }

}


fun <T> service(executor: Executor? = null, block: () -> Task<T> = { EmptyTask() }): DslService<T> {
    return DslService(executor, block)
}

class EmptyTask<T> : Task<T>() {
    override fun call(): T {
        throw RuntimeException("task is empty")
    }
}

class DslService<T>(executor: Executor?, createTask: () -> Task<T>) : Service<T>() {

    private var task: Task<T> = createTask()

    init {
        if (executor != null) {
            this.executor = executor
        }
    }
    override fun createTask(): Task<T> {
        return task
    }

    fun restart(task: Task<T>) {
        this.task = task
        super.restart()
    }

    fun start(task: Task<T>) {
        this.task = task
        super.start()
    }

}