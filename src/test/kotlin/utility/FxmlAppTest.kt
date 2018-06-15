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

import com.github.gonozalviii.kopperfx.utility.FxmlApp
import com.github.gonozalviii.kopperfx.utility.launch
import javafx.application.Platform
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage
import org.junit.jupiter.api.Assertions.assertTimeout
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.Duration
import kotlin.concurrent.thread

class FxmlAppTest {

    companion object {
        @JvmStatic
        var appStarted = false
    }

    @Test
    fun `launch app with fxml provided in constructor`() {
        thread {
            assertTimeout(Duration.ofSeconds(10)) {
                while (appStarted.not()) {
                    Thread.sleep(500)
                }
            }

            assertTrue(appStarted, "app was not started")
            Platform.exit()
        }

        launch<TestApp>(arrayOf())
    }

    class TestApp: FxmlApp("App with Fxml", "/test.fxml") {
        override fun beforeShow(stage: Stage, scene: Scene, root: Parent) {
            FxmlAppTest.appStarted = true
            assertTrue(root is AnchorPane, "root should be of type anchor pane")
        }
    }

}