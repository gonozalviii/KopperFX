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

package utility

import base.AbstractJavaFxTestBase
import com.github.gonozalviii.kopperfx.utility.service
import com.github.gonozalviii.kopperfx.utility.task
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTimeout
import org.junit.jupiter.api.Test
import java.time.Duration
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

class ConcurrencyTest : AbstractJavaFxTestBase() {

    companion object {
        private val executor = Executors.newSingleThreadExecutor()

        @AfterAll
        @JvmStatic
        fun clear() {
            executor.shutdownNow()
        }
    }

    @Test
    fun `create task with DSL having no return value`() {
        val integer = AtomicInteger(0)
        val task = task<Unit> {
            execute {
                integer.addAndGet(5)
            }
        }
        assertEquals(0, integer.get(), "value was changed before task was executed")

        val result = executor.submit(task)
        result.get(5, TimeUnit.SECONDS)

        assertEquals(5, integer.get(), "value was not changed")
    }

    @Test
    fun `create task with DSL and integer return value`() = fxThreadTest {
        val integer = AtomicInteger(5)
        val task = task<Int> {
            execute {
                integer.addAndGet(5) + 1
            }
        }
        assertEquals(5, integer.get(), "value was changed before task was executed")

        val result = executor.submit(task)
        result.get(1, TimeUnit.SECONDS)
        var taskValue = 0
        test {
            taskValue = task.value
        }
        verify {
            assertEquals(11, taskValue, "wrong return value")
            assertEquals(10, integer.get(), "value was not changed")
        }
    }

    @Test
    fun `create a task wrapped inside a service with no return value`() {
        val integer = AtomicInteger(3)
        val done = AtomicBoolean(false)
        val service = service<Unit> {
            task {
                execute {
                    integer.set(5)
                }
                onSucceeded {
                    done.set(true)
                }
            }
        }
        assertEquals(3, integer.get(), "value was changed before task was executed")
        service.start()
        assertTimeout(Duration.ofSeconds(5)) {
            while (!done.get()) {
            }
        }
        assertEquals(5, integer.get(), "wrong value after task was executed")
    }

    @Test
    fun `create a task wrapped inside a service with custom executor`() {
        val integer = AtomicInteger(3)
        val done = AtomicBoolean(false)
        val service = service<Unit>(executor) {
            task {
                execute {
                    integer.set(5)
                }
                onSucceeded {
                    done.set(true)
                }
            }
        }
        assertEquals(3, integer.get(), "value was changed before task was executed")

        service.start()

        assertTimeout(Duration.ofSeconds(5)) {
            while (!done.get()) {
            }
        }

        assertEquals(5, integer.get(), "wrong value after task was executed")
    }

    @Test
    fun `create a task wrapped inside a service with integer as return value`() = fxThreadTest {
        val integer = AtomicInteger(3)
        val done = AtomicBoolean(false)
        val service = service<Int> {
            task {
                execute {
                    integer.addAndGet(5) + 2
                }
                onSucceeded {
                    done.set(true)
                }
            }
        }
        assertEquals(3, integer.get(), "value was changed before task was executed")

        service.start()

        assertTimeout(Duration.ofSeconds(5)) {
            while (!done.get()) {
            }
        }
        var result = 0
        test {
            result = service.value
        }
        verify {
            assertEquals(8, integer.get(), "wrong value after task was executed")
            assertEquals(10, result, "wrong return value from service")
        }
    }

}