import java.io.File
import java.nio.file.Files
import java.nio.file.Paths


fun main(args: Array<String>) {
    val names = Files.readAllLines(Paths.get("C:\\Users\\kotat\\Desktop\\p022_names.txt"))[0].split(",") as ArrayList<String>
    names.sort()
    println(names.zip((1..names.size)).map { getValue(it.first) * it.second }.sum())
}

fun getValue(s: String): Int {
    var sum = 0
    s.forEach { if (it != '\"') sum += it - 'A' + 1 }
    return sum
}