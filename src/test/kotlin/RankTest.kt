import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `번호가 6개 동일하면 1등이다`() {
        val actual = Rank.valueOf(6, false)

        val expected = Rank.FIRST

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `번호가 6개 동일하면 1등이다2`() {
        val actual = Rank.valueOf(6, true)

        val expected = Rank.FIRST

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `번호가 5개 동일하고 보너스 번호를 맞추면 2등이다`() {
        val actual = Rank.valueOf(5, true)

        val expected = Rank.SECOND

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `번호가 5개 동일하고 보너스 번호가 틀리면 3등이다`() {
        val actual = Rank.valueOf(5, false)

        val expected = Rank.THIRD

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `번호가 4개 동일하면 4등이다`() {
        val actual = Rank.valueOf(4, false)

        val expected = Rank.FOURTH

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `번호가 4개 동일하면 4등이다2`() {
        val actual = Rank.valueOf(4, true)

        val expected = Rank.FOURTH

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `번호가 3개 동일하면 5등이다`() {
        val actual = Rank.valueOf(3, false)

        val expected = Rank.FIFTH

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `번호가 3개 동일하면 5등이다2`() {
        val actual = Rank.valueOf(3, true)

        val expected = Rank.FIFTH

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `번호가 0개 동일하면 꽝이다`() {
        val actual = Rank.valueOf(0, false)

        val expected = Rank.MISS

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `번호가 0개 동일하면 꽝이다2`() {
        val actual = Rank.valueOf(0, true)

        val expected = Rank.MISS

        Assertions.assertThat(actual).isEqualTo(expected)
    }
}


