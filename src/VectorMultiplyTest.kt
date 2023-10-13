import org.junit.Test
import kotlin.test.assertEquals

class VectorMultiplyTest {

    @Test
    fun scalarFirst() {
        val vectorFirst = Vector(1, 2, 3)
        val vectorSecond = Vector(4, 5, 6)
        val actual = VectorSolution(vectorFirst, vectorSecond).scalarMultiply()
        val expected = 32
        assertEquals(actual, expected)
    }

    @Test
    fun scalarSecond() {
        val actual = VectorSolution(Vector(15, -231, 53), Vector(-62, 6, -512)).scalarMultiply()
        val expected = -29452
        assertEquals(actual, expected)
    }

    @Test
    fun scalarThird() {
        val actual = VectorSolution(Vector(-123, -512, -5125), Vector(123, 0, 12512)).scalarMultiply()
        val expected = -64139129
        assertEquals(actual, expected)
    }

    @Test
    fun vectorFirst() {
        val actual = VectorSolution(Vector(1, 2, 3), Vector(4, 5, 6)).vectorMultiply().vectorCoordinates()
        val expected = Vector(-3, 6, -3).vectorCoordinates()
        assertEquals(actual, expected)
    }

    @Test
    fun vectorSecond() {
        val actual = VectorSolution(Vector(4, -3, 15), Vector(13, 45, -10)).vectorMultiply().vectorCoordinates()
        val expected = Vector(-645, 235, 219).vectorCoordinates()
        assertEquals(actual, expected)
    }

    @Test
    fun vectorThird() {
        val actual = VectorSolution(Vector(2314, 9023, 414), Vector(7654, 23545, -75373)).vectorMultiply().vectorCoordinates()
        val expected = Vector(-689838209, 177581878, -14578912).vectorCoordinates()
        assertEquals(actual, expected)
    }
}