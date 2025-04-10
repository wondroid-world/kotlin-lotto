import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.math.round

class LottoTicketsTest {
    @Test
    fun `로또 여러장을 가지고 있는 LottoTickets가 있다`() {
        val lottos = listOf<Lotto>(
            Lotto.from(1, 2, 3, 4, 5, 6),
            Lotto.from(1, 2, 3, 4, 5, 7),
            Lotto.from(1, 2, 3, 4, 5, 8),
        )
        assertDoesNotThrow {
            LottoTickets(lottos)
        }
    }

    @Test
    fun `총 당첨 등수를 계산할 수 있다`() {
        val lottos = listOf<Lotto>(
            Lotto.from(1, 2, 3, 4, 5, 6),
            Lotto.from(1, 2, 3, 4, 5, 7),
            Lotto.from(1, 2, 3, 4, 5, 8),
        )
        val winningLotto = WinningLotto.of(1, 2, 3, 4, 5, 6, number = 7)
        val lottoTickets = LottoTickets(lottos)

        val actual = lottoTickets.calculateRank(winningLotto)

        val expected = listOf<Rank>(Rank.FIRST, Rank.SECOND, Rank.THIRD)

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `수익률을 계산할 수 있다`() {
        val lottos = listOf<Lotto>(
            Lotto.from(1, 2, 3, 4, 5, 6),
            Lotto.from(1, 2, 3, 4, 5, 7),
            Lotto.from(1, 2, 3, 4, 5, 8),
        )
        val winningLotto = WinningLotto.of(1, 2, 3, 4, 5, 6, number = 7)
        val lottoTickets = LottoTickets(lottos)

        val actual = lottoTickets.calculateProfit(winningLotto)

        val expected = 6771666.67

        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

class LottoTickets(
    private val lottos: List<Lotto>,
) {
    fun calculateRank(winningLotto: WinningLotto): List<Rank> {
        val ranks = lottos.map { lotto: Lotto -> winningLotto.rank(lotto) }
        return ranks
    }

    fun calculateProfit(winningLotto: WinningLotto): Double {
        val ranks: List<Rank> = calculateRank(winningLotto)
        val winningMoney = ranks.map { rank -> rank.winningMoney }.sum()
        val profit = round(winningMoney.toDouble() / lottos.size) / 100
        return profit
    }
}