package domain

class LottoSeller {
    fun getCharge(money: Money): Money {
        val charge = money % PRICE_LOTTO
        return charge
    }

    fun issue(
        money: Money,
        lottoMachine: LottoMachine,
    ): Lottos {
        val count = getCountOfLotto(money = money)
        return Lottos(List(count) { lottoMachine.issue() })
    }

    private fun getCountOfLotto(money: Money): Int = (money / PRICE_LOTTO).toInt()

    companion object {
        val PRICE_LOTTO: Money = Money(1_000)
    }
}
