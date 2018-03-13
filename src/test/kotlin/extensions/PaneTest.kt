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

import com.github.gonozalviii.kopperfx.extensions.*
import javafx.embed.swing.JFXPanel
import javafx.scene.control.Button
import javafx.scene.layout.Pane
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PaneTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun classSetup() {
            JFXPanel() // init JavaFX
        }
    }

    @Test
    @DisplayName("plus assign on pane adds button")
    fun plusAssignAddsButton() {
        val pane = Pane()
        val button = Button()

        pane += button

        assertTrue(pane.children.contains(button), "pane should contain button")
    }

    @Test
    @DisplayName("minus assign on pane removes button")
    fun minusAssignRemovesButton() {
        val pane = Pane()
        val button = Button()
        pane.children.add(button)

        pane -= button

        assertFalse(pane.children.contains(button), "pane should not contain button")
    }

    @Test
    @DisplayName("clear on pane removes all included buttons")
    fun clearRemovesAllIncludeButtons() {
        val pane = Pane()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        pane.children.addAll(button1, button2, button3)

        pane.clear()

        assertTrue(pane.children.isEmpty(), "pane should be empty")
    }

    @Test
    @DisplayName("addAll on pane adds all buttons")
    fun addAllAddsAllButtons() {
        val pane = Pane()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()

        pane.addAll(button1, button2, button3)

        assertTrue(pane.children.contains(button1), "pane should contain button1")
        assertTrue(pane.children.contains(button2), "pane should contain button2")
        assertTrue(pane.children.contains(button3), "pane should contain button3")
    }

    @Test
    @DisplayName("removeAll on pane removes all buttons")
    fun removeAllRemovesAllButtons() {
        val pane = Pane()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        pane.children.addAll(button1, button2, button3)

        pane.removeAll(button1, button2, button3)

        assertFalse(pane.children.contains(button1), "pane should not contain button1")
        assertFalse(pane.children.contains(button2), "pane should not contain button2")
        assertFalse(pane.children.contains(button3), "pane should not contain button3")
    }

    @Test
    @DisplayName("addAt on pane adds button at index")
    fun addAtAddsButtonAtIndex() {
        val pane = Pane()
        val button = Button()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        pane.children.addAll(button1, button2, button3)

        pane.addAt(2, button)

        assertEquals(button, pane.children[2], "pane should contain button at index")
    }

    @Test
    @DisplayName("removeAt on pane removes button at index")
    fun removeAtRemovesButtonAtIndex() {
        val pane = Pane()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        pane.children.addAll(button1, button2, button3)

        assertEquals(button2, pane.removeAt(1), "pane should not contain button at index")
    }

    @Test
    @DisplayName("removeRange on pane removes buttons in range")
    fun removeRangeRemovesButtonsInRange() {
        val pane = Pane()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        pane.children.addAll(button1, button2, button3)

        pane.removeRange(0, 2)

        assertTrue(pane.children.size == 1, "pane should only contain one button")
        assertEquals(button3, pane.children[0], "pane should only contain specific button")
    }

}