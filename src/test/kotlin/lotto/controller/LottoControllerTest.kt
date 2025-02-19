package lotto.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoControllerTest {
    @ParameterizedTest
    @ValueSource(strings = ["1000"])
    fun `구입 금액을 전달하면 로또의 장수를 반환한다`(input: String) {
        val lottoController = LottoController()
        val count = lottoController.getLottosCount(input)
        assertThat(count).isEqualTo(1)
    }
}
