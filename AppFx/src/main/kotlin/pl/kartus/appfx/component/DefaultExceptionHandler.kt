package pl.kartus.appfx.component

import org.slf4j.Logger
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.stereotype.Component
import pl.kartus.appfx.event.ExceptionThrownEvent
import pl.kartus.appfx.util.exception

@Component
class DefaultExceptionHandler(
        val logger: Logger,
        val context: ConfigurableApplicationContext
): Thread.UncaughtExceptionHandler {

    /**
     * Handling all uncaught exceptions
     */
    override fun uncaughtException(t: Thread, e: Throwable) {
        logger.exception(t,e)
        context.publishEvent(ExceptionThrownEvent(t,e))
    }
}