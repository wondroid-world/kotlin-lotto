
class WinningLotto private constructor(
    private val lotto: Lotto,
    private val bonusNumber: LottoNumber,
) {
    fun rank(lotto: Lotto): Rank {
        val countOfMatch: Int = lotto.count(this.lotto)
        val matchBonus: Boolean = lotto.contanins(bonusNumber)
        return Rank.valueOf(countOfMatch, matchBonus)
    }

    companion object {
        fun of(vararg lottoNumber: Int, number: Int): WinningLotto {
            val lotto = Lotto.from(*lottoNumber)
            val bonusNumber = LottoNumber.from(number)
            return WinningLotto(lotto, bonusNumber)
        }
    }
}
