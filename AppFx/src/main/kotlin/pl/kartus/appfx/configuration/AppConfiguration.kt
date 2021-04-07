package pl.kartus.appfx.configuration

import javafx.fxml.FXMLLoader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import pl.kartus.appfx.util.getFxmlLoader
import java.util.*


@Configuration
class AppConfiguration {

    companion object {
        const val FXML = "appFxml"
        const val FXML_LOADER = "appFxmlLoader"
    }

    @Bean( name = [FXML])
    fun getAppClassPathResource(): ClassPathResource {
        return ClassPathResource("/fxml/app.fxml")
    }

    @Bean( name = [FXML_LOADER])
    fun getAppFXMLLoader(
            @Qualifier(FXML) resource: ClassPathResource,
            i18nResource: ResourceBundle,
            context: ApplicationContext
    ): FXMLLoader
            = getFxmlLoader(resource, i18nResource, context)

}