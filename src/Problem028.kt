//What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

fun main(args: Array<String>) {
    val n = 1001 * 1001
    val sequence = BooleanArray(n + 1)
    sequence[1] = true
    var currentDegree = 3
    var diff = 2
    while (currentDegree * currentDegree <= n) {
        sequence[currentDegree * currentDegree] = true
        sequence[currentDegree * currentDegree - diff] = true
        sequence[currentDegree * currentDegree - 2 * diff] = true
        sequence[currentDegree * currentDegree - 3 * diff] = true
        currentDegree += 2
        diff += 2
    }
    var sum = 0
    sequence.forEachIndexed { i, b -> if (b) sum += i }
    println(sum)
}