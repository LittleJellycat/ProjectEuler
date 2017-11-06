//n^2 + an + b

fun main(args: Array<String>) {
    var max = 0
    var pair = 0 to 0
    for (a in -1000..1000) {
        for (b in -1000..1000) {
            var count = 0
            while (isPrime(Math.abs(count * count + a * count + b))) {
                count++
            }
            if (count > max) {
                max = count
                pair = a to b
            }
        }
    }
    println(pair.first * pair.second)
    println(pair)
}

private fun isPrime(n: Int): Boolean = (2..n / 2).none { n % it == 0 }
