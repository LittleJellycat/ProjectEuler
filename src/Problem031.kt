fun main(args: Array<String>) {
    val coins = listOf(1, 2, 5, 10, 20, 50, 100, 200)
    println(countChange(200, coins))
}

private fun countChange(amount: Int, coins: List<Int>): Int {
    if (amount == 0) return 1
    if (amount < 0 || coins.isEmpty()) return 0
    return countChange(amount - coins.first(), coins) +
            countChange(amount, coins.drop(1))
}