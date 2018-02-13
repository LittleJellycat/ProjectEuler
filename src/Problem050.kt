fun main(args: Array<String>) {
    val n = 1000000
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
    var bestSequenceSize = 0
    var bestPrime = 0
    var currentQueueSum = 0
    for (i in 0 until primes.size) {
        for (j in i until primes.size) {
            currentQueueSum = primes.subList(i, j).sum()
            if (currentQueueSum > primes.last()) break
            if (primes.contains(currentQueueSum) && j - i > bestSequenceSize) {
                bestSequenceSize = j - i
                bestPrime = currentQueueSum
            }
        }
    }
    println(bestSequenceSize)
    println(bestPrime)

}


