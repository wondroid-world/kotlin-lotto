import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 12, 40, 45])
    fun `로또 번호는 1 ~ 45 사이이다`(number: Int) {
        assertDoesNotThrow { LottoNumber.from(number) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46, 100])
    fun `로또 번호는 1 ~ 45 사이의 숫자가 아니면 에러가 난다`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber.from(number) }
    }
}

