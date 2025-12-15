package domain

@JvmInline
value class LottoNumber(
   val value: Int,
) {
    init {
        require(value in START_NUMBER .. END_NUMBER) {"로또 번호는 1부터 45사이의 숫자입니다."}
    }

    companion object {
        const val START_NUMBER: Int = 1
        const val END_NUMBER: Int = 45
    }
}