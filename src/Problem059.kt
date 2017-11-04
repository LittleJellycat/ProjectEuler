fun main(args: Array<String>) {
    val words = Text::class.java.getResourceAsStream("cipher.txt").reader().readText().split(',').map { it.toInt() }
//    val unique = HashSet<Int>()
//    words.map { it.toInt() }.toCollection(unique)
    for (i in 9..122) {
        for (j in 97..122) {
            for (k in 97..122) {
                val pass = ArrayList<Int>()
                while (pass.size < words.size) {
                    when {
                        pass.size % 3 == 0 -> pass.add(i)
                        pass.size % 3 == 1 -> pass.add(j)
                        else -> pass.add(k)
                    }
                }
                val out = words.zip(pass) { x, y -> x.xor(y) }.map { it.toChar() }
//                if (out.none { it < 65 || it > 122 }) println(out.map { it.toChar() })
                if (out.none { !it.isLetter() || !it.isWhitespace()}) println(out)
            }
        }
    }
}

private object Text