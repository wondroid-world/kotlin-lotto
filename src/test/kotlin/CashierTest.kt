import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CashierTest {
    @ParameterizedTest
    @ValueSource(ints = [-1000, -500])
    fun `구입 금액은 0보다 커야합니다`(money: Int) {
        assertThrows<IllegalArgumentException> {
            Cashier(money)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 999])
    fun `로또 최소 구매 단위는 1000원이다`(money: Int) {
        assertThrows<IllegalArgumentException> {
            Cashier(money)
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["1500, 500", "14000, 0"])
    fun `잔돈을 거슬러 준다`(money: Int, excepted: Int) {
        val amount = Cashier(money)

        val actual = amount.charge()

        Assertions.assertThat(actual).isEqualTo(excepted)
    }

    @ParameterizedTest
    @CsvSource(value = ["1500, 1", "14000, 14"])
    fun `로또 구입 가능 갯수를 알수 있다`(money: Int, excepted: Int) {
        val amount = Cashier(money)

        val actual = amount.lottoCount

        Assertions.assertThat(actual).isEqualTo(excepted)
    }
}

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
