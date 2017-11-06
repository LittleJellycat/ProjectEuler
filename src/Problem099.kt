fun main(args: Array<String>) {
    val input = T::class.java.getResourceAsStream("base_exp.txt")
            .reader().readLines().map { it.split(',') }
    val exp = mutableListOf<Pair<Double, Int>>()
    input.forEach { exp.add(it[0].toDouble() to it[1].toInt()) }
    println(exp.mapIndexed { index, pair -> Math.log(pair.first) * pair.second to index }.maxBy { it.first }!!.second + 1)
}

private object T