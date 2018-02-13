fun main(args: Array<String>) {
    val resilienceLimit = 15499.0 / 94744
    var currentResilience = 1.0
    var n = 2L
    val divisors = mutableMapOf<Long, List<Long>>()
    while (currentResilience > resilienceLimit && n < Long.MAX_VALUE - 2) {
        val divN = divisors.getOrPut(n) { getDivisors(n) }
        currentResilience = (1 until n).filter { d ->
            val divD = divisors.getOrPut(d) { getDivisors(d) }
            divN.intersect(divD).isEmpty()
        }.count().toDouble() / (n - 1)
//    println("$n  $currentResilience")
        n++
    }
    println(n - 1)
}

private fun getDivisors(n: Long): List<Long> = (2L..n / 2).filter { n % it == 0L } + n