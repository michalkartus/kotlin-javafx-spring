package pl.kartus.appfx.viewmodel

import javafx.beans.property.SimpleStringProperty
import org.springframework.stereotype.Component
import java.util.*
import kotlin.random.Random

@Component
class Tab1ViewModelImpl(
    private val i18n: ResourceBundle
): Tab1ViewModel {

    override val textAreaMsg = SimpleStringProperty()

    override fun doSomethingRisky(sourceId: String) {
        val oldMsg =  textAreaMsg.get()
        val newMsg = i18n.getString("tab1.textArea1.buttonClickedInfo")
            .format(sourceId)

        val updated: String = when (oldMsg) {
            null -> newMsg
            else -> oldMsg + "\n" + newMsg
        }

        textAreaMsg.set(updated)

        throw Exception(Random.nextInt(1000).toString())
    }

}