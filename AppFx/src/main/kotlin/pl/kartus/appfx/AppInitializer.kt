package pl.kartus.appfx

import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import pl.kartus.appfx.configuration.AppConfiguration
import pl.kartus.appfx.event.StageReadyEvent
import java.util.*

@Component
class AppInitializer(
    @Qualifier(AppConfiguration.FXML_LOADER)
    private val appFxmlLoader: FXMLLoader,
    i18n: ResourceBundle
) : ApplicationListener<StageReadyEvent> {

    val title = i18n.getString("app.title") ?: "appFx"

    override fun onApplicationEvent(event: StageReadyEvent) {
        val stage = event.stage
        stage.scene = Scene(appFxmlLoader.load())
        stage.title = title
        stage.show()
    }

}