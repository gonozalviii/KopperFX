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

package com.github.gonozalviii.kopperfx.utility

import javafx.beans.property.Property
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.control.cell.TreeItemPropertyValueFactory

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class TableDSL

var <T> TableView<T>.selectionMode: SelectionMode
    get() = this.selectionModel.selectionMode
    set(value) = this.selectionModel.setSelectionMode(value)

fun <T> tableView(block: (@TableDSL TableView<T>).() -> Unit): TableView<T> {
    val view = TableView<T>()
    view.block()
    return view
}

fun <T, S> TableView<T>.column(name: String, field: String = "", block: (@TableDSL TableColumn<T, S>).() -> Unit = {}): TableColumn<T, S> {
    val tableColumn = TableColumn<T, S>(name)
    tableColumn.block()
    if (field.isEmpty().not()) {
        tableColumn.cellValueFactory = PropertyValueFactory<T, S>(field)
    }
    this.columns += tableColumn
    return tableColumn
}

fun <T, S> TableView<T>.column(name: String, propertyCallback: (T) -> Property<S>, block: (@TableDSL TableColumn<T, S>).() -> Unit = {}): TableColumn<T, S> {
    val tableColumn = TableColumn<T, S>(name)
    tableColumn.block()
    tableColumn.setCellValueFactory { propertyCallback(it.value) }
    this.columns += tableColumn
    return tableColumn
}

fun <T, U> TableColumn<T, *>.subcolumn(name: String, field: String, block: (@TableDSL TableColumn<T, U>).() -> Unit = {}): TableColumn<T, U> {
    val tableColumn = TableColumn<T, U>(name)
    tableColumn.block()
    tableColumn.cellValueFactory = PropertyValueFactory<T, U>(field)
    this.columns += tableColumn
    return tableColumn
}

fun <T, U> TableColumn<T, *>.subcolumn(name: String, propertyCallback: (T) ->  Property<U>, block: (@TableDSL TableColumn<T, U>).() -> Unit = {}): TableColumn<T, U> {
    val tableColumn = TableColumn<T, U>(name)
    tableColumn.block()
    tableColumn.setCellValueFactory { propertyCallback(it.value) }
    this.columns += tableColumn
    return tableColumn
}

fun <T> treeTableView(block: TreeTableView<T>.() -> Unit): TreeTableView<T> {
    val view = TreeTableView<T>()
    view.block()
    return view
}

fun <T, S> TreeTableView<T>.column(name: String, field: String): TreeTableColumn<T, S> {
    val tableColum = TreeTableColumn<T, S>(name)
    tableColum.cellValueFactory = TreeItemPropertyValueFactory<T, S>(field)
    this.columns += tableColum
    return tableColum
}
