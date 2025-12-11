import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinnerLottoTest {
    @Test
    fun `로또 번호 중 당첨 번호와 일치하는 개수를 반환한다`() {
        // given
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        val winnerLotto = WinnnerLotto(Lotto(1, 2, 3, 4, 5, 6), BonusNumber(LottoNumber(7)))

        // when, then
        val excepted: Int = 6
        val actual = winnerLotto.countOfSameNumber(lotto)

        assertThat(actual).isEqualTo(excepted)
    }

    @Test
    fun `당첨 번호에 보너스 번호가 포함이 되면 에러가 발생한다`() {
        // given
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusNumber = BonusNumber(LottoNumber(6))

        // when, then
        assertThrows<IllegalArgumentException> { WinnnerLotto(lotto, bonusNumber) }
    }
}


