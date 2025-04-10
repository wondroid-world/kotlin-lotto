class Cashier(
    private val money: Int,
) {
    val lottoCount: Int
        get() = money / 1000

    init {
        require(money >= 0) { "구입 금액은 0보다 커야합니다." }
        require(money > 1000) {"로또 최소 구매 단위는 1000원입니다."}
    }

    fun charge(): Int {
        val charge = money - lottoCount * 1000
        return charge
    }
}