fun main(args: Array<String>) {
    val found89 = mutableMapOf<Int, Boolean>()
    println((1 until 10_000_000).filter { check89(it, found89) }.count())
}

private fun check89(n: Int, found89: MutableMap<Int, Boolean>): Boolean {
    var curr = n
    val chain = mutableListOf<Int>()
    while (curr != 1 && curr != 89) {
        if (found89.containsKey(curr)) {
            val value = found89[curr] == true // <-- ???
            found89.putAll(chain.zip((1..chain.size).map { value }.toList()))
            return value
        }
        chain.add(curr)
        curr = foldN(curr)
    }
    val value = curr == 89
    found89.putAll(chain.zip((1..chain.size).map { value }.toList()))
    return value
}

private fun foldN(n: Int): Int {
    var sum = 0
    var curr = n
    while (curr > 0) {
        val d = curr % 10
        sum += d * d
        curr /= 10
    }
    return sum
}