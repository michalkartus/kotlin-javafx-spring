package pl.kartus.appfx
import javafx.application.Platform
import javafx.application.Preloader
import javafx.scene.Scene
import javafx.scene.control.ProgressBar
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Region
import javafx.scene.layout.VBox
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.WindowEvent
import pl.kartus.appfx.configuration.NumValues


class AppPreloader : Preloader() {

    private lateinit var stage: Stage

    private var start: Long = 0
    private var stop: Long = 0

    override fun start(primaryStage: Stage) {
        start = System.currentTimeMillis()
        stage = primaryStage

        setUpStage()
    }

    private fun setUpStage() {
        val loading = VBox()
        loading.maxWidth = Region.USE_PREF_SIZE
        loading.maxHeight = Region.USE_PREF_SIZE
        loading.children.add(ProgressBar())

        val root = BorderPane(loading)
        val scene = Scene(root)

        stage.apply {
            this.scene = scene
            width = NumValues.PRELOADER_WIDTH
            height = NumValues.PRELOADER_HEIGHT
            initStyle(StageStyle.UNDECORATED)
            show()
            setOnCloseRequest {
                if ( it.eventType == WindowEvent.WINDOW_CLOSE_REQUEST )
                    Platform.exit()
            }
        }

    }

    override fun handleStateChangeNotification(info: StateChangeNotification?) {
        stop = System.currentTimeMillis()
        if ( info?.type == StateChangeNotification.Type.BEFORE_START ) {
            println("Time in preloader: ${stop - start} ms")
            stage.hide()
        }
    }

}