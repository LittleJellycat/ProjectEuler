val primesMemo = HashMap<Int, Boolean>()

fun main(args: Array<String>) {
    primesMemo[1] = false
    primesMemo[2] = true
    primesMemo[3] = true

//    val pandigitals = (getPermutations(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
//    pandigitals.forEachIndexed { index, it ->
//        doMemoChains(it, listOf<Int>(), primeChains, 0)
//        if (index % 100 == 0) {
//            println(index)
//        }
//    }
    println(doMemoChains(listOf(2, 5, 4, 7, 8, 9, 6, 3, 1), 0))
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

private fun isPrime(n: Int): Boolean {
    return primesMemo[n] ?: (2..n / 2).none { n % it == 0 }
}

private fun doMemoChains(pandigital: List<Int>, prev: Int): Int {
    if (pandigital.isEmpty()) {
        return 1
    }
    var counter = 0
    for (i in 1..pandigital.size) {
        val n = pandigital.take(i).joinToString("").toInt()
        if (prev > n || !isPrime(n)) {
            return 0
        } else {
            counter += doMemoChains(pandigital.drop(i), n)
        }
    }
    return counter
}
