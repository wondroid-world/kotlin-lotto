import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또는 1~45 사이의 서로 다른 숫자 6개로 구성된다`() {
        assertDoesNotThrow { Lotto(1, 2, 3, 4, 5, 6) }
    }

    @Test
    fun `로또에서 동일한 숫자가 올 시, 에러를 반환한다`() {
        assertThrows<IllegalArgumentException> { Lotto(1, 2, 3, 4, 5, 5) }
    }
}

