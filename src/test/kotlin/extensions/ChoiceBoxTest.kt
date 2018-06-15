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
import javafx.scene.control.ChoiceBox
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ChoiceBoxTest : AbstractJavaFxTestBase() {

    @Test
    fun `plus assign on choiceBox adds button`() {
        val choiceBox = ChoiceBox<Button>()
        val button = Button()

        choiceBox += button

        assertTrue(choiceBox.items.contains(button), "choicebox should contain button")
    }

    @Test
    fun `minus assign on choiceBox removes button`() {
        val choiceBox = ChoiceBox<Button>()
        val button = Button()

        choiceBox -= button

        assertFalse(choiceBox.items.contains(button), "choicebox should not contain button")
    }

    @Test
    fun `addAll on choiceBox adds all buttons`() {
        val choiceBox = ChoiceBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()

        choiceBox.addAll(button1, button2, button3)

        assertTrue(choiceBox.items.contains(button1), "choicebox should contain button1")
        assertTrue(choiceBox.items.contains(button2), "choicebox should contain button2")
        assertTrue(choiceBox.items.contains(button3), "choicebox should contain button3")
    }

    @Test
    fun `removeAll on choiceBox removes all buttons`() {
        val choiceBox = ChoiceBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        choiceBox.items.addAll(button1, button2, button3)

        choiceBox.removeAll(button1, button2, button3)

        assertFalse(choiceBox.items.contains(button1), "choicebox should not contain button1")
        assertFalse(choiceBox.items.contains(button2), "choicebox should not contain button2")
        assertFalse(choiceBox.items.contains(button3), "choicebox should not contain button3")
    }


    @Test
    fun `addAt on choiceBox adds button at index`() {
        val choiceBox = ChoiceBox<Button>()
        val button = Button()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        choiceBox.items.addAll(button1, button2, button3)

        choiceBox.addAt(2, button)

        assertEquals(button, choiceBox.items[2], "choiceBox should contain button at index")
    }

    @Test
    fun `removeAt on choiceBox removes button at index`() {
        val choiceBox = ChoiceBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        choiceBox.items.addAll(button1, button2, button3)

        assertEquals(button2, choiceBox.removeAt(1), "choiceBox should not contain button at index")
    }

    @Test
    fun `removeRange on choiceBox removes buttons in range`() {
        val choiceBox = ChoiceBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        choiceBox.items.addAll(button1, button2, button3)

        choiceBox.removeRange(0, 2)

        assertTrue(choiceBox.items.size == 1, "choiceBox should only contain one button")
        assertEquals(button3, choiceBox.items[0], "choiceBox should only contain specific button")
    }

    @Test
    fun `removeRange with range on choiceBox removes buttons in range`() {
        val choiceBox = ChoiceBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        choiceBox.items.addAll(button1, button2, button3)

        choiceBox.removeRange(0..2)

        assertTrue(choiceBox.items.size == 1, "choiceBox should only contain one button")
        assertEquals(button3, choiceBox.items[0], "choiceBox should only contain specific button")
    }

    @Test
    fun `selectedItem as get on choiceBox gets buttons`() {
        val choiceBox = ChoiceBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        choiceBox.items.addAll(button1, button2, button3)

        choiceBox.selectionModel.select(button2)

        assertEquals(button2, choiceBox.selectedItem, "selected item should be specific button")
    }

    @Test
    fun `selectedItem as set on choiceBox sets buttons`() {
        val choiceBox = ChoiceBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        choiceBox.items.addAll(button1, button2, button3)

        choiceBox.selectedItem = button2

        assertEquals(button2, choiceBox.selectionModel.selectedItem, "selected item should be specific button")
    }

    @Test
    fun `selectedIndex as get on choiceBox gets index`() {
        val choiceBox = ChoiceBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        choiceBox.items.addAll(button1, button2, button3)

        choiceBox.selectionModel.select(1)

        assertEquals(1, choiceBox.selectedIndex, "selected index should be index")
    }

    @Test
    fun `selectedIndex as set on choiceBox sets index`() {
        val choiceBox = ChoiceBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        choiceBox.items.addAll(button1, button2, button3)

        choiceBox.selectedIndex = 1

        assertEquals(1, choiceBox.selectionModel.selectedIndex, "selected index should be index")
    }


}