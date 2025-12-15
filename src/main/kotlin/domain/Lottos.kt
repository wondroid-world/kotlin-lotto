package domain

class Lottos(
    val value: List<Lotto>,
) {
    val count: Int get() = value.size

    private val purchaseAmount: Money get() = LottoSeller.PRICE_LOTTO * this.count

    fun ranks(winnerLotto: WinnerLotto): List<Rank> = value.map(winnerLotto::rank)

    fun profit(winnerLotto: WinnerLotto): Double = totalWinningMoney(winnerLotto) / purchaseAmount

    private fun totalWinningMoney(winnerLotto: WinnerLotto): Money =
        ranks(winnerLotto).map { it.winningMoney }.reduce { acc, money -> acc + money }
}

fun Lottos.forEach(action: (Lotto) -> Unit) {
    value.forEach(action)
}
