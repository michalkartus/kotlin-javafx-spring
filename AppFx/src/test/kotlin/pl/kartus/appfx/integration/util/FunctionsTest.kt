package pl.kartus.appfx.integration.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.core.io.ClassPathResource
import pl.kartus.appfx.configuration.ErrorConfiguration
import pl.kartus.appfx.util.getErrorMsg
import pl.kartus.appfx.util.getFxmlLoader
import java.util.*

@SpringBootTest
class FunctionsTest {

    @Autowired
    @Qualifier(ErrorConfiguration.FXML)
    lateinit var resource: ClassPathResource

    @Autowired
    lateinit var i18nResource: ResourceBundle

    @Autowired
    lateinit var context: ApplicationContext

    @Test
    fun `check if fxml is loaded properly`() {
        val loader = getFxmlLoader(resource,
                i18nResource,
                context)
        assertNotNull(loader, "Fxml Loader must be loaded")
    }

    @Test
    fun `test generating error message`() {
        val errorMessage = getErrorMsg(
                i18nResource,
                RuntimeException()
        )
        assertAll(
                Executable {
                    assertTrue(
                            !errorMessage.contains("%"),
                            "% it's just placeholder so it shouldn't appear in message")
                }
        )
    }
}