import java.time.DayOfWeek
import java.time.LocalDate
import java.util.stream.Collectors

fun timespanCalculator(): MutableList<LocalDate> {
    //calculate working days
    val startAusbildung = LocalDate.of(2021,8,2)
    val letzterFreitag = LocalDate.now().with(DayOfWeek.FRIDAY)
    val monDayOfWeek: MutableList<LocalDate> = startAusbildung.datesUntil(letzterFreitag)
        .filter { it.dayOfWeek == DayOfWeek.MONDAY }
        .collect(Collectors.toList())
    return monDayOfWeek
}