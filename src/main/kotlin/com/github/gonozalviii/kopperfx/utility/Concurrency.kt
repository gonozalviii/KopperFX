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

import javafx.concurrent.Service
import javafx.concurrent.Task
import java.util.concurrent.Executor


fun <T> task(block: TaskWrapper<T>.() -> Unit): Task<T> {
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

class DslService<T>(executor: Executor? = null, private var createBlock: () -> Task<T>) : Service<T>() {

    init {
        if (executor != null) {
            this.executor = executor
        }
    }

    override fun createTask(): Task<T> {
        return createBlock()
    }

    fun restart(createBlock: () -> Task<T>) {
        this.createBlock = createBlock
        super.restart()
    }

    fun start(createBlock: () -> Task<T>) {
        this.createBlock = createBlock
        super.start()
    }

}