//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//What is the 10 001st prime number?

fun main(args: Array<String>) {
    var current = 1
    var counter = 0
    while (counter < 10001) {
        current++
        val n = current / 2
        if ((2..n).none { current % it == 0 }) counter++
    }
    println(current)
}