package pl.kartus.appfx.configuration

import javafx.fxml.FXMLLoader
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import pl.kartus.appfx.util.getFxmlLoader
import java.util.*

@Configuration
class ErrorConfiguration {

    companion object {
        const val FXML = "errorFxml"
        const val FXML_LOADER = "errorFxmlLoader"
    }

    @Bean(name = [FXML])
    fun getErrorClassPathResource(): ClassPathResource {
        return ClassPathResource("/fxml/error.fxml")
    }

    @Bean(name = [FXML_LOADER])
    fun getErrorFXMLLoader(
        @Qualifier(FXML) resource: ClassPathResource,
        i18nResource: ResourceBundle,
        context: ApplicationContext
    ): FXMLLoader
            = getFxmlLoader(resource, i18nResource, context)

}