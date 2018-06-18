package base

import com.github.gonozalviii.kopperfx.utility.fxThread
import javafx.embed.swing.JFXPanel
import org.junit.jupiter.api.BeforeAll
import java.util.concurrent.Semaphore

/**
 * Created by ext_PSchoenhusen, Opitz Consulting Deutschland GmbH, on 10.04.2018
 */
abstract class AbstractJavaFxTestBase {

    companion object {
        @BeforeAll
        @JvmStatic
        fun classSetup() {
            JFXPanel() // init JavaFX
        }
    }

    fun fxThreadTest(block: FxTestBuilder.() -> Unit) {
        val fxTest = FxTestBuilder()
        fxTest.block()
    }

    class FxTestBuilder {
        private val semaphore = Semaphore(1)

        fun test(block: () -> Unit) {
            semaphore.acquire()
            fxThread {
                try {
                    block()
                } finally {
                    semaphore.release()
                }
            }

        }

        fun verify(block: () -> Unit) {
            semaphore.acquire()
            block()
            semaphore.release()
        }

    }

}