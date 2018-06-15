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
import javafx.scene.control.ListView
import javafx.scene.control.SelectionMode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.function.Predicate

class ListTest : AbstractJavaFxTestBase() {

    @Test
    fun `plus assign on listview adds button`() {
        val listView = ListView<Button>()
        val button = Button()

        listView += button

        assertTrue(listView.items.contains(button), "listview should contain button")
    }

    @Test
    fun `minus assign on listview removes button`() {
        val listview = ListView<Button>()
        val button = Button()

        listview -= button

        assertFalse(listview.items.contains(button), "listview should not contain button")
    }

    @Test
    fun `addAll on listview adds all buttons`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()

        listview.addAll(button1, button2, button3)

        assertTrue(listview.items.contains(button1), "listview should contain button1")
        assertTrue(listview.items.contains(button2), "listview should contain button2")
        assertTrue(listview.items.contains(button3), "listview should contain button3")
    }

    @Test
    fun `removeAll on listview removes all buttons`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)

        listview.removeAll(button1, button2, button3)

        assertFalse(listview.items.contains(button1), "listview should not contain button1")
        assertFalse(listview.items.contains(button2), "listview should not contain button2")
        assertFalse(listview.items.contains(button3), "listview should not contain button3")
    }


    @Test
    fun `addAt on listview adds button at index`() {
        val listview = ListView<Button>()
        val button = Button()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)

        listview.addAt(2, button)

        assertEquals(button, listview.items[2], "listview should contain button at index")
    }

    @Test
    fun `removeAt on listview removes button at index`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)

        assertEquals(button2, listview.removeAt(1), "listview should not contain button at index")
    }

    @Test
    fun `removeRange on listview removes buttons in range`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)

        listview.removeRange(0, 2)

        assertTrue(listview.items.size == 1, "listview should only contain one button")
        assertEquals(button3, listview.items[0], "listview should only contain specific button")
    }

    @Test
    fun `removeRange with range on listview removes buttons in range`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)

        listview.removeRange(0..2)

        assertTrue(listview.items.size == 1, "listview should only contain one button")
        assertEquals(button3, listview.items[0], "listview should only contain specific button")
    }

    @Test
    fun `getItemFrom with index on listview gets button from index`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)

        val itemFrom = listview.getItemFrom(1)

        assertEquals(listview.items[1], itemFrom, "getItemFrom should get specific button")
    }

    @Test
    fun `focusedIndex as get on listview gets focused index`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)
        listview.focusModel.focus(1)

        assertEquals(1, listview.focusedIndex, "focusedIndex should get focused index")
    }

    @Test
    fun `focusedIndex as set on listview sets focused index`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)

        listview.focusedIndex = 1

        assertEquals(1, listview.focusModel.focusedIndex, "focusedIndex should set focused index")
    }

    @Test
    fun `focusedItem on listview gets focused button`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)
        listview.focusModel.focus(1)

        assertEquals(button2, listview.focusedItem, "focusedItem should get focused button")
    }

    @Test
    fun `focusNext on listview focus next button`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)
        listview.focusModel.focus(1)

        listview.focusNext()

        assertEquals(button3, listview.focusModel.focusedItem, "focusedItem should get focused button")
    }

    @Test
    fun `focusPrevious on listview focus previous button`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)
        listview.focusModel.focus(1)

        listview.focusPrevious()

        assertEquals(button1, listview.focusModel.focusedItem, "focusedItem should get focused button")
    }

    @Test
    fun `isFocused on button in listview returns true`() {
        val listview = ListView<Button>()
        val button1 = Button()
        listview.items.add(button1)
        listview.focusModel.focus(0)

        assertTrue(listview.isFocused(0), "isFocused should be true")
    }

    @Test
    fun `selectItem on listview selects button`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)

        listview.selectItem(button2)

        assertTrue(listview.selectionModel.isSelected(1), "selectItem should select specific button")
    }

    @Test
    fun `selectIndex on listview selects index`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)

        listview.selectIndex(1)

        assertTrue(listview.selectionModel.isSelected(1), "selectIndex should select specific index")
    }

    @Test
    fun `selectFirst on listview selects first index`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)

        listview.selectFirst()

        assertTrue(listview.selectionModel.isSelected(0), "selectFirst should select first index")
    }

    @Test
    fun `selectLast on listview selects last index`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)

        listview.selectLast()

        assertTrue(listview.selectionModel.isSelected(2), "selectLast should select last index")
    }

    @Test
    fun `isSelected returns boolean`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)
        listview.selectionModel.select(2)

        assertTrue(listview.isSelected(2), "isSelected should return true")
    }

    @Test
    fun `selectAll on listview selects all`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)
        listview.selectionModel.selectionMode = SelectionMode.MULTIPLE

        listview.selectAll()

        assertTrue(listview.selectionModel.isSelected(0), "selectAll should select first index")
        assertTrue(listview.selectionModel.isSelected(1), "selectAll should select middle index")
        assertTrue(listview.selectionModel.isSelected(2), "selectAll should select last index")
    }

    @Test
    fun `selectRange on listview selects specific range`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)
        listview.selectionModel.selectionMode = SelectionMode.MULTIPLE

        listview.selectRange(0, 2)

        assertTrue(listview.selectionModel.isSelected(0), "selectAll should select first index")
        assertTrue(listview.selectionModel.isSelected(1), "selectAll should select middle index")
        assertFalse(listview.selectionModel.isSelected(2), "selectAll should not select last index")
    }

    @Test
    fun `selectRange with range on listview selects specific range`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)
        listview.selectionModel.selectionMode = SelectionMode.MULTIPLE

        listview.selectRange(0..2)

        assertTrue(listview.selectionModel.isSelected(0), "selectAll should select first index")
        assertTrue(listview.selectionModel.isSelected(1), "selectAll should select middle index")
        assertFalse(listview.selectionModel.isSelected(2), "selectAll should not select last index")
    }

    @Test
    fun `contains should return boolean`() {
        val listview = ListView<Button>()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        listview.items.addAll(button1, button2, button3)

        assertTrue(listview.contains(button2), "contains should return true")
    }

    @Test
    fun `filtered should create filteredListWrapper`() {
        val listview = ListView<String>()
        val testString1 = "TestString1"
        val testString2 = "TestString2"
        val testString3 = "FilteredString1"
        val testString4 = "TestString3"
        val testString5 = "FilteredString2"
        listview.addAll(testString1, testString2, testString3, testString4, testString5)

        val filteredList = listview.filtered(Predicate { t -> t.startsWith("Filtered") })

        assertFalse(filteredList.contains(testString1), "filteredList should not contain testString1")
        assertFalse(filteredList.contains(testString2), "filteredList should not contain testString2")
        assertTrue(filteredList.contains(testString3), "filteredList should contain testString3")
        assertFalse(filteredList.contains(testString4), "filteredList should not contain testString4")
        assertTrue(filteredList.contains(testString5), "filteredList should contain testString5")
    }

}