
class ITest {

    /*
    Rules -->
    1- Ipv4 divide to 4 segments
    2- each segment   0 : 255
    3- numbers  must not repeat in segments
    4- segment must not start with zero
    5- find 3 dots
     */


    fun testValidIPv4() {
        println(ipv4Checker("192.168.0.1"))
        println(ipv4Checker("255.255.255.255"))
        println(ipv4Checker("0.0.0.0"))
    }


    fun testInvalidIPv4WithLeadingZeros() {
        println(ipv4Checker("192.168.01.1")) // Invalid
        println(ipv4Checker("010.10.10.10")) // Invalid
        println(ipv4Checker("0.01.0.1")) // Invalid
        println(ipv4Checker("0.0.0.01")) // Invalid
    }


    fun testInvalidIPv4WithMoreThanFourSegments() {
        println(ipv4Checker("192.168.0.1.2")) // many
        println(ipv4Checker("1.2.3.4.5")) //  many
        // segment more than 4 can 5 or 6 or more --> invalid
    }


    fun testInvalidIPv4WithLessThanFourSegments() {
        println(ipv4Checker("192.168.0")) //  few
        println(ipv4Checker("1.2.3")) //  few segments

       // segment fewer than 4 can 3 or 2 or fewer --> invalid
    }


    fun testInvalidIPv4WithInvalidCharactersOrNegative() {
        println(ipv4Checker("192.168.0.abc")) // Invalid
        println(ipv4Checker("abc.0.0.0")) // Invalid
        println(ipv4Checker("0.abc.0.0")) // Invalid
        println(ipv4Checker("0.0.abc.0")) // Invalid
        println(ipv4Checker("123.45.67.-8")) // Negative
    }


    fun testInvalidIPv4WithOutOfRangeNumbers() {
        println(ipv4Checker("256.256.256.256")) // out of range           any other range
        println(ipv4Checker("999.0.0.0")) //out of range
        println(ipv4Checker("300.255.255.255")) // out of range
    }


    fun testInvalidIPv4WithSpacesOrSymbols() {
        println(ipv4Checker(" 192.168.0.1 ")) // spaces
        println(ipv4Checker("192.168.0.1 ")) // spaces
        println(ipv4Checker(" 192.168.0.1")) // spaces
        println(ipv4Checker("192 .168.0.1")) // spaces
        println(ipv4Checker("192.168 .0.1")) // spaces
        println(ipv4Checker("192.168.0 .1")) // spaces
        println(ipv4Checker("192. 168.0.1")) // spaces
        println(ipv4Checker("192.168. 0.1")) // spaces
        println(ipv4Checker("192.168.0. 1")) // spaces
        println(ipv4Checker("192.168.0.1!")) //symbols
        println(ipv4Checker("192.168.0!.1")) //symbols
        println(ipv4Checker("192.168!.0.1")) //symbols
        println(ipv4Checker("192!.168.0.1")) //symbols
    }






    // test function
    fun ipv4Checker(address: String): Boolean {
        val segments = address.split(".")

        if (segments.size != 4) return false
        for (segment in segments) {
            if (!segment.all { it.isDigit() }) return false
            val num = segment.toInt()
            if (num !in 0..255) return false
            if (segment != "0" && segment.startsWith("0")) return false
        }

        return true
    }
}
