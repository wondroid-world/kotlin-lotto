import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 40, 41, 42, 43, 45])
    fun `로또 번호는 1부터 45사이의 숫자이다`(value: Int) {
        // when, then
        assertDoesNotThrow { LottoNumber(value) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `로또 번호는 1부터 45사이 이외의 숫자가 들어오면 에러가 난다`(value: Int) {
        // when, then
        assertThrows<IllegalArgumentException> { LottoNumber(value) }
    }
}

