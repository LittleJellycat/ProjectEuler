fun main(args: Array<String>) {
    val n = 100
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
    val primes = sieve.mapIndexed { index, b -> if (b) index.toLong() else -1 }
            .filter { it > 0 }.toSet()
    val triples = HashSet<Triple<Long, Long, Long>>()
    val limit = primes.last()
   // println(limit)
    var current: Long
    val iter = primes.iterator()
    do {
        current = iter.next()
        println(current)
        var i = 2
        do {
            val b = (current + 1) * i
            val c = b * i
            if (primes.contains(b - 1) && primes.contains(c - 1)) {
                triples.add(Triple(current, b - 1, c - 1))
               // print(Triple(current, b - 1, c - 1))
            }
            i++
        } while (c <= limit)
    } while (current < limit)
    println(triples.sortedBy { it.first })
    println(triples.map { it.first + it.second + it.third }.sum())
    // println(primes.size)
}
//2822483945800