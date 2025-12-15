package domain

class LottoSeller {
    private fun getCountOfLotto(money: Money): Int = (money / PRICE_LOTTO).toInt()

    fun getCharge(money: Money): Money {
        val charge = money % PRICE_LOTTO
        return charge
    }

    fun issue(money: Money, lottoMachine: LottoMachine): Lottos {
        val count = getCountOfLotto(money = money)
        return Lottos(List(count) { lottoMachine.issue() })
    }

    companion object {
        val PRICE_LOTTO: Money = Money(1_000)
    }
}