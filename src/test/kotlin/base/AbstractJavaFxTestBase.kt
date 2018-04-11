package base

import javafx.embed.swing.JFXPanel
import org.junit.jupiter.api.BeforeAll

/**
 * Created by ext_PSchoenhusen, Opitz Consulting Deutschland GmbH, on 10.04.2018
 */
abstract class AbstractJavaFxTestBase {

    companion object {
        @BeforeAll
        @JvmStatic
        fun classSetup() {
            JFXPanel() // init JavaFX
        }
    }

}