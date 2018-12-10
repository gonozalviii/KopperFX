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