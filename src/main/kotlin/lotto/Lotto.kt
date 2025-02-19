package lotto

class Lotto(
    private val numbers: List<LottoNumber> = generateLotto(),
) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.toSet().size)
    }

    fun getSize(): Int = numbers.size

    companion object {
        private fun generateLotto(): List<LottoNumber> {
            return (1..45).shuffled().take(6).map { LottoNumber(it) }
        }
    }
}
