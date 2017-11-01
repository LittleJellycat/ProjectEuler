import java.math.BigInteger

//Find the sum of the digits in the number 100!

fun main(args: Array<String>) {
    var n = BigInteger.valueOf(100L)
    for (i in 99 downTo 2L) {
        n = n.multiply(BigInteger.valueOf(i))
    }
    var sum = 0
    while (n != BigInteger.ZERO) {
        sum += n.rem(BigInteger.TEN).toInt()
        n = n.div(BigInteger.TEN)
    }
    println(sum)
}