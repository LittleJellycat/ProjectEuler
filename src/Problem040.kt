//d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

fun main(args: Array<String>) {
    val sb = StringBuilder()
    var n = 1
    while (sb.length < 1_000_000) {
        sb.append(n.toString())
        n++
    }
    println(intArrayOf(0, 9, 99, 999, 9999, 99999, 999999).map { sb[it].toString().toInt() }
            .foldRight(1) { x, y -> x * y })
}