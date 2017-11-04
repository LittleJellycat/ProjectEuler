fun main(args: Array<String>) {
    val numbersToWords = HashMap<Int, String>()
    fillNumbersMap(numbersToWords)
    var letters = 0
    (1..1000).forEach {
        if (it < 100 && numbersToWords.containsKey(it)) {
            letters += numbersToWords[it]!!.length
        } else if (it == 1000) {
            letters += numbersToWords[1]!!.length + numbersToWords[1000]!!.length
        } else {
            var n = it
            if (n / 100 > 0) {
                val hundreds = n / 100
                letters += numbersToWords[hundreds]!!.length + numbersToWords[100]!!.length
                n %= 100
                if (n != 0) letters += "and".length
            }
            if (n != 0) {
                letters += if (n < 10) numbersToWords[n]!!.length else getTwoNumberLength(n, numbersToWords)
            }
        }
    }
    println(letters)
}

private fun fillNumbersMap(dict: HashMap<Int, String>) {
    dict.put(1, "one")
    dict.put(2, "two")
    dict.put(3, "three")
    dict.put(4, "four")
    dict.put(5, "five")
    dict.put(6, "six")
    dict.put(7, "seven")
    dict.put(8, "eight")
    dict.put(9, "nine")
    dict.put(10, "ten")
    dict.put(11, "eleven")
    dict.put(12, "twelve")
    dict.put(13, "thirteen")
    dict.put(14, "fourteen")
    dict.put(15, "fifteen")
    dict.put(16, "sixteen")
    dict.put(17, "seventeen")
    dict.put(18, "eighteen")
    dict.put(19, "nineteen")
    dict.put(20, "twenty")
    dict.put(30, "thirty")
    dict.put(40, "forty")
    dict.put(50, "fifty")
    dict.put(60, "sixty")
    dict.put(70, "seventy")
    dict.put(80, "eighty")
    dict.put(90, "ninety")
    dict.put(100, "hundred")
    dict.put(1000, "thousand")
}

private fun getTwoNumberLength(n: Int, dict: HashMap<Int, String>): Int {
    if (n < 20) return dict[n]!!.length
    return dict[n / 10 * 10]!!.length + dict.getOrDefault(n % 10, "").length
}