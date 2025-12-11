data class WinnnerLotto(
    private val lotto: Lotto,
    private val bonusNumber: BonusNumber,
) {
    init {
        require(!bonusNumber.contains(lotto))
    }

    fun countOfMatch(other: Lotto): Int {
        return lotto.matchCount(other)
    }
}