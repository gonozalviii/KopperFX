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
import javafx.scene.control.ToolBar
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ToolbarTest : AbstractJavaFxTestBase() {

    @Test
    @DisplayName("plus assign on toolbar adds menu")
    fun plusAssignAddsButton() {
        val toolBar = ToolBar()
        val button = Button()

        toolBar += button

        assertTrue(toolBar.items.contains(button), "toolbar should contain button")
    }

    @Test
    @DisplayName("minus assign on toolbar removes button")
    fun minusAssignRemovesButton() {
        val toolBar = ToolBar()
        val button = Button()
        toolBar.items.add(button)

        toolBar -= button

        assertFalse(toolBar.items.contains(button), "toolbar should not contain button")
    }

    @Test
    @DisplayName("addAll on toolbar adds all buttons")
    fun addAllAddsAllButtons() {
        val toolBar = ToolBar()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()

        toolBar.addAll(button1, button2, button3)

        assertTrue(toolBar.items.contains(button1), "toolbar should contain button1")
        assertTrue(toolBar.items.contains(button2), "toolbar should contain button2")
        assertTrue(toolBar.items.contains(button3), "toolbar should contain button3")
    }

    @Test
    @DisplayName("removeAll on toolbar removes all buttons")
    fun removeAllRemovesAllButtons() {
        val toolBar = ToolBar()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        toolBar.items.addAll(button1, button2, button3)

        toolBar.removeAll(button1, button2, button3)

        assertFalse(toolBar.items.contains(button1), "toolbar should not contain button1")
        assertFalse(toolBar.items.contains(button2), "toolbar should not contain button2")
        assertFalse(toolBar.items.contains(button3), "toolbar should not contain button3")
    }

    @Test
    @DisplayName("removeRange on toolbar removes buttons in range")
    fun removeRangeRemovesButtonsInRange() {
        val toolBar = ToolBar()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        toolBar.items.addAll(button1, button2, button3)

        toolBar.removeRange(0, 2)

        assertTrue(toolBar.items.size == 1, "toolbar should only contain one button")
        Assertions.assertEquals(button3, toolBar.items[0], "toolbar should only contain specific button")
    }

    @Test
    @DisplayName("removeRange with range on toolbar removes buttons in range")
    fun removeRangeWithRangeRemovesButtonsInRange() {
        val toolBar = ToolBar()
        val button1 = Button()
        val button2 = Button()
        val button3 = Button()
        toolBar.items.addAll(button1, button2, button3)

        toolBar.removeRange(0..2)

        assertTrue(toolBar.items.size == 1, "toolbar should only contain one button")
        Assertions.assertEquals(button3, toolBar.items[0], "toolbar should only contain specific button")
    }
}