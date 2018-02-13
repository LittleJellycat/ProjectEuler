import java.nio.file.Files
import java.nio.file.Paths
import kotlin.math.min

fun main(args: Array<String>) {
    val numbers = Files.readAllLines(Paths.get("C:\\Users\\MMUSER\\IdeaProjects\\projecteuler\\src\\matrix")).map { it.split(",") }.map { it.map { it.toInt() }.toMutableList() }.toMutableList()
    val matrix = (0 until 80).map { numbers[it] }.toMutableList()
    for (i in 79 downTo 0) {
        for (j in 79 downTo 0) {
            when {
                i == 79 && j == 79 -> matrix[i][j] = matrix[i][j]
                j == 79 -> matrix[i][j] += matrix[i + 1][j]
                i == 79 -> matrix[i][j] += matrix[i][j + 1]
                else -> matrix[i][j] += min(matrix[i + 1][j], matrix[i][j + 1])
            }
        }
    }
    println(matrix[0][0])
}
