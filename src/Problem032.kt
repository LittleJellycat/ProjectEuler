fun main(args: Array<String>) {
    val products = mutableSetOf<Int>()
    val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    getPermutations(numbers).forEach {
        for (j in 1 until it.size - 2) {
            for (k in j + 1 until it.size - 1) {
                val a = it.subList(0, j).joinToString("").toInt()
                val b = it.subList(j, k).joinToString("").toInt()
                val c = it.subList(k, it.size).joinToString("").toInt()
                if (a * b == c) {
                    products.add(c)
                }
            }
        }
    }
    println(products.sum())
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