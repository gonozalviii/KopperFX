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

import javafx.application.Application
import javafx.application.Platform
import javafx.application.Preloader
import javafx.stage.Stage


class TestApp : Application() {
    override fun start(primaryStage: Stage?) {
        LaunchTest.testResult = "launched"
        PreloadTest.testResult = "launched"
        Platform.exit()
    }
}

class TestPreLoader : Preloader() {
    override fun start(primaryStage: Stage?) {
        PreloadTest.preloadResult = "pre loaded"
    }
}