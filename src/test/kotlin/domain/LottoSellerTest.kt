package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoSellerTest {

    @ParameterizedTest
    @CsvSource(
        "15_600, 600",
        "10_000, 0",
        "1_000, 0",
        "800, 800"
    )
    fun `구입 금액에 따라 잔돈을 반환한다`(value: Int, expected: Int) {
        // given
        val seller = LottoSeller()
        val money = Money(value)

        // when, then
        val actual: Money = seller.getCharge(money)

        assertThat(actual).isEqualTo(Money(expected))
    }
}

