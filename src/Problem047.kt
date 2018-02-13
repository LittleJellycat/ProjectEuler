fun main(args: Array<String>) {
    println(generateSequence(3) { x -> x + 1 }.map { it to findPrimeFactors(it) }.windowed(4)
            .first { it.all { it.second.size == 4 } }.first().first)
}

private fun findPrimeFactors(number: Int): Set<Int> {
    var n = number
    val factors = mutableSetOf<Int>()
    for (i in 2..number / 2) {
        while (n % i == 0) {
            factors.add(i)
            n /= i
        }
        if (n == 1) break
    }
    return factors
}