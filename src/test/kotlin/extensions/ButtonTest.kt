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
import javafx.scene.control.ButtonBar
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ButtonTest : AbstractJavaFxTestBase() {

    @Test
    fun `plus assign on buttonbar adds button`() {
        val buttonBar = ButtonBar()
        val button = Button()

        buttonBar += button

        assertTrue(buttonBar.buttons.contains(button), "buttonbar should contain button")
    }

    @Test
    fun `minus assign on buttonbar removes button`() {
        val buttonBar = ButtonBar()
        val button = Button()
        buttonBar.buttons.add(button)

        buttonBar -= button

        assertFalse(buttonBar.buttons.contains(button), "buttonbar should not contain button")
    }

    @Test
    fun `addAll on buttonbar adds all buttons`() {
        val buttonBar = ButtonBar()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()

        buttonBar.addAll(button1, button2, button3)

        assertTrue(buttonBar.buttons.contains(button1), "buttonbar should contain button1")
        assertTrue(buttonBar.buttons.contains(button2), "buttonbar should contain button2")
        assertTrue(buttonBar.buttons.contains(button3), "buttonbar should contain button3")
    }

    @Test
    fun `removeAll on buttonbar removes all buttons`() {
        val buttonBar = ButtonBar()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        buttonBar.buttons.addAll(button1, button2, button3)

        buttonBar.removeAll(button1, button2, button3)

        assertFalse(buttonBar.buttons.contains(button1), "buttonbar should not contain button1")
        assertFalse(buttonBar.buttons.contains(button2), "buttonbar should not contain button2")
        assertFalse(buttonBar.buttons.contains(button3), "buttonbar should not contain button3")
    }


    @Test
    fun `addAt on buttonbar adds button at index`() {
        val buttonBar = ButtonBar()
        val button = Button()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        buttonBar.buttons.addAll(button1, button2, button3)

        buttonBar.addAt(2, button)

        assertEquals(button, buttonBar.buttons[2], "buttonbar should contain button at index")
    }

    @Test
    fun `removeAt on buttonbar removes button at index`() {
        val buttonBar = ButtonBar()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        buttonBar.buttons.addAll(button1, button2, button3)

        assertEquals(button2, buttonBar.removeAt(1), "buttonbar should not contain button at index")
    }

    @Test
    fun `removeRange on buttonbar removes buttons in range`() {
        val buttonBar = ButtonBar()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        buttonBar.buttons.addAll(button1, button2, button3)

        buttonBar.removeRange(0, 2)

        assertTrue(buttonBar.buttons.size == 1, "buttonbar should only contain one button")
        assertEquals(button3, buttonBar.buttons[0], "buttonbar should only contain specific button")
    }

    @Test
    fun `removeRange with range on buttonbar removes buttons in range`() {
        val buttonBar = ButtonBar()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        buttonBar.buttons.addAll(button1, button2, button3)

        buttonBar.removeRange(0..2)

        assertTrue(buttonBar.buttons.size == 1, "buttonbar should only contain one button")
        assertEquals(button3, buttonBar.buttons[0], "buttonbar should only contain specific button")
    }

}