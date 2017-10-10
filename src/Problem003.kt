import java.util.Collections.max

//The prime factors of 13195 are 5, 7, 13 and 29.
//
//What is the largest prime factor of the number 600851475143 ?

fun main(args: Array<String>) {
    var number = 600851475143
    val divs = ArrayList<Long>()
    var i = 2
    while (i <= number) {
        if (number % i == 0L) {
            number /= i
            divs.add(i.toLong())
            i--
        }
        i++
    }
    println(max(divs))
}


//4613732
