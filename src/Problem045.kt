//Find the next triangle number that is also pentagonal and hexagonal.
//40755
//Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
//Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
//Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...


fun main(args: Array<String>) {
    var pcurrent = 40755L
    var hcurrent = 40755L
    var pn = 165L
    var hn = 143L
    do {
        if (pcurrent < hcurrent) {
            pn++
            pcurrent = pn * (3 * pn - 1) / 2
        } else {
            hn++
            hcurrent = hn * (2 * hn - 1)
        }
    } while ((pcurrent != hcurrent) && pn < 32000)
    println(pcurrent)
}