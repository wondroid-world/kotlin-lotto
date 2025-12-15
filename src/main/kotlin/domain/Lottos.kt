package domain

class Lottos(
    val value: List<Lotto>
) {
    val count: Int get() = value.size

    var ranks: List<Rank> = emptyList()
        private set

    private val totalWinningMoney: Money get() = this.ranks.map { it.winningMoney }.reduce { acc, money -> acc + money }

    private val purchaseAmount: Money = LottoSeller.PRICE_LOTTO * this.count

    val profit: Double get() = totalWinningMoney / purchaseAmount


    fun ranks(winnerLotto: WinnerLotto): List<Rank> {
        val ranks = value.map { lotto: Lotto ->
            winnerLotto.rank(lotto)
        }
        this.ranks = ranks
        return ranks
    }
}

fun Lottos.forEach(action: (Lotto) -> Unit) {
    for (lotto in value) {
        action(lotto)
    }
}