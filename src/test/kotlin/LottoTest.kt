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

data class Lotto private constructor(
    private val lottoNumbers: Set<LottoNumber>
) {
    init {
        require(lottoNumbers.size == NUMBER_OF_LOTTO_NUMBERS) { "로또는 6개의 로또 번호를 가져야합니다." }
    }

    val size get() = lottoNumbers.size

    companion object {
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_END_NUMBER = 45
        private const val NUMBER_OF_LOTTO_NUMBERS = 6

        fun from(vararg number: Int): Lotto {
            val lottoNumbers = number.map { LottoNumber(it) }
            if (lottoNumbers.size != lottoNumbers.toSet().size) {
                throw IllegalArgumentException("로또 번호는 중복되면 안됩니다.")
            }
            return Lotto(lottoNumbers.toSet())
        }

        fun from(numbers: List<Int>): Lotto {
            val lottoNumbers = numbers.map { LottoNumber(it) }
            if (lottoNumbers.size != lottoNumbers.toSet().size) {
                throw IllegalArgumentException("로또 번호는 중복되면 안됩니다.")
            }
            return Lotto(lottoNumbers.toSet())
        }

        fun create(): Lotto {
            val lottoNumbers =
                (LOTTO_START_NUMBER..LOTTO_END_NUMBER)
                    .shuffled()
                    .take(NUMBER_OF_LOTTO_NUMBERS)
            return from(lottoNumbers)
        }
    }
}