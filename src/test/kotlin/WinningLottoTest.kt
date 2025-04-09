import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class WinningLottoTest {
    @Test
    fun `로또와 보너스 번호를 가진다`() {
        val lotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.from(7)

        assertDoesNotThrow { WinningLotto(lotto, bonusNumber) }
    }
}

class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: LottoNumber,
) {

}
