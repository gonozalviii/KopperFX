package extensions

import com.github.gonozalviii.kopperfx.extensions.getValue
import com.github.gonozalviii.kopperfx.extensions.setValue
import javafx.beans.property.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Created by ext_PSchoenhusen, Opitz Consulting Deutschland GmbH, on 11.04.2018
 */
class PropertyTest {
    // we need at least 1 property as a field to justify the import statement
    val nameProperty = SimpleStringProperty()
    var name by nameProperty

    @Test
    @DisplayName("check Integer property delegate")
    fun propertyDelegateInteger() {
        val ageProperty = SimpleIntegerProperty()
        var age by ageProperty

        age = 18
        assertEquals(18, ageProperty.get(), "wrong value for JavaFX Integer property")

        ageProperty.set(21)
        assertEquals(21, age, "wrong value for Int kotlin property")
    }

    @Test
    @DisplayName("check Long property delegate")
    fun propertyDelegateLong() {
        val ageProperty = SimpleLongProperty()
        var age by ageProperty

        age = 18
        assertEquals(18, ageProperty.get(), "wrong value for JavaFX long property")

        ageProperty.set(21)
        assertEquals(21, age, "wrong value for Long kotlin property")
    }

    @Test
    @DisplayName("check Float property delegate")
    fun propertyDelegateFloat() {
        val ageProperty = SimpleFloatProperty()
        var age by ageProperty

        age = 18f
        assertEquals(18f, ageProperty.get(), "wrong value for JavaFX float property")

        ageProperty.set(21f)
        assertEquals(21f, age, "wrong value for Float kotlin property")
    }

    @Test
    @DisplayName("check Double property delegate")
    fun propertyDelegateDouble() {
        val ageProperty = SimpleDoubleProperty()
        var age by ageProperty

        age = 18.0
        assertEquals(18.0, ageProperty.get(), "wrong value for JavaFX int property")

        ageProperty.set(21.0)
        assertEquals(21.0, age, "wrong value for Double kotlin property")
    }

    @Test
    @DisplayName("check Boolean property delegate")
    fun propertyDelegateBoolean() {
        val marriedProperty = SimpleBooleanProperty(false)
        var married by marriedProperty

        married = true
        assertTrue(marriedProperty.get(), "wrong value for JavaFX boolean property")
        marriedProperty.set(false)
        assertFalse(married, "wrong value for Boolean kotlin property")
    }

}