class RomanNumerals {

    fun convert(number: String): Int {

        val romeChars = number.toList().reversed()
        val dezNumList = romeChars.map { convertChar(it) }
        var sumUp = 0
        var counter = dezNumList.size

        for (i in dezNumList.indices step 2) {

            if (counter == 1) {
                sumUp += dezNumList[dezNumList.lastIndex]
                break

            }else if (i != dezNumList.size - 1) {
                val sum = if (dezNumList[i] < dezNumList[i + 1]) {
                        dezNumList[i] + dezNumList[i + 1]

                    } else if (dezNumList[i] == dezNumList[i + 1]) {
                        dezNumList[i] + dezNumList[i + 1]

                    } else {
                        dezNumList[i] - dezNumList[i + 1]


                }
                counter -= 2
                sumUp += sum
            }
        }
        return sumUp
    }
}


fun convertChar(x: Char): Int {
    return when (x.lowercaseChar()) {
        'i' -> 1
        'v' -> 5
        'x' -> 10
        'l' -> 50
        'c' -> 100
        'd' -> 500
        'm' -> 1000
        else -> error("not a roman number!")
    }


}
