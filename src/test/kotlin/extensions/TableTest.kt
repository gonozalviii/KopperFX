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
import javafx.scene.control.SelectionMode
import javafx.scene.control.TableView
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TableTest : AbstractJavaFxTestBase() {

    @Test
    @DisplayName("plus assign on tableview adds button")
    fun plusAssignAddsButton() {
        val tableview = TableView<Button>()
        val button = Button()

        tableview += button

        assertTrue(tableview.items.contains(button), "tableview should contain button")
    }

    @Test
    @DisplayName("minus assign on tableview removes button")
    fun minusAssignRemovesButton() {
        val tableview = TableView<Button>()
        val button = Button()

        tableview -= button

        assertFalse(tableview.items.contains(button), "tableview should not contain button")
    }

    @Test
    @DisplayName("addAll on tableview adds all buttons")
    fun addAllAddsAllButtons() {
        val tableview = TableView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()

        tableview.addAll(button1, button2, button3)

        assertTrue(tableview.items.contains(button1), "tableview should contain button1")
        assertTrue(tableview.items.contains(button2), "tableview should contain button2")
        assertTrue(tableview.items.contains(button3), "tableview should contain button3")
    }

    @Test
    @DisplayName("removeAll on tableview removes all buttons")
    fun removeAllRemovesAllButtons() {
        val tableview = TableView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        tableview.items.addAll(button1, button2, button3)

        tableview.removeAll(button1, button2, button3)

        assertFalse(tableview.items.contains(button1), "tableview should not contain button1")
        assertFalse(tableview.items.contains(button2), "tableview should not contain button2")
        assertFalse(tableview.items.contains(button3), "tableview should not contain button3")
    }


    @Test
    @DisplayName("addAt on tableview adds button at index")
    fun addAtAddsButtonAtIndex() {
        val tableview = TableView<Button>()
        val button = Button()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        tableview.items.addAll(button1, button2, button3)

        tableview.addAt(2, button)

        assertEquals(button, tableview.items[2], "tableview should contain button at index")
    }

    @Test
    @DisplayName("removeAt on tableview removes button at index")
    fun removeAtRemovesButtonAtIndex() {
        val tableview = TableView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        tableview.items.addAll(button1, button2, button3)

        assertEquals(button2, tableview.removeAt(1), "tableview should not contain button at index")
    }

    @Test
    @DisplayName("removeRange on tableview removes buttons in range")
    fun removeRangeRemovesButtonsInRange() {
        val tableview = TableView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        tableview.items.addAll(button1, button2, button3)

        tableview.removeRange(0, 2)

        assertTrue(tableview.items.size == 1, "tableview should only contain one button")
        assertEquals(button3, tableview.items[0], "tableview should only contain specific button")
    }

    @Test
    @DisplayName("removeRange with range on tableview removes buttons in range")
    fun removeRangeWithRangeRemovesButtonsInRange() {
        val tableview = TableView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        tableview.items.addAll(button1, button2, button3)

        tableview.removeRange(0..2)

        assertTrue(tableview.items.size == 1, "tableview should only contain one button")
        assertEquals(button3, tableview.items[0], "tableview should only contain specific button")
    }

    @Test
    @DisplayName("getSelectedItems on tableview gets selected buttons")
    fun getSelectedItemsGetsSelectedButtons() {
        val tableview = TableView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        tableview.items.addAll(button1, button2, button3)
        tableview.selectionModel.selectionMode = SelectionMode.MULTIPLE
        tableview.selectionModel.selectRange(0, 2)

        val selectedItems = tableview.getSelectedItems()

        assertTrue(selectedItems.contains(button1), "getSelectedItems should contain button1")
        assertTrue(selectedItems.contains(button2), "getSelectedItems should contain button2")
        assertFalse(selectedItems.contains(button3), "getSelectedItems should not contain button3")
    }

    @Test
    @DisplayName("focusIndex on tableview focus index")
    fun focusIndexFocusIndex() {
        val tableview = TableView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        tableview.items.addAll(button1, button2, button3)

        tableview.focusIndex(1)

        assertTrue(tableview.focusModel.isFocused(1), "focusIndex should focus specific index")
    }

    @Test
    @DisplayName("getIndexOf on tableview gets index of button")
    fun getIndexOfGetsIndexOfButton() {
        val tableview = TableView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        tableview.items.addAll(button1, button2, button3)

        assertTrue(tableview.getIndexOf(button2) == 1, "getIndexOf should return index of button2")
    }


    @Test
    @DisplayName("selectedIndex as get on tableview gets selected index")
    fun selectedIndexAsGetGetsSelectedIndex() {
        val tableview = TableView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        tableview.items.addAll(button1, button2, button3)
        tableview.selectionModel.select(1)

        assertEquals(1, tableview.selectedIndex, "selectedIndex should get selected index")
    }

    @Test
    @DisplayName("selectedIndex as set on tableview sets selected index")
    fun selectedIndexAsSetSetsSelectedIndex() {
        val tableview = TableView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        tableview.items.addAll(button1, button2, button3)

        tableview.selectedIndex = 1

        assertEquals(1, tableview.selectionModel.selectedIndex, "selectedIndex should set selected index")
    }

    @Test
    @DisplayName("selectedItem on tableview gets selected tab")
    fun selectedItemGetsSelectedButton() {
        val tableview = TableView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        tableview.items.addAll(button1, button2, button3)
        tableview.selectionModel.select(button2)

        assertEquals(button2, tableview.selectedItem, "selectedItem should get selected button")
    }

    @Test
    @DisplayName("selectedItem as set on tableview gets selected tab")
    fun selectedItemAsSetSetsSelectedItem() {
        val tableview = TableView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        tableview.items.addAll(button1, button2, button3)

        tableview.selectedItem = button2

        assertEquals(button2, tableview.selectionModel.selectedItem, "selectedItem should set selected item")
    }


}