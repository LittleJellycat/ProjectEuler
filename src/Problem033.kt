fun main(args: Array<String>) {
    val fractions = HashSet<Pair<Int, Int>>()
    (1..9).forEach { i ->
        (1..9)
                .filter { i < it }
                .map { checkFraction(i, it) }
                .filterNot { it.isEmpty() }
                .forEach { fractions.addAll(it) }
    }
    val (x, y) = fractions.unzip()
    println(x.fold(1) { n, m -> n * m })
    println(y.fold(1) { n, m -> n * m })
}

fun checkFraction(x: Int, y: Int): List<Pair<Int, Int>> {
    val result = ArrayList<Pair<Int, Int>>()
    for (i in 1..9) {
        if ((10 * i + x).toDouble() / (10 * i + y) == x.toDouble() / y) result.add((10 * i + x) to (10 * i + y))
        if ((10 * i + x).toDouble() / (10 * y + i) == x.toDouble() / y) result.add((10 * i + x) to (10 * y + i))
        if ((10 * x + i).toDouble() / (10 * i + y) == x.toDouble() / y) result.add((10 * x + i) to (10 * i + y))
        if ((10 * x + i).toDouble() / (10 * y + i) == x.toDouble() / y) result.add((10 * x + i) to (10 * y + i))
    }
    return result
}

//10x + y / 10x + z
//10x + y / x + 10z
//x + 10y / x + 10z
//x + 10y / 10x + z