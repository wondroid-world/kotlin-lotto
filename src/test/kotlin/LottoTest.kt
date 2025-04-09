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

    @Test
    fun `로또 번호 중 보너스 번호가 있으면 true를 반환한다`() {
        val lotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.from(1)

        val actual = lotto.contanins(bonusNumber)

        assertThat(actual).isTrue()
    }

    @Test
    fun `로또 번호 중 보너스 번호가 없으면 false를 반환한다`() {
        val lotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.from(7)

        val actual = lotto.contanins(bonusNumber)

        assertThat(actual).isFalse()
    }

    @Test
    fun `로또 번호 중 당첨 번호가 6개 있는 지 확인할 수 있다`() {
        val winningLotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.from(1, 2, 3, 4, 5, 6)

        val actual = lotto.count(winningLotto)

        val expected = 6

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 번호 중 당첨 번호가 5개 있는 지 확인할 수 있다`() {
        val winningLotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.from(1, 2, 3, 4, 5, 7)

        val actual = lotto.count(winningLotto)

        val expected = 5

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 번호 중 당첨 번호가 4개 있는 지 확인할 수 있다`() {
        val winningLotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.from(1, 2, 3, 4, 7, 8)

        val actual = lotto.count(winningLotto)

        val expected = 4

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 번호 중 당첨 번호가 3개 있는 지 확인할 수 있다`() {
        val winningLotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.from(1, 2, 3, 7, 8, 9)

        val actual = lotto.count(winningLotto)

        val expected = 3

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 번호 중 당첨 번호가 2개 있는 지 확인할 수 있다`() {
        val winningLotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.from(1, 2, 7, 8, 9, 10)

        val actual = lotto.count(winningLotto)

        val expected = 2

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 번호 중 당첨 번호가 1개 있는 지 확인할 수 있다`() {
        val winningLotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.from(1, 7, 8, 9, 10, 11)

        val actual = lotto.count(winningLotto)

        val expected = 1

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또 번호 중 당첨 번호가 0개 있는 지 확인할 수 있다`() {
        val winningLotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.from(7, 8, 9, 10, 11, 12)

        val actual = lotto.count(winningLotto)

        val expected = 0

        assertThat(actual).isEqualTo(expected)
    }
}



