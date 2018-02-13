fun main(args: Array<String>) {
    val numbers = (0 until 10000).map(::findDivisorsSum)
    var sum = 0
    numbers.forEachIndexed { index, i ->
        if (i < 10000 && i != index) {
            if (index == numbers[i]) {
                sum += index
            }
        }
    }
    println(sum)
}

private fun findDivisorsSum(n: Int): Int = (1..n / 2).filter { n % it == 0 }.sum()