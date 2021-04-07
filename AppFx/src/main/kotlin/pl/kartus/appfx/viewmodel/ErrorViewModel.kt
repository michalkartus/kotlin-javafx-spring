package pl.kartus.appfx.viewmodel

import javafx.beans.property.SimpleStringProperty

interface ErrorViewModel {

    val exceptionMessage: SimpleStringProperty

    fun setExceptionMessage(e: Throwable)

    fun resetExceptionMessage()

}
