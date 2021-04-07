package pl.kartus.appfx.util

import org.slf4j.Logger

fun Logger.exception(t: Thread?, e: Throwable?) {
    error("Exception in thread: ${t?.name}")
    error("${e?.toString()}", e)
}