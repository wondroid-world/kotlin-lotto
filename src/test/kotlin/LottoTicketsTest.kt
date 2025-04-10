import org.junit.jupiter.api.Test

class LottoTicketsTest {
    @Test
    fun `로또 여러장을 가지고 있는 LottoTickets가 있다`() {
        val lottos = listOf<Lotto>(
            Lotto.from(1,2,3,4,5,6),
            Lotto.from(1,2,3,4,5,7),
            Lotto.from(1,2,3,4,5,8),
        )
        val lottoTickets = LottoTickets(lottos)
    }
}

class LottoTickets(
    val lottos: List<Lotto>,
)