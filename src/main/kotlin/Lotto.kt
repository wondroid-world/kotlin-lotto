data class Lotto(
    private val numbers: Set<LottoNumber>
) {
    init {
        require(numbers.size == LOTTO_SIZE)
    }

    constructor(nums: List<LottoNumber>) : this(nums.toSet()) {
        require(numbers.size == numbers.toSet().size)
    }

    constructor(vararg nums: Int) : this(nums.map { LottoNumber(it) })

    fun matchCount(other: Lotto): Int = numbers.count { num -> other.contains(num) }

    fun contains(num: LottoNumber): Boolean = num in numbers

    companion object {
        const val LOTTO_SIZE: Int = 6
    }
}
