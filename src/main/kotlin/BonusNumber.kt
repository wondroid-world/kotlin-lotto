data class BonusNumber(
    private val number: LottoNumber
) {

    fun isSame(number: LottoNumber): Boolean = this.number == number
}