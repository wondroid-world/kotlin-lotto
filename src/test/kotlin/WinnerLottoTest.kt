import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinnerLottoTest {

    @Test
    fun `당첨 번호에 보너스 번호가 포함이 되면 에러가 발생한다`() {
        // given
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusNumber = BonusNumber(LottoNumber(6))

        // when, then
        assertThrows<IllegalArgumentException> { WinnerLotto(lotto, bonusNumber) }
    }

    @Test
    fun `로또를 받으면, 등수를 반환한다` () {
        // given
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusNumber = BonusNumber(LottoNumber(7))
        val otherLotto = Lotto(1, 2, 3, 6, 44, 45)
        val winnerLotto = WinnerLotto(lotto, bonusNumber)

        // when
        val excepted = Rank.FOURTH
        val actual = winnerLotto.rank(otherLotto)

        assertThat(actual).isEqualTo(excepted)
    }
}


