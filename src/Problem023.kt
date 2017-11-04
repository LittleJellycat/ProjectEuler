//A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
//For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
//A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
//As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
//the smallest number that can be written as the sum of two abundant numbers is 24.
//By mathematical analysis, it can be shown that all integers greater than 28123
//can be written as the sum of two abundant numbers. However, this upper limit
//cannot be reduced any further by analysis even though it is known that the greatest number
//that cannot be expressed as the sum of two abundant numbers is less than this limit.
//Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

fun main(args: Array<String>) {
    var sum = 0
    val abundantNumbers = arrayListOf<Int>()
    (1..28123).forEach {
        if (isAbundant(it)) abundantNumbers.add(it)
    }
    val sieve = BooleanArray(size = 28124, init = { _ -> true })
    for (i in 0 until abundantNumbers.size) {
        for (j in 0 until abundantNumbers.size) {
            val n = abundantNumbers[i]
            val m = abundantNumbers[j]
            if (n + m < sieve.size) sieve[n + m] = false
        }
    }
    var abundantSum = 0
    (0 until sieve.size).forEach { if (sieve[it]) abundantSum += it }
    println(abundantSum)
}

fun isAbundant(n: Int): Boolean {
    var divSum = 0
    (1 until n).forEach {
        if (n % it == 0) divSum += it
        if (divSum > n) return true
    }
    return divSum > n
}
