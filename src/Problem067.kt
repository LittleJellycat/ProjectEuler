import java.lang.Integer.max
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {

    val numbers = Files.readAllLines(Paths.get("C:\\Users\\MMUSER\\IdeaProjects\\projecteuler\\src\\triangle.txt")).map { it.split(" ")}
            .map { it.map { it.toInt() }.toMutableList() }.toMutableList()
    val tree = (0 until numbers.size).map { numbers[it] }.toMutableList()
    for (i in numbers.size - 1 downTo 1) {
        for (j in 0 until tree[i - 1].size) {
            tree[i - 1][j] += max(tree[i][j], tree[i][j+1])
        }
    }
    println(tree[0][0])
}
