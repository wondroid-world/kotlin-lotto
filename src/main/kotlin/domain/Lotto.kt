package domain

data class Lotto(
    private val _numbers: List<LottoNumber>
) {
    init {
        require(_numbers.size == _numbers.toSet().size)
        require(_numbers.size == SIZE)
    }

    constructor(vararg nums: Int) : this(nums.map(::LottoNumber))

    private val numbers: Set<LottoNumber> = _numbers.toSet()

    fun matchCount(other: Lotto): Int = numbers.count { num -> other.contains(num) }

    fun contains(num: LottoNumber): Boolean = num in numbers

    companion object {
        const val SIZE: Int = 6

        fun from(nums: List<Int>): Lotto {
            return Lotto(nums.map(::LottoNumber))
        }
    }
}
