import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.BufferedReader
import java.io.File
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.stream.Collectors


fun main(args: Array<String>) {
    //calculate working days
    val startAusbildung = LocalDate.of(2021,8,2)
    val letzterFreitag = LocalDate.now().with(DayOfWeek.FRIDAY)
    val monDayOfWeek = startAusbildung.datesUntil(letzterFreitag)
        .filter { it.dayOfWeek == DayOfWeek.MONDAY }
        .collect(Collectors.toList())
    println(monDayOfWeek)
    var indexWeek = 1
    for (mondays in monDayOfWeek){

        createFile(indexWeek, mondays)
        indexWeek += 1
    }
}

    //Get Mite data
fun run(client: OkHttpClient, mondays: LocalDate): List<String> {
    var   fridays = mondays.plusDays(4)

    // Read the api-key from file
    val bufferedReader: BufferedReader = File("/Users/admin/Desktop/Programming/joluca/BerichtsheftPiene/src/main/kotlin/API.txt").bufferedReader()
    val inputString = bufferedReader.use { it.readText() }

    val request = Request.Builder()
        .url("https://smartsquare.mite.yo.lk/time_entries.json?api_key=$inputString&from=$mondays&to=$fridays")
        .build()

    val responseBody = client.newCall(request).execute().body
    val gson = Gson()
    val wrapList : List<Wrapper> = gson.fromJson(responseBody!!.string(), object : TypeToken<List<Wrapper>>() {}.type)
    return wrapList.map { it.time_entry.note }
}

    //create a new file
fun createFile(indexWeek: Int, mondays: LocalDate) {
    val client = OkHttpClient()
    var meinBericht = run(client, mondays).joinToString(separator = System.lineSeparator())
        //ausgabe testen
        println(meinBericht)

    val fileName = "Berichtsheft_Woche_$indexWeek.txt"
    var file = File(fileName)

    file.writeText("$meinBericht")

    val isNewFileCreated: Boolean = file.createNewFile()

    if (isNewFileCreated) {
        println("$fileName is created successfully.")
    } else {
        println("$fileName already exists.")
    }

    // try creating a file that already exists
    val isFileCreated: Boolean = file.createNewFile()

    if (isFileCreated) {
        println("$fileName is created successfully.")
    } else {
        println("$fileName already exists.")
    }
}





