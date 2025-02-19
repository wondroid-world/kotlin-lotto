package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `수익률을 판단한다`() {
        val ranks = listOf(Rank.FIFTH, Rank.MISS)
        val lottoResult = LottoResult(ranks)
        val roi = lottoResult.calcultateROI()
        assertEquals(roi, 2.5)
    }
}
