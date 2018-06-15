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
import com.github.gonozalviii.kopperfx.extensions.*
import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AccordionTest : AbstractJavaFxTestBase() {

    @Test
    fun `plus assign on accordion adds titledpane`() {
        val accordion = Accordion()
        val titledPane = TitledPane()

        accordion += titledPane

        assertTrue(accordion.panes.contains(titledPane), "accordion should contain titledpane")
    }

    @Test
    fun `minus assign on accordion removes titledpane`() {
        val accordion = Accordion()
        val titledPane = TitledPane()
        accordion.panes.add(titledPane)

        accordion -= titledPane

        assertFalse(accordion.panes.contains(titledPane), "accordion should not contain titledpane")
    }

    @Test
    fun `addAll on accordion adds all titledpanes`() {
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
    fun `removeAll on accordion removes all titledpanes`() {
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

    @Test
    fun `addAt on accordion adds titledpane at index`() {
        val accordion = Accordion()
        val titledPane = TitledPane()
        val titledPane1 = TitledPane()
        val titledPane2 = TitledPane()
        val titledPane3 = TitledPane()
        accordion.panes.addAll(titledPane1, titledPane2, titledPane3)

        accordion.addAt(2, titledPane)

        assertEquals(titledPane, accordion.panes[2], "accordion should contain titledpane at index")
    }

    @Test
    fun `removeAt on accordion removes titledpane at index`() {
        val accordion = Accordion()
        val titledPane1 = TitledPane()
        val titledPane2 = TitledPane()
        val titledPane3 = TitledPane()
        accordion.panes.addAll(titledPane1, titledPane2, titledPane3)

        assertEquals(titledPane2, accordion.removeAt(1), "accordion should not contain titledpane at index")
    }

    @Test
    fun `removeRange on accordion removes titledpanes in range`() {
        val accordion = Accordion()
        val titledPane1 = TitledPane()
        val titledPane2 = TitledPane()
        val titledPane3 = TitledPane()
        accordion.panes.addAll(titledPane1, titledPane2, titledPane3)

        accordion.removeRange(0, 2)

        assertTrue(accordion.panes.size == 1, "accordion should only contain one titledpane")
        assertEquals(titledPane3, accordion.panes[0], "accordion should only contain specific titledpane")
    }

    @Test
    fun `removeRange with range on accordion removes titledpanes in range`() {
        val accordion = Accordion()
        val titledPane1 = TitledPane()
        val titledPane2 = TitledPane()
        val titledPane3 = TitledPane()
        accordion.panes.addAll(titledPane1, titledPane2, titledPane3)

        accordion.removeRange(0..2)

        assertTrue(accordion.panes.size == 1, "accordion should only contain one titledpane")
        assertEquals(titledPane3, accordion.panes[0], "accordion should only contain specific titledpane")
    }

}