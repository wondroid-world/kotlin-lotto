package domain

class LottoSeller {
    fun getCountOfLotto(money: Money): Int = money / PRICE_LOTTO

    fun getCharge(money: Money): Money {
        val charge = money % PRICE_LOTTO
        return charge
    }

    companion object {
        private val PRICE_LOTTO: Money = Money(1_000)
    }
}