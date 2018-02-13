import java.nio.file.Files
import java.nio.file.Paths
import kotlin.math.min

fun main(args: Array<String>) {
    val numbers = Files.readAllLines(Paths.get("C:\\Users\\MMUSER\\IdeaProjects\\projecteuler\\src\\matrix")).map { it.split(",") }.map { it.map { it.toInt() }.toMutableList() }.toMutableList()
    val matrix = (0 until 5).map { numbers[it] }.toMutableList()
    val paths = Array<IntArray>(matrix.size, { IntArray(matrix.size) })
    for (i in matrix.size - 1 downTo 0) {
        for (j in matrix.size - 1 downTo 1) {
            paths[i][j] = matrix[i][j - 1]
        }
    }
    for (i in matrix.size - 2 downTo 0) {

        for (j in 0 until matrix.size) {
           // paths[j][i] = min(min(matrix[j - 1][i] + matrix[j - 1][i - 1], matrix[j + 1][i] + matrix[j + 1][i - 1]), matrix[j][i - 1])
        }
    }
    println(paths)
    println(paths.first().min())
}

//The minimal path sum in the 5 by 5 matrix below, by starting in any cell in the left column and finishing in any cell in the right column, and only moving up, down, and right
//994