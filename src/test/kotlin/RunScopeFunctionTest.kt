
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RunScopeFunctionTest {

    @Test
    fun `test object initialization and return value calculation with run scope function`() {
        val expected = Response("", 200)
        val service = Service("localhost", 80)
        val response = service.run {
            port = 8080
            getResponse()
        }

        assertEquals(8080, service.port)
        assertEquals(expected, response)
    }

    @Test
    fun `test run scope function as a non-extension function`() {
        val responses = run {
            val okResponse = Response("OK", 200)
            val createdResponse = Response("CREATED", 201)
            val notFoundResponse = Response("NOT FOUND", 404)
            val serverErrorResponse = Response("INTERNAL SERVER ERROR", 500)

            listOf(okResponse, createdResponse, notFoundResponse, serverErrorResponse)
        }

        val goodResponses = responses.filter { it.statusCode <= 300 }

        assertEquals(2, goodResponses.size)
        assertEquals(200, goodResponses[0].statusCode)
        assertEquals(201, goodResponses[1].statusCode)
    }
}