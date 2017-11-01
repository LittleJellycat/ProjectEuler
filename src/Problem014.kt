//Which starting number, under one million, produces the longest chain?

fun main(args: Array<String>) {
    var max = 0
    var number = 0L
    for (i in 2L until 1000000L) {
        var currentLength = 0
        var currentNumber = i
        while (currentNumber >= 1) {
            currentLength++
            if (currentNumber == 1L) {
                if (max < currentLength) {
                    max = currentLength
                    number = i
                }
                break
            } else if (currentNumber % 2 == 0L) {
                currentNumber /= 2
            } else {
                currentNumber = 3 * currentNumber + 1
            }
        }
    }
    println(number)
}