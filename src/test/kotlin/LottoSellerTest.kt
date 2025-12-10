import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoSellerTest {

    @ParameterizedTest
    @CsvSource(
        "0, 0",
        "15_600, 15",
        "10_000, 10"
    )
    fun `구입 금액에 따라 살 수 있는 로또의 개수가 달라진다`(money: Int, countOfLotto: Int) {
        // given
        val seller = LottoSeller()
        val money = Money(money)

        // when, then
        val excepted: Int = countOfLotto
        val actual = seller.getCountOfLotto(money)

        assertThat(actual).isEqualTo(excepted)
    }
}

