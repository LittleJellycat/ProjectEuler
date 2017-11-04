import java.math.BigInteger

fun main(args: Array<String>) {
    var maxLength = 0
    var p = 1
    for (i in 2 until 1000) {
        var q = i
        while (q % 2 == 0) q /= 2
        while (q % 5 == 0) q /= 5
        if (q != 1) {
            var length = 1
            var degree = BigInteger.TEN
            while (degree.mod(BigInteger.valueOf(q.toLong())) != BigInteger.ONE) {
                length++
                degree = degree.multiply(BigInteger.TEN)
            }
            if (maxLength < length) {
                maxLength = length
                p = i
            }
        }
    }
    println(p)
}