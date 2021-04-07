package pl.kartus.appfx.viewmodel

import javafx.beans.property.SimpleBooleanProperty

interface AppViewModel {

    val exceptionRaised: SimpleBooleanProperty

    fun handleException()

    fun exceptionHandled()
}