//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.

fun findTripleProduct(limit: Int): Int {
    val k = Math.floor(Math.sqrt(limit.toDouble())).toInt()
    for (n in 2..k) {
        for (m in 1 until n) {
            val a = n * n - m * m
            val b = 2 * m * n
            val c = n * n + m * m
            if (a + b + c == limit) return a * b * c
        }
    }
    return -1
}

fun main(args: Array<String>) {
    println(findTripleProduct(1000))
}
