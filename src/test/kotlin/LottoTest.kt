import org.assertj.core.api.Assertions.assertThat
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

    @Test
    fun `로또는 특정 번호를 포함을 하면, true를 반환한다`() {
        // given
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        val num = LottoNumber(6)

        // when, then
        val actual = lotto.contains(num)

        assertThat(actual).isTrue()
    }

    @Test
    fun `로또는 특정 번호를 포함하지 않으면, false를 반환한다`() {
        // given
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        val num = LottoNumber(7)

        // when, then
        val actual = lotto.contains(num)

        assertThat(actual).isFalse()
    }

    @Test
    fun `로또는 다른 로또 번호들과 매칭되는 개수를 반환한다`() {
        // given
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        val other = Lotto(1, 2, 3, 4, 5, 6)

        // when, then
        val excepted: Int = 6
        val actual = lotto.matchCount(other)

        assertThat(actual).isEqualTo(excepted)
    }
}

