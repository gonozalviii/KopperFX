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

package extensions

import base.AbstractJavaFxTestBase
import com.github.gonozalviii.kopperfx.extensions.addExtensionFilter
import javafx.stage.FileChooser
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OtherTest : AbstractJavaFxTestBase() {

    @Test
    @DisplayName("addExtensionFilter adds filter")
    fun addExtensionFilterAddsFilter() {
        val fileChooser = FileChooser()

        fileChooser.addExtensionFilter("test", "*.test")

        val extensionFilter = fileChooser.extensionFilters[0]
        assertTrue(extensionFilter.description == "test", "filter should have test as description")
        assertTrue(extensionFilter.extensions[0] == "*.test", "filter should have *.test as extension")
    }

}