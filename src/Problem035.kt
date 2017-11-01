//How many circular primes are there below one million?

fun main(args: Array<String>) {
    var current = 2
    val primes = HashSet<Int>()
    while (current < 1000000) {
        val n = Math.sqrt(current.toDouble()).toInt()
        if ((2..n).none { current % it == 0 }) primes.add(current)
        current++
    }
    val circularPrimes = primes.filter {
        var circular = true
        if (it > 10) {
            val s = it.toString()
            var n = it
            for (i in 0 until s.length) {
                val rem = n % 10
                n = n / 10 + rem * Math.pow(10.0, (s.length - 1).toDouble()).toInt()
                if (!primes.contains(n)) {
                    circular = false
                    break
                }
            }
        }
        circular
    }
    println(circularPrimes.size)
}