//Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
fun main(args: Array<String>) {
    var sum = 0
    for (n in 1 until 1_000_000) {
        val n10 = n.toString()
        val nb = Integer.toBinaryString(n)
        if (isPalindrome(n10) && isPalindrome(nb)) sum += n
    }
    println(sum)
}

fun isPalindrome(s: String): Boolean = s == s.reversed()