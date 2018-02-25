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

package com.github.gonozalviii.kopperfx

import javafx.beans.value.ObservableValue
import javafx.beans.value.WritableValue
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.layout.Pane
import javafx.stage.FileChooser
import javafx.stage.Stage
import kotlin.reflect.KProperty

/**
 * Property delegates
 */
operator fun <T> ObservableValue<T>.getValue(thisRef: Any?, property: KProperty<*>): T = this.value

operator fun <T> WritableValue<T>.setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    this.value = value
}

/**
 * Observable lists
 */
operator fun <T> ObservableList<T>.plusAssign(list: ObservableList<T>) {
    this.addAll(list)
}

operator fun <T> ObservableList<T>.minusAssign(list: ObservableList<T>) {
    this.removeAll(list)
}

/**
 * Pane
 */
operator fun Pane.plusAssign(child: Node) {
    this.children += child
}

operator fun Pane.minusAssign(child: Node) {
    this.children -= child
}

fun Pane.clear() = this.children.clear()

fun Pane.addAll(vararg nodes: Node) = this.children.addAll(nodes)

fun Pane.removeAll(vararg nodes: Node) = this.children.removeAll(nodes)


/**
 * TreeItem
 */
operator fun <T> TreeItem<T>.plusAssign(child: TreeItem<T>) {
    this.children += child
}

operator fun <T> TreeItem<T>.minusAssign(child: TreeItem<T>) {
    this.children -= child
}

fun <T> TreeItem<T>.addAll(vararg children: TreeItem<T>) {
    this.children.addAll(children)
}

fun <T> TreeItem<T>.removeAll(vararg children: TreeItem<T>) {
    this.children.removeAll(children)
}

/**
 * TableView
 */
operator fun <T> TableView<T>.plusAssign(item: T) {
    this.items.toMutableList() += item
}

operator fun <T> TableView<T>.minusAssign(item: T) {
    this.items.toMutableList() -= item
}

fun <T> TableView<T>.addAll(vararg items: T) {
    this.items.addAll(items)
}

fun <T> TableView<T>.getSelectedItems() = this.selectionModel.selectedItems

fun <T> TableView<T>.focusIndex(index: Int) = this.focusModel.focus(index)

fun <T> TableView<T>.getIndexOf(item: T) = this.items.indexOf(item)

var <T> TableView<T>.selectedIndex: Int
    get() = this.selectionModel.selectedIndex
    set(index) = this.selectionModel.select(index)

var <T> TableView<T>.selectedItem: T
    get() = this.selectionModel.selectedItem
    set(item) = this.selectionModel.select(item)

/**
 * ListView
 */
operator fun <T> ListView<T>.plusAssign(item: T) {
    this.items.toMutableList() += item
}

operator fun <T> ListView<T>.minusAssign(item: T) {
    this.items.toMutableList() -= item
}

fun <T> ListView<T>.add(index: Int, item: T) {
    this.items.add(index, item)
}

fun <T> ListView<T>.removeAt(index: Int) {
    this.items.removeAt(index)
}

var <T> ListView<T>.focusedIndex: Int
    get() = this.focusModel.focusedIndex
    set(index) = this.focusModel.focus(index)

fun <T> ListView<T>.getFocusedItem() = this.focusModel.focusedItem

fun <T> ListView<T>.focusNext() = this.focusModel.focusNext()

fun <T> ListView<T>.focusPrevious() = this.focusModel.focusPrevious()

fun <T> ListView<T>.isFocused(index: Int) = this.focusModel.isFocused(index)

fun <T> ListView<T>.selectItem(item: T) = this.selectionModel.select(item)

fun <T> ListView<T>.selectIndex(index: Int) = this.selectionModel.select(index)

/**
 * ChoiceBox
 */
operator fun <T> ChoiceBox<T>.plusAssign(item: T) {
    this.items.toMutableList() += item
}

operator fun <T> ChoiceBox<T>.minusAssign(item: T) {
    this.items.toMutableList() -= item
}

fun <T> ChoiceBox<T>.addAll(vararg items: T) = this.items.addAll(items)

fun <T> ChoiceBox<T>.removeAll(vararg items: T) = this.items.removeAll(items)

var <T> ChoiceBox<T>.selectedIndex: Int
    get() = this.selectionModel.selectedIndex
    set(index) = this.selectionModel.select(index)

var <T> ChoiceBox<T>.selectedItem: T
    get() = this.selectionModel.selectedItem
    set(item) = this.selectionModel.select(item)

/**
 * ComboBox
 */
operator fun <T> ComboBox<T>.plusAssign(item: T) {
    this.items.toMutableList() += item
}

operator fun <T> ComboBox<T>.minusAssign(item: T) {
    this.items.toMutableList() -= item
}

fun <T> ComboBox<T>.addAll(vararg items: T) = this.items.addAll(items)

fun <T> ComboBox<T>.removeAll(vararg items: T) = this.items.removeAll(items)

var <T> ComboBox<T>.selectedIndex: Int
    get() = this.selectionModel.selectedIndex
    set(index) = this.selectionModel.select(index)

var <T> ComboBox<T>.selectedItem: T
    get() = this.selectionModel.selectedItem
    set(item) = this.selectionModel.select(item)

/**
 * TabPane
 */
operator fun TabPane.plusAssign(tab: Tab) {
    this.tabs += tab
}

operator fun TabPane.minusAssign(tab: Tab) {
    this.tabs -= tab
}

fun TabPane.addAll(vararg tabs: Tab) = this.tabs.addAll(tabs)

fun TabPane.removeAll(vararg tabs: Tab) = this.tabs.removeAll(tabs)

fun TabPane.selectFirst() = this.selectionModel.selectFirst()

fun TabPane.selectLast() = this.selectionModel.selectLast()

fun TabPane.selectNext() = this.selectionModel.selectNext()

fun TabPane.selectPrevious() = this.selectionModel.selectPrevious()

var TabPane.selectedIndex: Int
    get() = this.selectionModel.selectedIndex
    set(index) = this.selectionModel.select(index)

var TabPane.selectedItem: Tab
    get() = this.selectionModel.selectedItem
    set(item) = this.selectionModel.select(item)

/**
 * Toolbar
 */
operator fun ToolBar.plusAssign(item: Node) {
    this.items += item
}

operator fun ToolBar.minusAssign(item: Node) {
    this.items -= item
}

fun ToolBar.addAll(vararg items: Node) = this.items.addAll(items)

fun ToolBar.removeAll(vararg items: Node) = this.items.removeAll(items)

/**
 * Accordion
 */
operator fun Accordion.plusAssign(pane: TitledPane) {
    this.panes += pane
}

operator fun Accordion.minusAssign(pane: TitledPane) {
    this.panes -= pane
}

fun Accordion.addAll(vararg panes: TitledPane) {
    this.panes.addAll(panes)
}

fun Accordion.removeAll(vararg panes: TitledPane) {
    this.panes.removeAll(panes)
}

/**
 * MenuBar
 */
operator fun MenuBar.plusAssign(menu: Menu) {
    this.menus += menu
}

operator fun MenuBar.minusAssign(menu: Menu) {
    this.menus -= menu
}

fun MenuBar.addAll(vararg menues: Menu) {
    this.menus.addAll(menues)
}

fun MenuBar.removeAll(vararg menues: Menu) {
    this.menus.removeAll(menues)
}

/**
 * ButtonBar
 */
operator fun ButtonBar.plusAssign(button: Button) {
    this.buttons += button
}

operator fun ButtonBar.minusAssign(button: Button) {
    this.buttons -= button
}

fun ButtonBar.addAll(vararg buttons: Button) {
    this.buttons.addAll(buttons)
}

fun ButtonBar.removeAll(vararg buttons: Button) {
    this.buttons.removeAll(buttons)
}

/**
 * Other
 */
fun FileChooser.addExtensionFilter(description: String, vararg extensions: String) {
    this.extensionFilters.add(FileChooser.ExtensionFilter(description, *extensions))
}

fun Stage.addIcons(vararg icons: String) = icons.forEach { this.icons += Image(it) }

fun Scene.addStylesheet(stylesheet: String) = stylesheets.add(stylesheet)