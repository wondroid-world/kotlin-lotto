package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class MoneyTest {
    @Test
    fun `14_000원 빼기 4_000원은 10_000원이다`() {
        // given
        val largeMoney = Money(14_000)
        val smallMoney = Money(4_000)

        // when, then
        val excepted = Money(10_000)
        val actual = largeMoney - smallMoney

        assertThat(actual).isEqualTo(excepted)
    }

    @Test
    fun `4_000원 빼기 14_000원은 에러를 반환한다`() {
        // given
        val largeMoney = Money(14_000)
        val smallMoney = Money(4_000)

        // when, then
        assertThrows<IllegalArgumentException> { smallMoney - largeMoney }
    }

    @Test
    fun `4_000원 더하기 10_000원는 14_000원이다`() {
        // given
        val largeMoney = Money(10_000)
        val smallMoney = Money(4_000)

        // when, then
        val excepted = Money(14_000)
        val actual = largeMoney + smallMoney

        assertThat(actual).isEqualTo(excepted)
    }

    @Test
    fun `14_000원 나누기 1_000원는 14이다`() {
        // given
        val largeMoney = Money(14_000)
        val smallMoney = Money(1_000)

        // when, then
        val excepted = 14.0
        val actual = largeMoney / smallMoney

        assertThat(actual).isEqualTo(excepted)
    }

    @Test
    fun `14_000원 나누기 0원는 에러를 반환한다`() {
        // given
        val largeMoney = Money(14_000)
        val smallMoney = Money(0)

        // when, then
        assertThrows<IllegalArgumentException> { largeMoney / smallMoney }
    }

    @Test
    fun `14_000원 나누기 1_000원의 나머지는 0원이다`() {
        // given
        val largeMoney = Money(14_000)
        val smallMoney = Money(1_000)

        // when, then
        val excepted = Money(0)
        val actual = largeMoney % smallMoney

        assertThat(actual).isEqualTo(excepted)
    }

    @Test
    fun `14개 곱하기 1_000원은 14_000원이다`() {
        // given
        val count = 14
        val money = Money(1_000)

        // when, then
        val excepted = Money(14_000)
        val actual = money * count

        assertThat(actual).isEqualTo(excepted)
    }
}
