fun main(args: Array<String>) {
    val pyramids = getPyramidsOutcomes()
    val dice = getDiceOutcomes()
    val beats = dice.map { d -> pyramids.count { p -> d < p } }
    println(beats.map { (1.0 / it) * (1 / Math.pow(6.0, 6.0)) }.sum())
}

private fun getPyramidsOutcomes(): MutableList<Int> {
    val outcomes = mutableListOf<Int>()
    for (i in 1..4) {
        for (j in 1..4) {
            for (k in 1..4) {
                for (n in 1..4) {
                    for (m in 1..4) {
                        for (o in 1..4) {
                            for (p in 1..4) {
                                for (q in 1..4) {
                                    for (r in 1..4) {
                                        outcomes.add(i + j + k + n + m + o + p + q + r)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    return outcomes
}

private fun getDiceOutcomes(): MutableList<Int> {
    val outcomes = mutableListOf<Int>()
    for (i in 1..6) {
        for (j in 1..6) {
            for (k in 1..6) {
                for (n in 1..6) {
                    for (m in 1..6) {
                        for (o in 1..6) {
                            outcomes.add(i + j + k + n + m + o)
                        }
                    }
                }
            }
        }
    }
    return outcomes
}