fun main(args: Array<String>) {
    val input = ("5616185650518293 ;2 correct\n" +
            "3847439647293047 ;1 correct\n" +
            "5855462940810587 ;3 correct\n" +
            "9742855507068353 ;3 correct\n" +
            "4296849643607543 ;3 correct\n" +
            "3174248439465858 ;1 correct\n" +
            "4513559094146117 ;2 correct\n" +
            "7890971548908067 ;3 correct\n" +
            "8157356344118483 ;1 correct\n" +
            "2615250744386899 ;2 correct\n" +
            "8690095851526254 ;3 correct\n" +
            "6375711915077050 ;1 correct\n" +
            "6913859173121360 ;1 correct\n" +
            "6442889055042768 ;2 correct\n" +
            "2321386104303845 ;0 correct\n" +
            "2326509471271448 ;2 correct\n" +
            "5251583379644322 ;2 correct\n" +
            "1748270476758276 ;3 correct\n" +
            "4895722652190306 ;1 correct\n" +
            "3041631117224635 ;3 correct\n" +
            "1841236454324589 ;3 correct\n" +
            "2659862637316867 ;2 correct").split("\n").map { it.split(" ;", " ").dropLast(1) }
            .map { (number, answer) ->
                number.split("").drop(1).dropLast(1).map { it.toInt() } to answer.toInt()
            }.sortedBy { it.second }
    val numbers = mutableMapOf<Int, MutableSet<Int>>()
    for (i in 1..16) {
        numbers[i] = mutableSetOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    }
    val wrong = input.find { it.second == 0 }!!.first
    for (i in 0..15){
        numbers[i+1]!!.remove(wrong[i])
    }
    println(numbers)


}

