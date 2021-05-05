
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LetScopeFunctionTest {

    @Test
    fun `test updating object properties with let scope function`() {
        val thor = Person("Thor", 2000, "God of Thunder", "Asgard")
        thor.let {
            it.haveBirthday()
            it.relocate("Midgard")
        }

        assertEquals(2001, thor.age)
        assertEquals("Midgard", thor.location)
    }

    @Test
    fun `test returning a value from a let scope function`() {
        // The return value comes from the last line of the lambda
        val tyr = Person("Tyr", 2000, "God of Warz", "Asgard")
        val expected = "Summary - Name: Tyr, Age: 2000, Occupation: God of War, Location: Asgard"
        val summary = tyr.let {
            it.acceptNewJob("God of War")
            it.getPersonSummary()
        }

        assertEquals(expected, summary)
    }

    @Test
    fun `test let scope function with chain of function calls`() {
        val odin = Person("Odin", 2000, "Wise One", "Asgard")
        val thor = Person("Thor", 2000, "God of Thunder", "Midgard")
        val tyr = Person("Tyr", 2000, "God of Warz", "Asgard")

        val expected = listOf("Odin", "Tyr")

        val gods = listOf(odin, thor, tyr)

        // Using let, we can map through the filtered items in the array and update a value before passing along to the next chain
        val movedGods = gods.filter { it.location == "Asgard" }.let { filtered -> filtered.map { it.relocate("Midgard") } }.map { it.name }

        assertEquals(expected, movedGods)
    }

    @Test
    fun `test using let for better code readability1`() {
        val theNeedle = "This is the needle!"
        var foundTheNeedle = false
        val haystack = listOf("A word", "another word", theNeedle, "some extra words", "not the needle")

        haystack.first { it == theNeedle }.let { needle: String ->
            foundTheNeedle = true
        }

        assertTrue { foundTheNeedle }
    }
}