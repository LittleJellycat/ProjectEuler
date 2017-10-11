import java.math.BigInteger.*

fun main(args: Array<String>) {
    var sum = ZERO
    for (i in 1..1000L) {
        sum = sum.plus(valueOf(i).modPow(valueOf(i), valueOf(10000000000)))
    }
    print(sum.mod(valueOf(10000000000)))
}