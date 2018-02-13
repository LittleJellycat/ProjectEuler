fun main(args: Array<String>) {
    val numbers = getPermutations(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)).filter { isSpecial(it) }.map {
        it.joinToString("")
    }
    println(numbers.map { it.toLong() }.sum())
}

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

private fun isSpecial(n: List<Int>): Boolean {
    return (n[0] != 0 && n[9] % 2 != 0
            && n[3] % 2 == 0
            && (n[5] == 5)
            && (n[2] * 100 + n[3] * 10 + n[4]) % 3 == 0
            && (n[4] * 100 + n[5] * 10 + n[6]) % 7 == 0
            && (n[5] * 100 + n[6] * 10 + n[7]) % 11 == 0
            && (n[6] * 100 + n[7] * 10 + n[8]) % 13 == 0
            && (n[7] * 100 + n[8] * 10 + n[9]) % 17 == 0)
}
