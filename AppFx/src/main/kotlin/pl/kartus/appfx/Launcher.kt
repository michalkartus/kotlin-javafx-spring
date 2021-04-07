package pl.kartus.appfx

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Launcher {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AppFxApplication.main(args)
        }
    }
}