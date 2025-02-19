package lotto.model

class Lotto(
    private val numbers: List<LottoNumber> = generateLotto(),
    private val bonusNumber: LottoNumber? = null,
) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.toSet().size)
        require(!numbers.contains(bonusNumber))
    }

    fun getSize(): Int = numbers.size

    fun getNumbers(): List<LottoNumber> = numbers.toList()

    fun getBonusNumber(): LottoNumber? = bonusNumber

    companion object {
        private fun generateLotto(): List<LottoNumber> {
            return (1..45).shuffled().take(6).map { LottoNumber(it) }
        }
    }
}
