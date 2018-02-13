import java.math.BigInteger

fun main(args: Array<String>) {
    val factorials = fillFactorial(100, mutableMapOf())
    var count = 0
    for (i in 1..100) {
        for (j in 1..i) {
            if (factorials[i]!! / (factorials[j]!! * factorials[i - j]!!) > BigInteger.valueOf(1000000L)) {
                count++
            }
        }
    }
    println(count)
}

private fun fillFactorial(n: Int, factorials: MutableMap<Int, BigInteger>): MutableMap<Int, BigInteger> {
    factorials.put(0, BigInteger.ONE)
    var current = BigInteger.ONE
    for (i in 1L..n) {
        current *= BigInteger.valueOf(i)
        factorials.put(i.toInt(), current)
    }
    return factorials
}