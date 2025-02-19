package lotto

class LottoMachine(
    val count: Int,
) {
    val lottos: List<Lotto> = generateLottos(count)

    companion object {
        private fun generateLottos(count: Int): List<Lotto> {
            val lottos = mutableListOf<Lotto>()
            repeat(count) {
                val lotto = Lotto()
                lottos.add(lotto)
            }
            return lottos
        }
    }
}
