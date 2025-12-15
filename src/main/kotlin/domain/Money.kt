package domain

@JvmInline
value class Money(
    private val value: Int,
) {
    init {
        require(value >= 0) { "돈은 0원이상이여야합니다." }
    }

    operator fun minus(other: Money): Money = Money(this.value - other.value)

    operator fun plus(other: Money): Money = Money(this.value + other.value)

    operator fun div(other: Money): Int {
        require(other.value > 0) { "0원은 나눌 수 없습니다." }
        return this.value / other.value
    }

    operator fun rem(other: Money): Money {
        require(other.value > 0) { "0원은 나눌 수 없습니다." }
        return Money(this.value % other.value)
    }
}