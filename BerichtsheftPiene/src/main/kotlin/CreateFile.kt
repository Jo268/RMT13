import java.io.File
import java.time.LocalDate
import java.time.temporal.WeekFields
import java.util.*

//create a new file
fun createFile(mondays: LocalDate, report: String) {
    var week = mondays.get(        WeekFields.of(Locale.GERMANY).weekOfMonth())
    var monat = mondays.monthValue
    var jahr = mondays.year
    if (week == 5){
        week = 1
        monat += 1
    }
    if (monat == 13){
        monat = 1
        jahr += 1
    }
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
