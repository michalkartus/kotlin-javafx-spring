package pl.kartus.appfx.viewmodel

import javafx.beans.property.SimpleStringProperty
import org.springframework.stereotype.Component
import pl.kartus.appfx.util.getErrorMsg
import java.util.*

@Component
class ErrorViewModelImpl(
    private val i18n: ResourceBundle
): ErrorViewModel {

    override val exceptionMessage = SimpleStringProperty()

    override fun setExceptionMessage(e: Throwable) {
        exceptionMessage.set(getErrorMsg(i18n, e))
    }

    override fun resetExceptionMessage() {
        exceptionMessage.set("")
    }

}
