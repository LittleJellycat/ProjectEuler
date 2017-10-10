//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

fun main(args: Array<String>) {
    val sum = (1..100).sumBy { it * it }
    val sumSq = ((1..100).sumBy { it } * (1..100).sumBy { it })
    println(sumSq - sum)
}