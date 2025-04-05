
fun main(args: Array<String>) {
    val iTest=ITest()
    println("Enter Ipv4")
    val userInput = readLine().toString()!!
    val result = iTest.ipv4Checker(userInput)

    if (result) {
        println("Ipv4 Success : $userInput")
    } else {
        println("Ipv4 Fail : $userInput")
    }
}


