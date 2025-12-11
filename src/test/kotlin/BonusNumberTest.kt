import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BonusNumberTest {
    @ParameterizedTest
    @CsvSource(
        "1, 1",
        "3, 3",
        "45, 45"
    )
    fun `보너스 번호와 동일한 번호가 들어오면, true를 반환한다`(bonusNum: Int, num: Int) {
        // given
        val bonusNumber = BonusNumber(LottoNumber(bonusNum))
        val lottoNumber = LottoNumber(num)

        // when, then
        val actual = bonusNumber.isSame(lottoNumber)

        assertThat(actual).isTrue()
    }

    @ParameterizedTest
    @CsvSource(
        "1, 3",
        "3, 5",
        "45, 41"
    )
    fun `보너스 번호와 다른 번호가 들어오면, false를 반환한다`(bonusNum: Int, num: Int) {
        // given
        val bonusNumber = BonusNumber(LottoNumber(bonusNum))
        val lottoNumber = LottoNumber(num)

        // when, then
        val actual = bonusNumber.isSame(lottoNumber)

        assertThat(actual).isFalse()
    }
}