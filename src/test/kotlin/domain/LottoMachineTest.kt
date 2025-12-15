package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `유효한 로또를 발급해준다`() {
        // given
        val machine = AutoLottoMachine()

        // when, then
        val actual: Lotto = machine.issue()
        assertThat(actual).isInstanceOf(Lotto::class.java)
    }
}

