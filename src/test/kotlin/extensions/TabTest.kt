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
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TabTest : AbstractJavaFxTestBase() {

    @Test
    fun `plus assign on tabpane adds tab`() {
        val tabpane = TabPane()
        val tab = Tab()

        tabpane += tab

        assertTrue(tabpane.tabs.contains(tab), "tabpane should contain tab")
    }

    @Test
    fun `minus assign on tabpane removes tab`() {
        val tabpane = TabPane()
        val tab = Tab()

        tabpane -= tab

        assertFalse(tabpane.tabs.contains(tab), "tabpane should not contain tab")
    }

    @Test
    fun `addAll on tabpane adds all tabs`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()

        tabpane.addAll(tab1, tab2, tab3)

        assertTrue(tabpane.tabs.contains(tab1), "tabpane should contain tab1")
        assertTrue(tabpane.tabs.contains(tab2), "tabpane should contain tab2")
        assertTrue(tabpane.tabs.contains(tab3), "tabpane should contain tab3")
    }

    @Test
    fun `removeAll on tabpane removes all tabs`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)

        tabpane.removeAll(tab1, tab2, tab3)

        assertFalse(tabpane.tabs.contains(tab1), "tabpane should not contain tab1")
        assertFalse(tabpane.tabs.contains(tab2), "tabpane should not contain tab2")
        assertFalse(tabpane.tabs.contains(tab3), "tabpane should not contain tab3")
    }


    @Test
    fun `addAt on tabpane adds tab at index`() {
        val tabpane = TabPane()
        val tab = Tab()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)

        tabpane.addAt(2, tab)

        assertEquals(tab, tabpane.tabs[2], "tabpane should contain tab at index")
    }

    @Test
    fun `removeAt on tabpane removes tab at index`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)

        assertEquals(tab2, tabpane.removeAt(1), "tabpane should not contain tab at index")
    }

    @Test
    fun `removeRange on tabpane removes tabs in range`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)

        tabpane.removeRange(0, 2)

        assertTrue(tabpane.tabs.size == 1, "tabpane should only contain one tab")
        assertEquals(tab3, tabpane.tabs[0], "tabpane should only contain specific tab")
    }

    @Test
    fun `removeRange with range on tabpane removes tabs in range`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)

        tabpane.removeRange(0..2)

        assertTrue(tabpane.tabs.size == 1, "tabpane should only contain one tab")
        assertEquals(tab3, tabpane.tabs[0], "tabpane should only contain specific tab")
    }

    @Test
    fun `selectedIndex as get on tabpane gets selected index`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)
        tabpane.selectionModel.select(1)

        assertEquals(1, tabpane.selectedIndex, "selectedIndex should get selected index")
    }

    @Test
    fun `selectedIndex as set on tabpane sets selected index`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)

        tabpane.selectedIndex = 1

        assertEquals(1, tabpane.selectionModel.selectedIndex, "selectedIndex should set selected index")
    }

    @Test
    fun `selectedItem on tabpane gets selected tab`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)
        tabpane.selectionModel.select(tab2)

        assertEquals(tab2, tabpane.selectedItem, "selectedItem should get selected tab")
    }

    @Test
    fun `selectedItem as set on tabpane gets selected tab`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)

        tabpane.selectedItem = tab2

        assertEquals(tab2, tabpane.selectionModel.selectedItem, "selectedItem should set selected item")
    }

    @Test
    fun `selectFirst on tabpane selects first index`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)

        tabpane.selectFirst()

        assertTrue(tabpane.selectionModel.isSelected(0), "selectFirst should select first index")
    }

    @Test
    fun `selectLast on tabpane selects last index`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)

        tabpane.selectLast()

        assertTrue(tabpane.selectionModel.isSelected(2), "selectLast should select last index")
    }

    @Test
    fun `selectNext on tabpane selects next index`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)
        tabpane.selectionModel.select(0)

        tabpane.selectNext()

        assertTrue(tabpane.selectionModel.isSelected(1), "selectNext should select next index")
    }

    @Test
    fun `selectPrevious on tabpane selects previous index`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)
        tabpane.selectionModel.select(2)

        tabpane.selectPrevious()

        assertTrue(tabpane.selectionModel.isSelected(1), "selectPrevious should select previous index")
    }

    @Test
    fun `isSelected on tabpane returns boolean`() {
        val tabpane = TabPane()
        val tab1 = Tab()
        val tab2 = Tab()
        val tab3 = Tab()
        tabpane.tabs.addAll(tab1, tab2, tab3)
        tabpane.selectionModel.select(2)

        assertTrue(tabpane.isSelected(2), "isSelected should return true")
    }

}