import java.math.BigInteger

//What is the sum of the digits of the number 2^1000?

fun main(args: Array<String>) {
    var number = BigInteger.valueOf(2).pow(1000)
    var sum = 0
    while (number != BigInteger.ZERO){
        sum += number.rem(BigInteger.TEN).toInt()
        number = number.div(BigInteger.TEN)
    }
    println(sum)
}