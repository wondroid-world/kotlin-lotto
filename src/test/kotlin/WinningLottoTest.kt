import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class WinningLottoTest {
    @Test
    fun `로또와 보너스 번호를 가진다`() {
        assertDoesNotThrow { WinningLotto.of(1, 2, 3, 4, 5, 6, number = 7) }
    }

    @Test
    fun `로또의 당첨 1등를 계산한다`() {
        val lotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto.of(1, 2, 3, 4, 5, 6, number = 7)

        val actual = winningLotto.rank(lotto)

        val expected = Rank.FIRST

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또의 당첨 2등를 계산한다`() {
        val lotto = Lotto.from(1, 2, 3, 4, 5, 7)
        val winningLotto = WinningLotto.of(1, 2, 3, 4, 5, 6, number = 7)

        val actual = winningLotto.rank(lotto)

        val expected = Rank.SECOND

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또의 당첨 3등를 계산한다`() {
        val lotto = Lotto.from(1, 2, 3, 4, 5, 8)
        val winningLotto = WinningLotto.of(1, 2, 3, 4, 5, 6, number = 7)

        val actual = winningLotto.rank(lotto)

        val expected = Rank.THIRD

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또의 당첨 4등를 계산한다`() {
        val lotto = Lotto.from(1, 2, 3, 4, 8, 9)
        val winningLotto = WinningLotto.of(1, 2, 3, 4, 5, 6, number = 7)

        val actual = winningLotto.rank(lotto)

        val expected = Rank.FOURTH

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또의 당첨 5등를 계산한다`() {
        val lotto = Lotto.from(1, 2, 3, 8, 9, 10)
        val winningLotto = WinningLotto.of(1, 2, 3, 4, 5, 6, number = 7)

        val actual = winningLotto.rank(lotto)

        val expected = Rank.FIFTH

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또의 당첨 꽝를 계산한다`() {
        val lotto = Lotto.from(1, 2, 8, 9, 10, 11)
        val winningLotto = WinningLotto.of(1, 2, 3, 4, 5, 6, number = 7)

        val actual = winningLotto.rank(lotto)

        val expected = Rank.MISS

        Assertions.assertThat(actual).isEqualTo(expected)
    }
}
