import okhttp3.OkHttpClient
import java.io.File
import java.time.LocalDate
import java.time.temporal.WeekFields
import java.util.*

//create a new file
fun createFile(mondays: LocalDate, report: String) {
    var week = mondays.get(        WeekFields.of(Locale.GERMANY).weekOfMonth())
    var monat = mondays.monthValue
    if (week == 5){
        week = 1
    }
    val jahr = mondays.year
    val fileName = "Berichtsheft_Woche_$week.txt"
    val directory = File("meineBerichtshefte/Jahr${jahr}Monat$monat")
    val file = File(directory, fileName)
    directory.mkdirs()
    file.writeText(report)

    // try creating a file that already exists
    val isFileCreated: Boolean = file.createNewFile()
    if (isFileCreated) {
        println("$fileName is created successfully.")
    } else {
        println("$fileName already exists.")
    }
}
