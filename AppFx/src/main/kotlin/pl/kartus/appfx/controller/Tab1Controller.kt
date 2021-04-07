package pl.kartus.appfx.controller

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.TextArea
import org.slf4j.Logger
import org.springframework.stereotype.Controller
import pl.kartus.appfx.viewmodel.Tab1ViewModel

@Controller
class Tab1Controller(
    private val logger: Logger,
    private val viewModel: Tab1ViewModel
) {

    @FXML
    lateinit var textArea1: TextArea

    @FXML
    fun initialize() {
        logger.info("FXML Initialize")
        configureViewModel()
    }

    private fun configureViewModel() {
        textArea1.textProperty().bindBidirectional(viewModel.textAreaMsg)
    }

    @FXML
    private fun throwExceptionButtonHandler(actionEvent: ActionEvent) {
        viewModel.doSomethingRisky((actionEvent.source as Button).id)
    }

}
