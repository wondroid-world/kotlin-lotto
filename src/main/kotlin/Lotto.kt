data class Lotto(
    private val numbers: Set<LottoNumber>
) {
    init {
        require(numbers.size == 6)
    }

    constructor(nums: List<LottoNumber>) : this(nums.toSet()) {
        require(numbers.size == numbers.toSet().size)
    }

    constructor(vararg nums: Int) : this(nums.map { LottoNumber(it) })

    fun matchCount(other: Lotto): Int = numbers.count { num -> other.contains(num) }

    fun contains(num: LottoNumber): Boolean = num in numbers
}
