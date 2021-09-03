import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.BufferedReader
import java.io.File
import java.time.LocalDate


fun main(args: Array<String>) {
    //calculate working days
    val weeks = listOf<Int>(1, 2, 3, 4)
    for (i in weeks){
        createFile(i, i)
    }
}

    //Get Mite data
fun run(client: OkHttpClient, i: Int): List<String> {
    // TODO: Use calculateWeek() to generate the reports dynamically
    var   to = LocalDate.of(2021, 8,6)
    when (i){
        2 -> to = to.plusDays(7)
        3 -> to = to.plusDays(14)
        4 -> to = to.plusDays(21)
    }
    val from = to.minusDays(4)

    println(to)
    println(from)

    // Read the api-key from file
    val bufferedReader: BufferedReader = File("/Users/admin/Desktop/Programming/joluca/BerichtsheftPiene/src/main/kotlin/API.txt").bufferedReader()
    val inputString = bufferedReader.use { it.readText() }

    val request = Request.Builder()
        .url("https://smartsquare.mite.yo.lk/time_entries.json?api_key=$inputString&from=$from&to=$to")
        .build()

    val responseBody = client.newCall(request).execute().body
    val gson = Gson()
    val wrapList : List<Wrapper> = gson.fromJson(responseBody!!.string(), object : TypeToken<List<Wrapper>>() {}.type)
    return wrapList.map { it.time_entry.note }
}

    //create a new file
fun createFile(week: Int, i: Int) {
    val client = OkHttpClient()
    var meinBericht = run(client, i).joinToString(separator = System.lineSeparator())
    println(meinBericht)
    val fileName = "Berichtsheft_0$week.08.21.txt"
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





