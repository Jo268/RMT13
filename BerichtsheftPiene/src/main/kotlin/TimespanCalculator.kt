import java.time.DayOfWeek
import java.time.LocalDate
import java.util.stream.Collectors

fun timespanCalculator(until: LocalDate): MutableList<LocalDate> {
    //calculate working days
    val startAusbildung = LocalDate.of(2021,8,2)
    val monDayOfWeek: MutableList<LocalDate> = startAusbildung.datesUntil(until)
        .filter { it.dayOfWeek == DayOfWeek.MONDAY }
        .collect(Collectors.toList())
    return monDayOfWeek
}