package com.github.gonozalviii.kopperfx

import javafx.beans.value.ObservableValue
import javafx.beans.value.WritableValue
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ComboBox
import javafx.scene.control.TableView
import javafx.scene.control.TreeItem
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
 * Other
 */
fun FileChooser.addExtensionFilter(description: String, vararg extensions: String) {
    this.extensionFilters.add(FileChooser.ExtensionFilter(description, *extensions))
}

fun Stage.addIcons(vararg icons: String) = icons.forEach { this.icons += Image(it) }