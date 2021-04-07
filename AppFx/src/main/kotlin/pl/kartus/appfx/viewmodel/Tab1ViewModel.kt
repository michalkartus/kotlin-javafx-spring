package pl.kartus.appfx.viewmodel

import javafx.beans.property.SimpleStringProperty

interface Tab1ViewModel {

    val textAreaMsg: SimpleStringProperty

    fun doSomethingRisky(sourceId: String)

}