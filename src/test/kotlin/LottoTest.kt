import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {
    @Test
    fun `로또는 로또 번호 6개가 있다`() {
        val lotto = Lotto.from(1, 2, 3, 4, 5, 6)

        val actual = lotto.size

        val expected = 6

        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4", "1,2,3,4,5", "1,2,3,4,5,6,7"])
    fun `로또는 로또 번호 6개가 아니면 안된다`(numbersString: String) {
        val numbers = numbersString.split(",").map { it.toInt() }.toIntArray()

        assertThrows<IllegalArgumentException> {
            Lotto.from(*numbers)
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,5,5", "1,2,3,4,5,6,6"])
    fun `로또는 중복되면 안된다`(numbersString: String) {
        val numbers = numbersString.split(",").map { it.toInt() }.toIntArray()

        assertThrows<IllegalArgumentException> {
            Lotto.from(*numbers)
        }
    }

    @Test
    fun `로또를 생성하면 6개의 로또 번호가 발행된다`() {
        val lotto = Lotto.create()
        val actual = lotto.size
        val expected = 6

        assertThat(actual).isEqualTo(expected)
    }
}



