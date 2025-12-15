package domain

data class WinnerLotto(
    private val lotto: Lotto,
    private val bonusNumber: BonusNumber,
) {
    init {
        require(!bonusNumber.contains(lotto))
    }

    private fun countOfMatch(other: Lotto): Int = lotto.matchCount(other)

    private fun matchBonusNumber(other: Lotto): Boolean = bonusNumber.contains(other)

    fun rank(other: Lotto): Rank {
        val countOfMatch: Int = countOfMatch(other)
        val isBonusNumber: Boolean = matchBonusNumber(other)

        return Rank.of(countOfMatch, isBonusNumber)
    }
}