package utils

fun getValidInput(message: String, pattern: Regex): String {
    var input: String = ""
    while(input.isEmpty() || !pattern.matches(input)) {
        println(message)
        input = readLine()?:""
    }
    return input
}