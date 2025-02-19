package lotto.controller

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidationTest {
    @ParameterizedTest
    @ValueSource(strings = [""])
    fun `구입금액이 공백인지 판단`(input: String) {
        assertThrows<IllegalArgumentException> {
            Validation().isEmpty(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["가나다라"])
    fun `구입금액이 Int타입이 아니면 에러를 출력한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Validation().isInteger(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1"])
    fun `구입금액이 0과 음수면 에러를 출력한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Validation().isNegativeNumber(input)
        }
    }
}

class Validation {
    fun isEmpty(input: String) {
        require(input.isNotEmpty())
    }

    fun isInteger(input: String) {
        requireNotNull(input.toIntOrNull())
    }

    fun isNegativeNumber(input: String) {
        require(input.toInt() > 0)
    }
}
