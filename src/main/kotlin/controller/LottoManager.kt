package controller

import domain.AutoLottoMachine
import domain.LottoSeller
import domain.Lottos
import domain.WinnerLotto
import view.View

class LottoManager {
    fun progress() {
        val lottos = lottos()
        View.showCountOfLotto(lottos)
        val winnerLotto = View.getWinnerLotto()
        showResult(lottos, winnerLotto)
    }

    private fun lottos(): Lottos {
        val money = View.startMessage()
        val seller = LottoSeller()
        val machine = AutoLottoMachine()
        val lottos = seller.issue(money, machine)
        return lottos
    }

    private fun showResult(
        lottos: Lottos,
        winnerLotto: WinnerLotto,
    ) {
        val ranks = lottos.ranks(winnerLotto)
        val profit = lottos.profit(winnerLotto)
        View.showPrize(ranks, profit)
    }
}
