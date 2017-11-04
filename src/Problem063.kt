import java.math.BigInteger

fun main(args: Array<String>) {
    var number = 0
    for (d in 1..21) {
        for (n in 1..9) {
            val current = BigInteger.valueOf(n.toLong()).pow(d)
            if (current.toString().length == d) {
                number++
            }
        }
    }
    println(number)
}