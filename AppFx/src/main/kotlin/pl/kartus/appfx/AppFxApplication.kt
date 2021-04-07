package pl.kartus.appfx

import com.sun.javafx.application.LauncherImpl
import javafx.application.Application
import javafx.application.Platform
import javafx.stage.Stage
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext
import pl.kartus.appfx.component.DefaultExceptionHandler
import pl.kartus.appfx.event.StageReadyEvent


class AppFxApplication : Application() {

    private lateinit var context: ConfigurableApplicationContext

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            LauncherImpl.launchApplication(AppFxApplication::class.java, AppPreloader::class.java, args)
        }
    }

    override fun init() {
        context = runApplication<Launcher>(*parameters.raw.toTypedArray())
        context.registerShutdownHook()
    }

    override fun start(primaryStage: Stage) {
        Thread.setDefaultUncaughtExceptionHandler(context.getBean(DefaultExceptionHandler::class.java))
        context.publishEvent(StageReadyEvent(primaryStage))
    }

    override fun stop() {
        Platform.exit()
    }
}

