package lotto.model

class LottoScanner(
    private val winning: Lotto,
) {
    fun getResult(lottos: List<Lotto>): LottoResult {
        val result = lottos.map { getRank(it) }
        return LottoResult(result)
    }

    fun getRank(lotto: Lotto): Rank {
        val countOfMatch: Int = getCountOfMatch(lotto)
        val matchBonus: Boolean = getMatchBonus(lotto)
        return Rank.valueOf(countOfMatch, matchBonus)
    }

    private fun getCountOfMatch(lotto: Lotto): Int {
        return winning.getNumbers().intersect(lotto.getNumbers()).size
    }

    private fun getMatchBonus(lotto: Lotto): Boolean {
        return lotto.getNumbers().contains(winning.getBonusNumber())
    }
}
