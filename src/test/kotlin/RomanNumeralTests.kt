import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RomanNumeralTests {

    @ParameterizedTest
    @CsvSource(
        "I, 1",
        "II, 2",
        "III, 3",
        "IV, 4",
        "V, 5",
        "VI, 6",
        "VII, 7",
        "VIII, 8",
        "IX, 9",
        "X, 10",
        "XI, 11",
        "XII, 12",
        "XIII, 13",
        "XX, 20",
        "XL, 40",
        "L, 50",
        "XC, 90",
        "C, 100",
        "CD, 400",
        "D, 500",
        "CM, 900",
        "M, 1000",
        "DCCCXLVI, 846",
        "MCMXCIX, 1999",
        "MMVIII, 2008"
    )
    fun `return I for number 1`(expectedValue: String, number: Int){
        val converter = RomanNumerals()

        val inRoman = converter.convert(expectedValue)

        assertEquals(number, inRoman)
    }
}
