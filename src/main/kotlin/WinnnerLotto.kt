data class WinnnerLotto(
    private val lotto: Lotto,
    private val bonusNumber: BonusNumber,
) {
    fun countOfSameNumber(other: Lotto): Int {
        return lotto.matchCount(other)
    }
}