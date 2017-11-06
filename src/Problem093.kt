fun main(args: Array<String>) {
    val operations = combine(listOf(Double::times, Double::div, Double::plus, Double::minus), 3)
    val digits = permute((1..9).map { it.toDouble() }, 4)
    val results = ArrayList<Pair<List<Double>, Double>>()
    digits.forEach { (k, n, m, p) ->
        operations.forEach { (first, second, third) ->
            results.add(listOf(k, n, m, p).sorted() to third(second(first(k, n), m), p))
            results.add(listOf(k, n, m, p).sorted() to (second(first(k, n), third(m, p))))
        }
    }
    val mapValues = results.groupBy({ it.first }, { it.second })
            .mapValues { (_, value) -> getScore(value) }
    val map = mapValues.maxBy { it.value }
    println(map)
}

private fun getScore(results: List<Double>): Int {
    var score = 0
    var current = 1
    val list = results.filter { it > 0 && isWhole(it) }.distinct().sorted()
    for (i in 0 until list.size - 1) {
        if (list[i + 1] - list[i] == 1.0) {
            current++
            if (current > score) score = current
        } else {
            current = 1
        }
    }
    return score
}

private fun permute(op: List<Double>, n: Int): List<List<Double>> {
    assert(op.isNotEmpty() && n > 0)
    return when (n) {
        1 -> op.map { listOf(it) }
        else -> op.map { listOf(it) }.flatMap { elem -> permute(op - elem, n - 1).map { elem + it } }
    }

}

private fun combine(op: List<f>, n: Int = op.size): List<List<f>> {
    assert(op.isNotEmpty() && n > 0)
    return when (n) {
        1 -> op.map { listOf(it) }
        else -> op.map { listOf(it) }.flatMap { elem -> combine(op, n - 1).map { elem + it } }
    }
}

typealias f = (Double, Double) -> Double

private fun isWhole(value: Double): Boolean {
    return value - value.toInt() == 0.0
}