data class WinnnerLotto(
    private val lotto: Lotto,
    private val bonusNumber: BonusNumber,
) {
    init {
        require(!bonusNumber.contains(lotto))
    }

    fun countOfSameNumber(other: Lotto): Int {
        return lotto.matchCount(other)
    }
}