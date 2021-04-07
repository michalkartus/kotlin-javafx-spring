package pl.kartus.appfx.viewmodel

import javafx.beans.property.SimpleBooleanProperty
import org.springframework.stereotype.Component

@Component
class AppViewModelImpl: AppViewModel {

    override val exceptionRaised = SimpleBooleanProperty(false)

    override fun handleException() {
        exceptionRaised.set(true)
    }

    override fun exceptionHandled() {
        exceptionRaised.set(false)
    }

}

