import java.lang.Math.*

fun main(args: Array<String>) {
    var current = 1;
    var counter = 0;
    var prime = true
    while (counter < 10001) {
        current++
        val n = current / 2
        prime = (2..n).none { current % it == 0 }
        if (prime) counter++
    }
    println(current)
}