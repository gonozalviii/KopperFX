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

import com.github.gonozalviii.kopperfx.extensions.addAll
import com.github.gonozalviii.kopperfx.extensions.minusAssign
import com.github.gonozalviii.kopperfx.extensions.plusAssign
import com.github.gonozalviii.kopperfx.extensions.removeAll
import javafx.embed.swing.JFXPanel
import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AccordionTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun classSetup() {
            JFXPanel() // init JavaFX
        }
    }

    @Test
    @DisplayName("plus assign on accordion adds titledpane")
    fun plusAssignAddsTitledPane() {
        val accordion = Accordion()
        val titledPane = TitledPane()

        accordion += titledPane

        assertTrue(accordion.panes.contains(titledPane), "accordion should contain titledpane")
    }

    @Test
    @DisplayName("minus assign on accordion removes titledpane")
    fun minusAssignRemovesTitledPane() {
        val accordion = Accordion()
        val titledPane = TitledPane()
        accordion.panes.add(titledPane)

        accordion -= titledPane

        assertFalse(accordion.panes.contains(titledPane), "accordion should not contain titledpane")
    }

    @Test
    @DisplayName("addAll on accordion adds all titledpanes")
    fun addAllAddsAllTitledPanes() {
        val accordion = Accordion()
        val titledPane1 = TitledPane()
        val titledPane2 = TitledPane()
        val titledPane3 = TitledPane()

        accordion.addAll(titledPane1, titledPane2, titledPane3)

        assertTrue(accordion.panes.contains(titledPane1), "accordion should contain titledpane1")
        assertTrue(accordion.panes.contains(titledPane2), "accordion should contain titledpane2")
        assertTrue(accordion.panes.contains(titledPane3), "accordion should contain titledpane3")
    }

    @Test
    @DisplayName("removeAll on accordion removes all titledpanes")
    fun removeAllRemovesAllTitledPanes() {
        val accordion = Accordion()
        val titledPane1 = TitledPane()
        val titledPane2 = TitledPane()
        val titledPane3 = TitledPane()
        accordion.panes.addAll(titledPane1, titledPane2, titledPane3)

        accordion.removeAll(titledPane1, titledPane2, titledPane3)

        assertFalse(accordion.panes.contains(titledPane1), "accordion should not contain titledpane1")
        assertFalse(accordion.panes.contains(titledPane2), "accordion should not contain titledpane2")
        assertFalse(accordion.panes.contains(titledPane3), "accordion should not contain titledpane3")
    }

}