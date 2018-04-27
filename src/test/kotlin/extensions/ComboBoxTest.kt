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
import javafx.scene.control.ComboBox
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ComboBoxTest : AbstractJavaFxTestBase() {

    @Test
    @DisplayName("plus assign on comboBox adds button")
    fun plusAssignAddsButton() {
        val comboBox = ComboBox<Button>()
        val button = Button()

        comboBox += button

        assertTrue(comboBox.items.contains(button), "comboBox should contain button")
    }

    @Test
    @DisplayName("minus assign on comboBox removes button")
    fun minusAssignRemovesButton() {
        val comboBox = ComboBox<Button>()
        val button = Button()

        comboBox -= button

        assertFalse(comboBox.items.contains(button), "comboBox should not contain button")
    }

    @Test
    @DisplayName("addAll on comboBox adds all buttons")
    fun addAllAddsAllButtons() {
        val comboBox = ComboBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()

        comboBox.addAll(button1, button2, button3)

        assertTrue(comboBox.items.contains(button1), "comboBox should contain button1")
        assertTrue(comboBox.items.contains(button2), "comboBox should contain button2")
        assertTrue(comboBox.items.contains(button3), "comboBox should contain button3")
    }

    @Test
    @DisplayName("removeAll on comboBox removes all buttons")
    fun removeAllRemovesAllButtons() {
        val comboBox = ComboBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        comboBox.items.addAll(button1, button2, button3)

        comboBox.removeAll(button1, button2, button3)

        assertFalse(comboBox.items.contains(button1), "comboBox should not contain button1")
        assertFalse(comboBox.items.contains(button2), "comboBox should not contain button2")
        assertFalse(comboBox.items.contains(button3), "comboBox should not contain button3")
    }


    @Test
    @DisplayName("addAt on comboBox adds button at index")
    fun addAtAddsButtonAtIndex() {
        val comboBox = ComboBox<Button>()
        val button = Button()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        comboBox.items.addAll(button1, button2, button3)

        comboBox.addAt(2, button)

        assertEquals(button, comboBox.items[2], "comboBox should contain button at index")
    }

    @Test
    @DisplayName("removeAt on comboBox removes button at index")
    fun removeAtRemovesButtonAtIndex() {
        val comboBox = ComboBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        comboBox.items.addAll(button1, button2, button3)

        assertEquals(button2, comboBox.removeAt(1), "comboBox should not contain button at index")
    }

    @Test
    @DisplayName("removeRange on comboBox removes buttons in range")
    fun removeRangeRemovesButtonsInRange() {
        val comboBox = ComboBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        comboBox.items.addAll(button1, button2, button3)

        comboBox.removeRange(0, 2)

        assertTrue(comboBox.items.size == 1, "comboBox should only contain one button")
        assertEquals(button3, comboBox.items[0], "comboBox should only contain specific button")
    }

    @Test
    @DisplayName("removeRange with range on comboBox removes buttons in range")
    fun removeRangeWithRangeRemovesButtonsInRange() {
        val comboBox = ComboBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        comboBox.items.addAll(button1, button2, button3)

        comboBox.removeRange(0..2)

        assertTrue(comboBox.items.size == 1, "comboBox should only contain one button")
        assertEquals(button3, comboBox.items[0], "comboBox should only contain specific button")
    }

    @Test
    @DisplayName("selectedItem as get on comboBox gets buttons")
    fun selectedItemAsGetGetsButton() {
        val comboBox = ComboBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        comboBox.items.addAll(button1, button2, button3)

        comboBox.selectionModel.select(button2)

        assertEquals(button2, comboBox.selectedItem, "selected item should be specific button")
    }

    @Test
    @DisplayName("selectedItem as set on comboBox sets buttons")
    fun selectedItemAsSetSetsButton() {
        val comboBox = ComboBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        comboBox.items.addAll(button1, button2, button3)

        comboBox.selectedItem = button2

        assertEquals(button2, comboBox.selectionModel.selectedItem, "selected item should be specific button")
    }

    @Test
    @DisplayName("selectedIndex as get on comboBox gets index")
    fun selectedIndexAsGetGetsIndex() {
        val comboBox = ComboBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        comboBox.items.addAll(button1, button2, button3)

        comboBox.selectionModel.select(1)

        assertEquals(1, comboBox.selectedIndex, "selected index should be index")
    }

    @Test
    @DisplayName("selectedIndex as set on comboBox sets index")
    fun selectedIndexAsSetSetsIndex() {
        val comboBox = ComboBox<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        comboBox.items.addAll(button1, button2, button3)

        comboBox.selectedIndex = 1

        assertEquals(1, comboBox.selectionModel.selectedIndex, "selected index should be index")
    }

}