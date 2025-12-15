package controller

import domain.AutoLottoMachine
import domain.LottoSeller
import view.View

class LottoManager {
    fun progress() {
        val money = View.startMessage()
        val seller = LottoSeller()
        val machine = AutoLottoMachine()
        val lottos = seller.issue(money, machine)
        View.showCountOfLotto(lottos)
        val winnerLotto = View.getWinnerLotto()
        lottos.ranks(winnerLotto)
        View.showPrize(lottos)
    }
}