class LottoSeller {
    fun getCountOfLotto(money: Money): Int = money / PRICE_LOTTO

    companion object {
        private val PRICE_LOTTO: Money = Money(1_000)
    }
}