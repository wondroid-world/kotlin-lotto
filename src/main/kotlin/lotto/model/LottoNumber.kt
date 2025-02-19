package lotto.model

data class LottoNumber(
    val number: Int,
) {
    init {
        require(number in 1..45) { "숫자는 1에서 45사이입니다" }
    }
}
