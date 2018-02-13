import java.math.BigInteger

val memo = mutableMapOf<Int, BigInteger>()

fun main(args: Array<String>) {
    val numbers = (1..99).toList()
    for (i in 2 until 100) {
        memo[i] = countOptions(i, (1..i).toList())
        println(i)
    }
    println(memo)
    println(countOptions(100, numbers))
}


private fun countOptions(n: Int, numbers: List<Int>): BigInteger {
    val out = memo[n]
    if (out != null) return out
    if (n == 0) return BigInteger.ONE
    if (n < 0 || numbers.isEmpty()) return BigInteger.ZERO
    return countOptions(n - numbers.first(), numbers) +
            countOptions(n, numbers.drop(1))
}
