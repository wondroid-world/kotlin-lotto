import kotlin.math.round

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