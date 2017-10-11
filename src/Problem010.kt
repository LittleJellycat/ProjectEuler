import java.lang.Math.*

//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//Find the sum of all the primes below two million.

fun main(args: Array<String>) {
    var sum = 0L
    for (current in 2 until 2_000_000) {
        val n = (sqrt(current.toDouble())).toInt()
        if ((2..n).none { current % it == 0 }) sum += current
    }
    println(sum)
}
