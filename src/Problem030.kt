fun main(args: Array<String>) {
    var sum = 0
    for (i in 2..999999) {
        var current = i
        val n = mutableListOf<Int>()
        while (current > 0) {
            n.add(current % 10)
            current /= 10
        }
        if (i == n.sumBy { Math.pow(it.toDouble(), 5.0).toInt() }) sum += i
    }
    println(sum)
}