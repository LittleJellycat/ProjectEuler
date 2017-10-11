fun main(args: Array<String>) {
    val numbers = arrayListOf<Int>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val list = getPermutations(numbers)
    val n = list.map { it.joinToString("") }
    println(n.sorted()[999999])
}

fun getPermutations(numbers: List<Int>): List<List<Int>> {
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
