@JvmInline
value class LottoNumber(
    private val value: Int,
) {
    init {
        require(value in 1..45) {"로또 번호는 1부터 45사이의 숫자입니다."}
    }
}