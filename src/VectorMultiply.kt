import java.util.Scanner

interface Multiply {

    fun scalarMultiply(): Int

    fun vectorMultiply(): Vector
}

interface Coordinates {
    fun vectorCoordinates(): List<Int>
}

class Vector(
    private val x: Int,
    private val y: Int,
    private val z: Int
) : Coordinates {
    override fun vectorCoordinates(): List<Int> {
        return listOf(x, y, z)
    }
}

class VectorSolution(
    private val firstVector: Vector,
    private val secondVector: Vector
) : Multiply {
    private val listFirst = mutableListOf<Int>()
    private val listSecond = mutableListOf<Int>()

    override fun scalarMultiply(): Int {
        var scalar = 0
        firstVector.vectorCoordinates().forEach {
            listFirst.add(it)
        }
        secondVector.vectorCoordinates().forEach {
            listSecond.add(it)
        }
        for (i in 0 until listFirst.size) {
            scalar += listFirst[i] * listSecond[i]
        }
        return scalar
    }

    override fun vectorMultiply(): Vector {
        firstVector.vectorCoordinates().forEach {
            listFirst.add(it)
        }
        secondVector.vectorCoordinates().forEach {
            listSecond.add(it)
        }
        return Vector(
            listFirst[1] * listSecond[2] - listFirst[2] * listSecond[1],
            listFirst[2] * listSecond[0] - listFirst[0] * listSecond[2],
            listFirst[0] * listSecond[1] - listFirst[1] * listSecond[0]
        )
    }
}

fun main() {
    print("Enter x1: ")
    val x1 = Scanner(System.`in`).nextInt()
    print("Enter y1: ")
    val y1 = Scanner(System.`in`).nextInt()
    print("Enter z1: ")
    val z1 = Scanner(System.`in`).nextInt()
    print("Enter x2: ")
    val x2 = Scanner(System.`in`).nextInt()
    print("Enter y2: ")
    val y2 = Scanner(System.`in`).nextInt();
    print("Enter z2: ")
    val z2 = Scanner(System.`in`).nextInt()

    val vectorFirst = Vector(x1, y1, z1)
    val vectorSecond = Vector(x2, y2, z2)
    println("Scalar multiplication: " + VectorSolution(vectorFirst, vectorSecond).scalarMultiply())
    println(
        "Vector multiplication: " +
                VectorSolution(
                    vectorFirst,
                    vectorSecond
                ).vectorMultiply().vectorCoordinates()
    )
}