import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class TimespanCalculatorKtTest {
    private val expectedList: MutableList<LocalDate> =
        mutableListOf<LocalDate>(
            LocalDate.of(2021, 8, 2),
            LocalDate.of(2021, 8, 9),
            LocalDate.of(2021, 8, 16),
            LocalDate.of(2021, 8, 23),
            LocalDate.of(2021, 8, 30),
            LocalDate.of(2021, 9, 6),
            LocalDate.of(2021, 9, 13),
            LocalDate.of(2021, 9, 20),
            LocalDate.of(2021, 9, 27),
        )
    @Test
    fun listTesting() {
        assertEquals(expectedList, timespanCalculator(LocalDate.of(2021, 10, 1)))
    }
}