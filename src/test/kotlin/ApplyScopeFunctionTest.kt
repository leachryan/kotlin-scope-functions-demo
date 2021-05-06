import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ApplyScopeFunctionTest {
    
    @Test
    fun `test object configuration with the apply scope function`() {
        val person = Person("Average Joe", 20, "", "").apply {
            location = "Moorhead"
            occupation = "Engineer"
        }

        assertEquals("Moorhead", person.location)
        assertEquals("Engineer", person.occupation)
    }
}