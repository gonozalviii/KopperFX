package utility

import com.github.gonozalviii.kopperfx.utility.launch
import javafx.application.Platform
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Created by ext_PSchoenhusen, Opitz Consulting Deutschland GmbH, on 24.04.2018
 */
class PreloadTest {

    companion object {
        @JvmStatic
        var testResult = ""
        @JvmStatic
        var preloadResult = ""
    }

    @Test
    @DisplayName("calling launch application with parameter should start application")
    fun launchApplicationParameter() {
        launch<TestApp>(arrayOf(), TestPreLoader::class.java)
        Assertions.assertEquals("launched", testResult, "application was not launched")
        Assertions.assertEquals("pre loaded", preloadResult, "pre-loader was not launched")
        Platform.exit()
    }
}