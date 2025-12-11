data class WinnnerLotto(
    private val lotto: Lotto,
    private val bonusNumber: BonusNumber,
) {
    init {
        require(!bonusNumber.contains(lotto))
    }

    private fun countOfMatch(other: Lotto): Int = lotto.matchCount(other)

    private fun matchBonusNumber(other: Lotto): Boolean = bonusNumber.contains(other)
}