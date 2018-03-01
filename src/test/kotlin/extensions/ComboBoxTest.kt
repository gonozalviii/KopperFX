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

import com.github.gonozalviii.kopperfx.extensions.addAll
import com.github.gonozalviii.kopperfx.extensions.minusAssign
import com.github.gonozalviii.kopperfx.extensions.plusAssign
import com.github.gonozalviii.kopperfx.extensions.removeAll
import javafx.embed.swing.JFXPanel
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ComboBoxTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun classSetup() {
            JFXPanel() // init JavaFX
        }
    }

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

}