package domain

class Lotto(
    _numbers: List<LottoNumber>,
) {
    init {
        require(_numbers.size == _numbers.toSet().size)
        require(_numbers.size == SIZE)
    }

    private val numbers: Set<LottoNumber> = _numbers.toSet()

    fun numbersToInt(): List<Int> = numbers.map { it.value }.sorted()

    fun matchCount(other: Lotto): Int = numbers.count(other::contains)

    fun contains(num: LottoNumber): Boolean = num in numbers

    companion object {
        const val SIZE: Int = 6

        fun from(nums: List<Int>): Lotto {
            return Lotto(nums.map(::LottoNumber))
        }

        fun of(vararg nums: Int): Lotto = from(nums.toList())
    }
}
