import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AlsoScopeFunctionTest {

    @Test
    fun `test the also scope function with a reference to an object instead of its properties`() {
        val service = Service("localhost", 80)
        service.also {
            changeDestination(it, "www.google.com") // maybe a proxy or something?
        }

        assertEquals("www.google.com", service.url)
    }
}