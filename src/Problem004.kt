//A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//
//Find the largest palindrome made from the product of two 3-digit numbers.
fun main(args: Array<String>) {
    var p = 0
    for (i in 900..999) {
        for (j in 900..999) {
            if (isPalindrome(i * j)) {
                if (i * j > p) p = i * j
            }
        }
    }
    println(p)
}

private fun isPalindrome(n: Int): Boolean {
    return ((n % 10 == n / 100000) && ((n % 100) / 10 == (n % 100000) / 10000) && ((n % 1000) / 100 == (n % 10000) / 1000))
}
//123321