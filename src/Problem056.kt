import java.math.BigInteger

fun main(args: Array<String>) {
    var max = 0
    for (a in 2..99) {
        for (b in 2..99) {
            var n = BigInteger.valueOf(a.toLong()).pow(b)
            var sum = 0
            while (n > BigInteger.ZERO) {
                sum += n.mod(BigInteger.TEN).toInt()
                n = n.div(BigInteger.TEN)
            }
            if (max < sum) max = sum
        }
    }
    println(max)
}