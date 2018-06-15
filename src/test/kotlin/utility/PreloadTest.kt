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

import com.github.gonozalviii.kopperfx.utility.launch
import javafx.application.Platform
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Created by ext_PSchoenhusen, Opitz Consulting Deutschland GmbH, on 24.04.2018
 */
class PreloadTest {

    companion object {
        @JvmStatic
        var testResult = ""
        @JvmStatic
        var preloadResult = ""
    }

    @Test
    fun `calling launch application with parameter should start application`() {
        launch<TestApp>(arrayOf(), TestPreLoader::class.java)
        Assertions.assertEquals("launched", testResult, "application was not launched")
        Assertions.assertEquals("pre loaded", preloadResult, "pre-loader was not launched")
        Platform.exit()
    }
}