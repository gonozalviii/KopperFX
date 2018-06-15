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
import javafx.scene.control.Button
import javafx.scene.layout.Pane
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PaneTest : AbstractJavaFxTestBase() {

    @Test
    fun `plus assign on pane adds button`() {
        val pane = Pane()
        val button = Button()

        pane += button

        assertTrue(pane.children.contains(button), "pane should contain button")
    }

    @Test
    fun `minus assign on pane removes button`() {
        val pane = Pane()
        val button = Button()
        pane.children.add(button)

        pane -= button

        assertFalse(pane.children.contains(button), "pane should not contain button")
    }

    @Test
    fun `clear on pane removes all included buttons`() {
        val pane = Pane()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        pane.children.addAll(button1, button2, button3)

        pane.clear()

        assertTrue(pane.children.isEmpty(), "pane should be empty")
    }

    @Test
    fun `addAll on pane adds all buttons`() {
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
    fun `removeAll on pane removes all buttons`() {
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
    fun `addAt on pane adds button at index`() {
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
    fun `removeAt on pane removes button at index`() {
        val pane = Pane()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        pane.children.addAll(button1, button2, button3)

        assertEquals(button2, pane.removeAt(1), "pane should not contain button at index")
    }

    @Test
    fun `removeRange on pane removes buttons in range`() {
        val pane = Pane()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        pane.children.addAll(button1, button2, button3)

        pane.removeRange(0, 2)

        assertTrue(pane.children.size == 1, "pane should only contain one button")
        assertEquals(button3, pane.children[0], "pane should only contain specific button")
    }

    @Test
    fun `removeRange with range on pane removes buttons in range`() {
        val pane = Pane()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        pane.children.addAll(button1, button2, button3)

        pane.removeRange(0..2)

        assertTrue(pane.children.size == 1, "pane should only contain one button")
        assertEquals(button3, pane.children[0], "pane should only contain specific button")
    }

}