package view

import domain.*

object View {
    fun startMessage(): Money {
        println("구입금액을 입력해 주세요.")
        val value = readln().toInt()
        val money = Money(value)
        return money
    }

    fun showCountOfLotto(lottos: Lottos) {
        println("${lottos.count}개를 구매했습니다.")
        lottos.forEach { lotto: Lotto ->
            println("[${lotto.number.joinToString(", ")}]")
        }
    }

    fun getWinnerLotto(): WinnerLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val nums = readln().split(", ").map { it.toInt() }
        val lotto = Lotto.from(nums)
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = BonusNumber.from(readln().toInt())
        return WinnerLotto(lotto, bonusNumber)
    }

    fun showPrize(lottos: Lottos) {
        println(
            """
            당첨 통계
            ---------
            3개 일치 (5000원)- ${lottos.ranks.count { it == Rank.FIFTH }}개
            4개 일치 (50000원)- ${lottos.ranks.count { it == Rank.FOURTH }}개
            5개 일치 (1500000원)- ${lottos.ranks.count { it == Rank.THIRD }}개
            5개 일치, 보너스 볼 일치(30000000원) - ${lottos.ranks.count { it == Rank.SECOND }}개
            6개 일치 (2000000000원)- ${lottos.ranks.count { it == Rank.FIRST }}개
            총 수익률은 ${lottos.profit}입니다.
        """.trimIndent()
        )
    }
}