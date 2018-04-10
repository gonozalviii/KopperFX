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
import javafx.scene.control.Button
import javafx.scene.control.TreeItem
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TreeTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun classSetup() {
            JFXPanel() // init JavaFX
        }
    }

    @Test
    @DisplayName("plus assign on treeitem adds subTreeItem")
    fun plusAssignAddsTreeItem() {
        val treeItem = TreeItem<Button>()
        val subTreeItem = TreeItem<Button>()

        treeItem += subTreeItem

        assertTrue(treeItem.children.contains(subTreeItem), "treeitem should contain subTreeItem")
    }

    @Test
    @DisplayName("minus assign on treeitem removes subTreeItem")
    fun minusAssignRemovesTreeItem() {
        val treeItem = TreeItem<Button>()
        val subTreeItem = TreeItem<Button>()

        treeItem -= subTreeItem

        assertFalse(treeItem.children.contains(subTreeItem), "treeitem should not contain subTreeItem")
    }

    @Test
    @DisplayName("addAll on treeitem adds all subTreeItems")
    fun addAllAddsAllTreeItems() {
        val treeItem = TreeItem<Button>()
        val subTreeItem1 = TreeItem<Button>()
        val subTreeItem2 = TreeItem<Button>()
        val subTreeItem3 = TreeItem<Button>()

        treeItem.addAll(subTreeItem1, subTreeItem2, subTreeItem3)

        assertTrue(treeItem.children.contains(subTreeItem1), "treeitem should contain subTreeItem1")
        assertTrue(treeItem.children.contains(subTreeItem2), "treeitem should contain subTreeItem2")
        assertTrue(treeItem.children.contains(subTreeItem3), "treeitem should contain subTreeItem3")
    }

    @Test
    @DisplayName("removeAll on treeitem removes all subTreeItems")
    fun removeAllRemovesAllTreeItems() {
        val treeItem = TreeItem<Button>()
        val subTreeItem1 = TreeItem<Button>()
        val subTreeItem2 = TreeItem<Button>()
        val subTreeItem3 = TreeItem<Button>()
        treeItem.children.addAll(subTreeItem1, subTreeItem2, subTreeItem3)

        treeItem.removeAll(subTreeItem1, subTreeItem2, subTreeItem3)

        assertFalse(treeItem.children.contains(subTreeItem1), "treeitem should not contain subTreeItem1")
        assertFalse(treeItem.children.contains(subTreeItem2), "treeitem should not contain subTreeItem2")
        assertFalse(treeItem.children.contains(subTreeItem3), "treeitem should not contain subTreeItem3")
    }


    @Test
    @DisplayName("addAt on treeitem adds subTreeItem at index")
    fun addAtAddsTreeItemAtIndex() {
        val treeItem = TreeItem<Button>()
        val subTreeItem = TreeItem<Button>()
        val subTreeItem1 = TreeItem<Button>()
        val subTreeItem2 = TreeItem<Button>()
        val subTreeItem3 = TreeItem<Button>()
        treeItem.children.addAll(subTreeItem1, subTreeItem2, subTreeItem3)

        treeItem.addAt(2, subTreeItem)

        assertEquals(subTreeItem, treeItem.children[2], "treeitem should contain subTreeItem at index")
    }

    @Test
    @DisplayName("removeAt on treeitem removes subTreeItem at index")
    fun removeAtRemovesTreeItemAtIndex() {
        val treeItem = TreeItem<Button>()
        val subTreeItem1 = TreeItem<Button>()
        val subTreeItem2 = TreeItem<Button>()
        val subTreeItem3 = TreeItem<Button>()
        treeItem.children.addAll(subTreeItem1, subTreeItem2, subTreeItem3)

        assertEquals(subTreeItem2, treeItem.removeAt(1), "treeitem should not contain subTreeItem at index")
    }

    @Test
    @DisplayName("removeRange on treeitem removes subTreeItems in range")
    fun removeRangeRemovesTreeItemsInRange() {
        val treeItem = TreeItem<Button>()
        val subTreeItem1 = TreeItem<Button>()
        val subTreeItem2 = TreeItem<Button>()
        val subTreeItem3 = TreeItem<Button>()
        treeItem.children.addAll(subTreeItem1, subTreeItem2, subTreeItem3)

        treeItem.removeRange(0, 2)

        assertTrue(treeItem.children.size == 1, "treeitem should only contain one subTreeItem")
        assertEquals(subTreeItem3, treeItem.children[0], "treeitem should only contain specific subTreeItem")
    }

    @Test
    @DisplayName("removeRange with range on treeitem removes subTreeItems in range")
    fun removeRangeWithRangeRemovesTreeItemsInRange() {
        val treeItem = TreeItem<Button>()
        val subTreeItem1 = TreeItem<Button>()
        val subTreeItem2 = TreeItem<Button>()
        val subTreeItem3 = TreeItem<Button>()
        treeItem.children.addAll(subTreeItem1, subTreeItem2, subTreeItem3)

        treeItem.removeRange(0..2)

        assertTrue(treeItem.children.size == 1, "treeitem should only contain one subTreeItem")
        assertEquals(subTreeItem3, treeItem.children[0], "treeitem should only contain specific subTreeItem")
    }

}