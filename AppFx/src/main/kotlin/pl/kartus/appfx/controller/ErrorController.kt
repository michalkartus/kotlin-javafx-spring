package pl.kartus.appfx.controller

import javafx.fxml.FXML
import javafx.scene.control.Label
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Controller
import pl.kartus.appfx.event.ExceptionThrownEvent
import pl.kartus.appfx.viewmodel.ErrorViewModel


@Controller
class ErrorController(
    private val viewModel: ErrorViewModel
) {

    @FXML
    lateinit var errorMessageLabel: Label

    @FXML
    fun initialize() {
        configureViewModel()
    }

    private fun configureViewModel() {
        errorMessageLabel.textProperty().bind(viewModel.exceptionMessage)
    }

    @FXML
    fun onCloseButtonClicked() {
        this.errorMessageLabel.scene.window.hide()
    }

    /**
     * method executed from app controller when hiding this window
     */
    fun onHiding() {
        viewModel.resetExceptionMessage()
    }

    @EventListener
    fun handleException(event: ExceptionThrownEvent) {
        viewModel.setExceptionMessage(event.e)
    }


}