fun main(args: Array<String>) {
    val count = (1 until 1_000_000_000).count { it % 10 != 0 && isReversible(it + reverse(it)) }
    println(count)
}

private fun isReversible(number: Int): Boolean {
    var n = number
    while (n > 0) {
        if (n % 2 == 0) return false
        n /= 10
    }
    return true
}

private fun reverse(number: Int): Int {
    var n = number
    var reversed = 0
    while (n > 0) {
        reversed = 10 * reversed + n % 10;
        n /= 10;
    }
    return reversed
}