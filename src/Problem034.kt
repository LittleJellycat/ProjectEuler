fun main(args: Array<String>) {
    val factorials = intArrayOf(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880)
    println((10..1000000)
            .filter { i ->
                i.toString().toCharArray()
                        .map { it - '0' }
                        .sumBy { factorials[it] } == i
            }
            .sum())
}
