package pl.kartus.appfx.controller

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Modality
import javafx.stage.Stage
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Controller
import pl.kartus.appfx.configuration.ErrorConfiguration
import pl.kartus.appfx.event.ExceptionThrownEvent
import pl.kartus.appfx.viewmodel.AppViewModel
import java.util.*

@Controller
class AppController(
    private val viewModel: AppViewModel,
    private val i18n: ResourceBundle,
    @Qualifier(ErrorConfiguration.FXML_LOADER)
    private val errorFxmlLoader: FXMLLoader
) {

    lateinit var stage: Stage

    @FXML
    @Suppress("UNUSED_ANONYMOUS_PARAMETER")
    fun initialize() {
        initErrorStage()
        configureViewModel()
    }

    private fun initErrorStage() {
        stage = Stage()
        stage.apply {
            scene = Scene(errorFxmlLoader.load())
            initModality(Modality.APPLICATION_MODAL)
            title = i18n.getString("app.title") +
                    " - " + i18n.getString("error.stage.title")

            setOnHiding {
                // execute error controller onHiding method
                val controller = errorFxmlLoader.getController<ErrorController>()
                controller.onHiding()
                // call app viewModel exception handler
                viewModel.exceptionHandled()
            }
        }
    }

    private fun configureViewModel() {
        // observing viewModel if exception is raised
        viewModel.exceptionRaised.addListener {
                _, _, newValue ->
            if (newValue == true) {
                stage.show()
            }
            else {
                stage.hide()
            }
        }
    }

    @EventListener
    fun handleException(event: ExceptionThrownEvent) {
        viewModel.handleException()
    }

}