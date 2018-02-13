fun main(args: Array<String>) {
    val n = 7071
    val sieve = BooleanArray(size = n) { true }
    sieve[0] = false
    sieve[1] = false
    for (i in 2 until n) {
        if (sieve[i]) {
            for (j in 2 * i until n step i) {
                sieve[j] = false
            }
        }
    }
    val primes = sieve.mapIndexed { index, b -> if (b) index else -1 }.filter { it > 0 }
    val numbers = mutableSetOf<Int>()
    val endNumber = 50_000_000
    for (i in primes) {
        val x = i * i
        for (j in primes.takeWhile { it <= 369 }) {
            val y = j * j * j
            for (k in primes.takeWhile { it <= 85 }) {
                val z = k * k * k * k
                val current = x + y + z
                if (current < endNumber) {
                    numbers.add(current)
                }
            }
        }
    }
    println(numbers.size)
}