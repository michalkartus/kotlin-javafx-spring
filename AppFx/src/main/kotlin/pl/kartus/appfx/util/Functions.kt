package pl.kartus.appfx.util

import javafx.fxml.FXMLLoader
import org.springframework.context.ApplicationContext
import org.springframework.core.io.ClassPathResource
import java.lang.reflect.InvocationTargetException
import java.util.*


/**
 * it sets spring context get bean as a factory
 * for creating controller in fxml
 * and set i18n resources
 */
fun getFxmlLoader(
    resource: ClassPathResource,
    i18nResource: ResourceBundle,
    context: ApplicationContext
): FXMLLoader {
    val fxmlLoader = FXMLLoader(resource.url)
    fxmlLoader.resources = i18nResource
    fxmlLoader.setControllerFactory { context.getBean(it) }
    return fxmlLoader
}

/**
 * get error message for Exception
 */
fun getErrorMsg(
    i18Resource: ResourceBundle,
    e: Throwable
): String {

    val cause = getRealException(e)

    val exceptionString = i18Resource
        .getString("error.exception")
        .format(cause.toString())

    val details = i18Resource
        .getString("error.details")
    return "$exceptionString\n" +
            details
}

/**
 *
 * in case if exception is InvocationTargetException it returns "real" exception
 * @return original Exception or target Exception of InvocationTargetException
 */
fun getRealException(e: Throwable): Throwable =
    if ( e.cause is InvocationTargetException ) {
        (e.cause as InvocationTargetException).targetException
    } else {
        e
    }

