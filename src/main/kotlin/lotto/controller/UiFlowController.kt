package lotto.controller

import lotto.view.InputView
import lotto.view.ResultView

class UiFlowController {
    fun handlePurchaseCost(): String {
        ResultView.showMessage("구입금액을 입력해 주세요.")
        return InputView.getUserInput()
    }

    fun handlePurchaseLotto(count: Int): String {
        ResultView.showMessage("\n${count}개를 구매했습니다.")
        return InputView.getUserInput()
    }

    fun handleLottoNumbers(): String {
        ResultView.showMessage("\n당첨 번호를 입력해 주세요.")
        val lottoNumbers = InputView.getUserInput()
        return lottoNumbers
    }

    fun handleBonusNumber(): String {
        ResultView.showMessage("\n보너스 번호를 입력해 주세요.")
        val bonusNumber = InputView.getUserInput()
        return bonusNumber
    }

    fun handlePrize() {
        ResultView.showMessage("")
    }
}
