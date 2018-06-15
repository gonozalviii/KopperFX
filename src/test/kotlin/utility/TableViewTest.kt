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

package utility

import base.AbstractJavaFxTestBase
import com.github.gonozalviii.kopperfx.extensions.getValue
import com.github.gonozalviii.kopperfx.extensions.plusAssign
import com.github.gonozalviii.kopperfx.utility.*
import javafx.application.Application
import javafx.beans.property.IntegerProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.SelectionMode
import javafx.scene.control.cell.TextFieldTableCell
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class TableViewTest : AbstractJavaFxTestBase() {

    @Test
    @Disabled
    fun buildTableView() {
        launch<TableTestApp>(arrayOf())
    }

    class Person(val name: String, val lastName:String, age: Int, val nationality: String) {
        val ageProperty: IntegerProperty = SimpleIntegerProperty(age)
        val age by ageProperty
    }

    class TableTestApp : Application() {
        override fun start(primaryStage: Stage) {

            val tableView = tableView<Person> {
                column<Person, String>("Name") {
                    subcolumn<Person, String>("First", "name") {
                        cellFactory = TextFieldTableCell.forTableColumn()
                    }
                    subcolumn("Age", Person::ageProperty)
                }
                column<Person, String>("Last", "lastName")
                placeholder = Label("nix hier")
                selectionMode = SelectionMode.SINGLE
            }
            tableView.column<Person, String>("Nationality", "nationality")

            tableView += Person("Hans", "Soundso", 99, "DE")

            val borderPane = BorderPane(tableView)
            val scene = Scene(borderPane)
            primaryStage.scene = scene
            primaryStage.show()
        }

    }

}
