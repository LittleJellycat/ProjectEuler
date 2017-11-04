//How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
//NB: 1 Jan 1900 was a Monday.
fun main(args: Array<String>) {
    val months = listOf<Int>(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val leapMonths = listOf<Int>(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    var day = 365 % 7
    var sundays = 0
    (1901..2000).forEach {
        (if (isLeap(it)) leapMonths else months).forEach {
            day = (day + it) % 7
            if (day == 6) sundays++
        }
    }
    println(sundays)
}

private fun isLeap(year: Int): Boolean = year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)