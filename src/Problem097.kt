import java.math.BigInteger

//28433×2^7830457+1.

fun main(args: Array<String>) {
    println(BigInteger.valueOf(2).pow(7830457).multiply(BigInteger.valueOf(28433)).plus(BigInteger.ONE)
            .remainder(BigInteger.valueOf(10_000_000_000)))
}