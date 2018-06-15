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

import com.github.gonozalviii.kopperfx.extensions.getValue
import com.github.gonozalviii.kopperfx.extensions.setValue
import javafx.beans.property.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by ext_PSchoenhusen, Opitz Consulting Deutschland GmbH, on 11.04.2018
 */
class PropertyTest {
    // we need at least 1 property as a field to justify the import statement
    val nameProperty = SimpleStringProperty()
    var name by nameProperty

    @Test
    fun `check Integer property delegate`() {
        val ageProperty = SimpleIntegerProperty()
        var age by ageProperty

        age = 18
        assertEquals(18, ageProperty.get(), "wrong value for JavaFX Integer property")

        ageProperty.set(21)
        assertEquals(21, age, "wrong value for Int kotlin property")
    }

    @Test
    fun `check Long property delegate`() {
        val ageProperty = SimpleLongProperty()
        var age by ageProperty

        age = 18
        assertEquals(18, ageProperty.get(), "wrong value for JavaFX long property")

        ageProperty.set(21)
        assertEquals(21, age, "wrong value for Long kotlin property")
    }

    @Test
    fun `check Float property delegate`() {
        val ageProperty = SimpleFloatProperty()
        var age by ageProperty

        age = 18f
        assertEquals(18f, ageProperty.get(), "wrong value for JavaFX float property")

        ageProperty.set(21f)
        assertEquals(21f, age, "wrong value for Float kotlin property")
    }

    @Test
    fun `check Double property delegate`() {
        val ageProperty = SimpleDoubleProperty()
        var age by ageProperty

        age = 18.0
        assertEquals(18.0, ageProperty.get(), "wrong value for JavaFX int property")

        ageProperty.set(21.0)
        assertEquals(21.0, age, "wrong value for Double kotlin property")
    }

    @Test
    fun `check Boolean property delegate`() {
        val marriedProperty = SimpleBooleanProperty(false)
        var married by marriedProperty

        married = true
        assertTrue(marriedProperty.get(), "wrong value for JavaFX boolean property")
        marriedProperty.set(false)
        assertFalse(married, "wrong value for Boolean kotlin property")
    }

}