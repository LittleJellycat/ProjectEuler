//If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
//{20,48,52}, {24,45,51}, {30,40,50}
//For which value of p ≤ 1000, is the number of solutions maximised?

fun main(args: Array<String>) {
    val triangles = HashSet<Triple<Int, Int, Int>>()
    for (i in 1..1000) {
        for (j in 1..1000) {
            for (k in 1..1000) {
                if (i + k + j <= 1000) {
                    val temp = intArrayOf(i, j, k)
                    temp.sort()
                    if (temp[0] * temp[0] + temp[1] * temp[1] == temp[2] * temp[2]) {
                        triangles.add(Triple(temp[0], temp[1], temp[2]))
                    }
                }
            }
        }
    }
    println(triangles.groupBy { it.first + it.second + it.third }.maxBy { it.value.size })

}