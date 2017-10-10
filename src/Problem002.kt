//By considering the terms in the Fibonacci sequence whose values do not exceed four million,
//find the sum of the even-valued terms.

fun main(args: Array<String>) {
    var prev = 0
    var cur = 1
    var sum = 0
    while (cur <= 4_000_000 ){
        val temp = cur
        cur += prev
        prev = temp
        if (cur % 2 == 0) sum += cur
    }
    println(sum)
}