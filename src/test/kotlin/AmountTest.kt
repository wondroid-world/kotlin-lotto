import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class AmountTest {
    @ParameterizedTest
    @ValueSource(ints = [-1000, -500])
    fun `구입 금액은 0보다 커야합니다`(money: Int) {
        assertThrows<IllegalArgumentException> {
            Amount(money)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 999])
    fun `로또 최소 구매 단위는 1000원이다`(money: Int) {
        assertThrows<IllegalArgumentException> {
            Amount(money)
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["1500, 500", "14000, 0"])
    fun `잔돈을 거슬러 준다`(money: Int, excepted: Int) {
        val amount = Amount(money)

        val actual = amount.charge()

        Assertions.assertThat(actual).isEqualTo(excepted)
    }
}

@JvmInline
value class Amount(
    private val money: Int,
) {
    init {
        require(money >= 0) { "구입 금액은 0보다 커야합니다." }
        require(money > 1000) {"로또 최소 구매 단위는 1000원입니다."}
    }

    fun charge(): Int {
        val charge = money - (money / 1000) * 1000
        return charge
    }
}
