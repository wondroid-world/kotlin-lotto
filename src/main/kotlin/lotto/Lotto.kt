package lotto

class Lotto(
    private val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.toSet().size)
    }

    fun getSize(): Int = numbers.size
}
