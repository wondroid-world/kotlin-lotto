package domain

enum class Rank(val countOfMatch: Int, val winningMoney: Money, val matchBonusRequired: Boolean = false) {
    FIRST(6, Money(2_000_000_000)),
    SECOND(5, Money(30_000_000), true),
    THIRD(5, Money(1_500_000)),
    FOURTH(4, Money(50_000)),
    FIFTH(3, Money(5_000)),
    MISS(0, Money(0));

    companion object {
        fun of(countOfMatch: Int, matchBonus: Boolean): Rank {
            return entries.find { rank: Rank ->
                rank.matchBonusRequired == matchBonus && rank.countOfMatch == countOfMatch
            } ?: MISS
        }
    }
}
