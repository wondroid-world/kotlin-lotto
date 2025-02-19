package lotto.model

class LottoResult(private val ranks: List<Rank>) {
    fun getWinningStatus(): Map<Rank, Int> {
        return ranks.groupingBy { it }.eachCount()
    }

    fun calcultateROI(): Double {
        val totalWinningMoney = ranks.sumOf { it.winningMoney }
        return totalWinningMoney / (ranks.size * 1_000).toDouble()
    }
}
