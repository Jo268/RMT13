import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
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

    // TODO: Read the api_key from a file so that it is no longer part of the source code.
    // TODO: Aftewards add the file to the .gitignore so that the api_key is no longer part of the repository.
    val request = Request.Builder()
        .url("https://smartsquare.mite.yo.lk/time_entries.json?api_key=8d7fa1efdda9016b&from=$from&to=$to")
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





