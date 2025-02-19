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
}

class Validation {
    fun isEmpty(input: String) {
        require(input.isNotEmpty())
    }
}
