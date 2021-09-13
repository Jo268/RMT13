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
    var indexWeek = 1
    for (mondays in monDayOfWeek){
        createFile(indexWeek, mondays)  //ruft die createFile funktion auf
        indexWeek += 1
    }
}






