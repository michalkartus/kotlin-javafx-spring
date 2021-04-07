package pl.kartus.appfx.integration

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest
class AppFxApplicationTest {

    @Autowired
    lateinit var context: ApplicationContext

    @Test
    fun contextLoads() {
        assertNotNull(context)
    }

}
