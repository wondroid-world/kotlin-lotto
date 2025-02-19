package lotto

class LottoScanner(
    private val winning: Lotto,
    private val lotto: Lotto,
) {
    private val countOfMatch: Int = getCountOfMatch()
    private val matchBonus: Boolean = getMatchBonus()

    fun getRank(): Rank {
        return Rank.valueOf(countOfMatch, matchBonus)
    }

    private fun getCountOfMatch(): Int {
        return winning.getNumbers().intersect(lotto.getNumbers()).size
    }

    private fun getMatchBonus(): Boolean {
        return lotto.getNumbers().contains(winning.getBonusNumber())
    }
}
