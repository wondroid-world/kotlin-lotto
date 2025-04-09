data class Lotto private constructor(
    private val lottoNumbers: Set<LottoNumber>
) {
    init {
        require(lottoNumbers.size == NUMBER_OF_LOTTO_NUMBERS) { "로또는 6개의 로또 번호를 가져야합니다." }
    }

    val size get() = lottoNumbers.size

    companion object {
        private const val NUMBER_OF_LOTTO_NUMBERS = 6

        fun from(vararg number: Int): Lotto = from(number.toList())

        private fun from(numbers: List<Int>): Lotto {
            val lottoNumbers = numbers.map { LottoNumber.from(it) }
            if (lottoNumbers.size != lottoNumbers.toSet().size) {
                throw IllegalArgumentException("로또 번호는 중복되면 안됩니다.")
            }
            return Lotto(lottoNumbers.toSet())
        }

        fun create(): Lotto {
            val randomNumber =
                LottoNumber
                    .lottoNumbers()
                    .shuffled()
                    .take(NUMBER_OF_LOTTO_NUMBERS)
            return Lotto(randomNumber.toSet())
        }
    }
}