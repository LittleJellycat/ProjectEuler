//It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
//Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

fun main(args: Array<String>) {
    var currentDegree = 10
    var n = currentDegree
    while (!checkDigits(n)) {
        if (n >= currentDegree * 2) {
            currentDegree *= 10
            n = currentDegree
        }
        n++
    }
    println(n)
}

private fun checkDigits(n: Int): Boolean {
    val s = n.toString().toSortedSet()
    val s2 = (n * 2).toString().toSortedSet()
    val s3 = (n * 3).toString().toSortedSet()
    val s4 = (n * 4).toString().toSortedSet()
    val s5 = (n * 5).toString().toSortedSet()
    val s6 = (n * 6).toString().toSortedSet()
    return s == s2 && s2 == s3 && s3 == s4 && s4 == s5 && s5 == s6
}