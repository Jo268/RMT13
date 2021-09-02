import java.time.DayOfWeek
import java.time.LocalDate

fun calculateWeek(): Week {
    val start = LocalDate.now().with(DayOfWeek.MONDAY)

    return Week(start, start.plusDays(4))
}
