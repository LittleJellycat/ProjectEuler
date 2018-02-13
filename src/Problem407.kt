//If we calculate a2 mod 6 for 0 ≤ a ≤ 5 we get: 0,1,4,3,4,1.
//
//The largest value of a such that a2 ≡ a mod 6 is 4.
//Let's call M(n) the largest value of a < n such that a2 ≡ a (mod n).
//So M(6) = 4.
//
//Find ∑M(n) for 1 ≤ n ≤ 107.

fun main(args: Array<String>) {
    println((1..10000000).map { findLargesSpecialNumber(it).toLong() }.sum())
}

private fun findLargesSpecialNumber(r: Int): Int {

    var maxRem = 0
    for (i in 0 until r) {
        val ir = i % r
        val k = (ir * ir) % r
        if (i == k) {
            if (maxRem < k) maxRem = k
        }
        if (maxRem == (r - 1)) return maxRem
    }
    return maxRem
}