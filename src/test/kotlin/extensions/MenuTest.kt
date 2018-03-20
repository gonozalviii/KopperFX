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
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MenuTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun classSetup() {
            JFXPanel() // init JavaFX
        }
    }

    @Test
    @DisplayName("plus assign on menubar adds menu")
    fun plusAssignAddsMenu() {
        val menuBar = MenuBar()
        val menu = Menu()

        menuBar += menu

        assertTrue(menuBar.menus.contains(menu), "menubar should contain menu")
    }

    @Test
    @DisplayName("minus assign on menubar removes menu")
    fun minusAssignRemovesMenu() {
        val menuBar = MenuBar()
        val menu = Menu()
        menuBar.menus.add(menu)

        menuBar -= menu

        assertFalse(menuBar.menus.contains(menu), "menubar should not contain menu")
    }

    @Test
    @DisplayName("addAll on menubar adds all menus")
    fun addAllAddsAllMenus() {
        val menuBar = MenuBar()
        val menu1 = Menu()
        val menu2 = Menu()
        val menu3 = Menu()

        menuBar.addAll(menu1, menu2, menu3)

        assertTrue(menuBar.menus.contains(menu1), "menubar should contain menu1")
        assertTrue(menuBar.menus.contains(menu2), "menubar should contain menu2")
        assertTrue(menuBar.menus.contains(menu3), "menubar should contain menu3")
    }

    @Test
    @DisplayName("removeAll on menubar removes all menus")
    fun removeAllRemovesAllMenus() {
        val menuBar = MenuBar()
        val menu1 = Menu()
        val menu2 = Menu()
        val menu3 = Menu()
        menuBar.menus.addAll(menu1, menu2, menu3)

        menuBar.removeAll(menu1, menu2, menu3)

        assertFalse(menuBar.menus.contains(menu1), "menubar should not contain menu1")
        assertFalse(menuBar.menus.contains(menu2), "menubar should not contain menu2")
        assertFalse(menuBar.menus.contains(menu3), "menubar should not contain menu3")
    }


    @Test
    @DisplayName("addAt on menubar adds menu at index")
    fun addAtAddsMenuAtIndex() {
        val menuBar = MenuBar()
        val menu = Menu()
        val menu1 = Menu()
        val menu2 = Menu()
        val menu3 = Menu()
        menuBar.menus.addAll(menu1, menu2, menu3)

        menuBar.addAt(2, menu)

        assertEquals(menu, menuBar.menus[2], "menubar should contain menu at index")
    }

    @Test
    @DisplayName("removeAt on menubar removes menu at index")
    fun removeAtRemovesMenuAtIndex() {
        val menuBar = MenuBar()
        val menu1 = Menu()
        val menu2 = Menu()
        val menu3 = Menu()
        menuBar.menus.addAll(menu1, menu2, menu3)

        assertEquals(menu2, menuBar.removeAt(1), "menubar should not contain menu at index")
    }

    @Test
    @DisplayName("removeRange on menubar removes menus in range")
    fun removeRangeRemovesMenusInRange() {
        val menuBar = MenuBar()
        val menu1 = Menu()
        val menu2 = Menu()
        val menu3 = Menu()
        menuBar.menus.addAll(menu1, menu2, menu3)

        menuBar.removeRange(0, 2)

        assertTrue(menuBar.menus.size == 1, "menubar should only contain one menu")
        assertEquals(menu3, menuBar.menus[0], "menubar should only contain specific menu")
    }

}