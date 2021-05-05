import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WithScopeFunctionTest {

    @Test
    fun `test with scope function by calling other functions on object context`() {
        val joe = Person("Joe Rogan", 53, "Podcast Host", "California")
        var jreHostName = "Jamie"
        with(joe) {
            jreHostName = name
            relocate("Austin")
        }

        assertEquals("Austin", joe.location)
        assertEquals("Joe Rogan", jreHostName)
    }

    @Test
    fun `test with scope function by returning value from lambda`() {
        val elon = Person("Elon Musk", 49, "CEO", "California")
        val expected = "Name: Elon Musk, Age: 49, Occupation: CEO, Location: California"
        val summary = with(elon) {
            "Name: $name, Age: $age, Occupation: $occupation, Location: $location"
        }

        assertEquals(expected, summary)
    }
}