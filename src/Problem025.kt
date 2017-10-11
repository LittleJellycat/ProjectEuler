import java.math.BigInteger

fun main(args: Array<String>) {
    var n = 2
    var first = BigInteger.ONE
    var second = BigInteger.ONE
    val pow = BigInteger.TEN.pow(999)
    do {
        val current = first.plus(second)
        second = first
        first = current
        n++
    } while (pow > current)
    println(n)
}