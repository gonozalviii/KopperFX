import com.github.gonozalviii.kopperfx.fxThread
import com.github.gonozalviii.kopperfx.service
import com.github.gonozalviii.kopperfx.task
import javafx.embed.swing.JFXPanel
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTimeout
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.Duration
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

class ConcurrencyTest {

    companion object {
        private val executor = Executors.newSingleThreadExecutor()

        @BeforeAll
        @JvmStatic
        fun classSetup() {
            JFXPanel() // init JavaFX
        }

        @AfterAll
        @JvmStatic
        fun clear() {
            executor.shutdownNow()
        }
    }

    @Test
    @DisplayName("create task with DSL having no return value")
    fun createTaskNoReturnValue() {
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
    @DisplayName("create task with DSL and integer return value")
    fun createTaskIntegerValue() {
        val integer = AtomicInteger(5)
        val task = task<Int> {
            execute {
                integer.addAndGet(5) + 1
            }
        }
        assertEquals(5, integer.get(), "value was changed before task was executed")

        val result = executor.submit(task)
        result.get(1, TimeUnit.SECONDS)

        fxThread {
            assertEquals(11, task.value, "wrong return value")
            assertEquals(10, integer.get(), "value was not changed")
        }
    }

    @Test
    @DisplayName("create a task wrapped inside a service with no return value")
    fun createTaskWithServiceNoReturnValue() {
        val integer = AtomicInteger(3)
        val service = service<Unit> {
            task {
                execute {
                    integer.set(5)
                }
            }
        }
        assertEquals(3, integer.get(), "value was changed before task was executed")

        service.start()

        fxThread {
            assertTimeout(Duration.ofSeconds(5)) {
                while (service.isRunning) {
                }
            }

            assertEquals(5, integer.get(), "value was changed before task was executed")
        }
    }

    @Test
    @DisplayName("create a task wrapped inside a service with custom executor")
    fun createTaskWithServiceCostumExecutor() {
        val integer = AtomicInteger(3)
        val service = service<Unit>(executor) {
            task {
                execute {
                    integer.set(5)
                }
            }
        }
        assertEquals(3, integer.get(), "value was changed before task was executed")

        service.start()

        fxThread {
            assertTimeout(Duration.ofSeconds(5)) {
                while (service.isRunning) {
                }
            }

            assertEquals(5, integer.get(), "value was changed before task was executed")
        }
    }

    @Test
    @DisplayName("create a task wrapped inside a service with integer as return value")
    fun createTaskWithServiceIntegerReturnValue() {
        val integer = AtomicInteger(3)
        val service = service<Int> {
            task {
                execute {
                    integer.addAndGet(5) + 2
                }
            }
        }
        assertEquals(3, integer.get(), "value was changed before task was executed")

        service.start()

        fxThread {
            assertTimeout(Duration.ofSeconds(5)) {
                while (service.isRunning) {
                }
            }

            assertEquals(8, integer.get(), "value was changed before task was executed")
            assertEquals(10, service.value, "wrong return value from service")
        }
    }

}