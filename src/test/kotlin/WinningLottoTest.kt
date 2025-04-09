import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class WinningLottoTest {
    @Test
    fun `로또와 보너스 번호를 가진다`() {
        assertDoesNotThrow { WinningLotto.of(1, 2, 3, 4, 5, 6, number = 7) }
    }


}

class WinningLotto private constructor(
    private val lotto: Lotto,
    private val bonusNumber: LottoNumber,
) {
    companion object {
        fun of(vararg lottoNumber: Int, number: Int): WinningLotto {
            val lotto = Lotto.from(*lottoNumber)
            val bonusNumber = LottoNumber.from(number)
            return WinningLotto(lotto, bonusNumber)
        }
    }
}
