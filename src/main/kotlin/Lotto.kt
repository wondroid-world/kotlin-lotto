data class Lotto(
    private val numbers: List<LottoNumber>
) {
    init {
        require(numbers.size == numbers.toSet().size)
    }

    companion object {
        operator fun invoke(vararg lottoNumbers: Int): Lotto {
            val numbers = lottoNumbers.map{ LottoNumber(it)}
            return Lotto(numbers)
        }
    }
}