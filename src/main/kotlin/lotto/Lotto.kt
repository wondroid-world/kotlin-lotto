package lotto

class Lotto(
    private val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.size == 6)
    }

    fun getSize(): Int = numbers.size
}
