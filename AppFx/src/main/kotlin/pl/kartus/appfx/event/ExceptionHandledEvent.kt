package pl.kartus.appfx.event

import org.springframework.context.ApplicationEvent

class ExceptionHandledEvent(
        @Suppress("CanBeParameter")
        val t: Thread,
        @Suppress("unused")
        val e: Throwable) : ApplicationEvent(t)