package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoScannerTest {
    @Test
    fun `로또 당첨을 판단한다`() {
        val bonusNumber: LottoNumber = LottoNumber(7)

        val winning: Lotto =
            Lotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                ),
                bonusNumber,
            )

        val lotto: Lotto =
            Lotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                ),
            )

        val lottoScanner = LottoScanner(winning)

        val rank = lottoScanner.getRank(lotto)
        assertEquals(rank, Rank.FIRST)
    }
}
