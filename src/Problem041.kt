fun main(args: Array<String>) {
    val oneToSeven = getPermutations((1..7).toList())
    var max = oneToSeven.map { it.joinToString("").toInt() }.filter { isPrime(it) }.max()
    if (max == null) {
        val oneToFour = getPermutations((1..4).toList())
        max = oneToFour.map { it.joinToString("").toInt() }.filter { isPrime(it) }.max()
    }
    println(max ?: 1)
}

private fun isPrime(n: Int): Boolean = (2..n / 2).none { n % it == 0 }

/* 1
* 1+2 = 3 % 3 == 0
* 1+2+3 = 6 % 3 == 0
* 1+2+3+4 = 10
* 1+2+3+4+5 = 15 % 3 == 0
* 1+2+3+4+5+6 = 21 % 3 == 0
* 1+2+3+4+5+6+7 = 28
* 1+2+3+4+5+6+7+8 = 36 % 3 == 0
* 1+2+3+4+5+6+7+8+9 = 45 % 3 == 0*/


private fun getPermutations(numbers: List<Int>): List<List<Int>> {
    if (numbers.size == 1) return listOf(numbers)
    val out = mutableListOf<List<Int>>()
    val number = numbers[0]
    for (p in getPermutations(numbers.drop(1))) {
        for (i in 0..p.size) {
            val permutation = p.toMutableList()
            permutation.add(i, number)
            out.add(permutation)
        }
    }
    return out
}
