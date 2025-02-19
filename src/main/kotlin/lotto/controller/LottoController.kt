package lotto.controller

class LottoController {
    fun run() {}

    fun getLottosCount(input: String): Int {
        return input.toInt() / 1000
    }
}
