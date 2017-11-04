fun main(args: Array<String>) {
    val words = Test::class.java.getResourceAsStream("words.txt").reader().readText().split(',')
    val firstNumbers = (0..30).map { (it * (it + 1)) / 2 }.toSet()
    println(words.count { firstNumbers.contains(getWordSum(it)) })
}

fun getWordSum(word: String): Int = word.toCharArray().sumBy { it -> if (it != '"') it - 'A' + 1 else 0 }

object Test