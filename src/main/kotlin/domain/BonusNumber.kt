package domain

data class BonusNumber(
    private val number: LottoNumber
) {

    fun contains(lotto: Lotto): Boolean = lotto.contains(number)

    fun isSame(number: LottoNumber): Boolean = this.number == number

    companion object {
        fun from(num: Int): BonusNumber = BonusNumber(LottoNumber(num))
    }
}