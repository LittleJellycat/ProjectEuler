//What is the value of the first triangle number to have over five hundred divisors?

//TODO Simplify

fun main(args: Array<String>) {
    var currentTriangle = 0
    var currentNumber = 0
    var numberOfDivisors: Int
    var maxDivisors = 0
    do {
        currentTriangle += currentNumber
        currentNumber++
        numberOfDivisors = getNumberOfDivisors(currentTriangle)
        if (maxDivisors < numberOfDivisors){
            maxDivisors = numberOfDivisors
        }
    } while (numberOfDivisors <= 500)
    println(currentTriangle)
}

fun getNumberOfDivisors(n: Int): Int {
    return (1..n).count { n % it == 0 }
}
