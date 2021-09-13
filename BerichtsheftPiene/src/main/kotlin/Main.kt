import okhttp3.OkHttpClient

fun main(args: Array<String>) {
    if(args.isEmpty()){
        throw error("APIKEY erwartet.")
    }
    val apiKey = args[0]
    val httpClient = OkHttpClient()
    val miteClient = MiteClient(httpClient, apiKey)
    val monDayOfWeek = timespanCalculator()
    for (mondays in monDayOfWeek) {
        val fridays = mondays.plusDays(4)
        val entries = miteClient.fetchEntries(mondays, fridays).reversed().joinToString(separator = System.lineSeparator())
        createFile(mondays,entries)
    }
}



