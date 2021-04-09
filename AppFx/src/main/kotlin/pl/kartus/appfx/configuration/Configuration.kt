package pl.kartus.appfx.configuration

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*


@Configuration
class Configuration {

    @Bean
    fun getLogger(): Logger {
        return LoggerFactory.getLogger("JavaFx Logger")
    }

    @Bean
    fun getLocale(): Locale {
        return Locale("pl", "PL")
    }

    @Bean
    fun getI18nResourceBundle(locale: Locale): ResourceBundle {
        return ResourceBundle.getBundle("i18n/messages", locale)
    }

}