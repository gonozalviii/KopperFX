package utility

import com.github.gonozalviii.kopperfx.utility.launch
import com.github.gonozalviii.kopperfx.utility.loadFXML
import javafx.application.Application
import javafx.application.Platform
import javafx.application.Preloader
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

/**
 * Created by ext_PSchoenhusen, Opitz Consulting Deutschland GmbH, on 10.04.2018
 */

class UtilityTest {


    @Nested
    class ManualTests {

        companion object {
            @JvmStatic
            var testResult = ""
            @JvmStatic
            var preloadResult = ""
        }

        @BeforeEach
        fun setUp() {
            testResult = ""
            preloadResult = ""
        }

        @Test
        @DisplayName("reading an fxml file should create a anchor pane with correct attributes")
        fun readingFxml() {
            val anchorPane = loadFXML<AnchorPane>("/test.fxml")
            assertEquals(639.0,anchorPane.prefWidth, "pane has incorrect width")
            assertEquals(417.0,anchorPane.prefHeight, "pane has incorrect height")
        }

        @Test
        @Disabled("only run manually, since launch can only be called once per VM")
        @DisplayName("calling launch application with generic type should start application")
        fun launchApplicationGenericType() {
            launch<TestApp>(arrayOf())
            assertEquals("launched", testResult, "application was not launched")
        }

        @Test
        @Disabled("only run manually, since launch can only be called once per VM")
        @DisplayName("calling launch application with parameter should start application")
        fun launchApplicationParameter() {
            launch<TestApp>(arrayOf(), TestPreLoader::class.java)
            assertEquals("launched", testResult, "application was not launched")
            assertEquals("pre loaded", preloadResult, "pre-loader was not launched")
        }

        class TestApp : Application() {
            override fun start(primaryStage: Stage?) {
                testResult = "launched"
                Platform.exit()
            }
        }

        class TestPreLoader : Preloader() {
            override fun start(primaryStage: Stage?) {
                preloadResult = "pre loaded"
            }
        }

    }

}
