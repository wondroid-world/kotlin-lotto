@JvmInline
value class LottoNumber(
    private val number: Int
) {
    init {
        require(number in LOTTO_START_NUMBER..LOTTO_END_NUMBER) { "로또 번호는 1 ~ 45 사이입니다." }
    }

    companion object {
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_END_NUMBER = 45
    }
}
// value class가 아닌 data class를 사용한 이유
// 추후 각 번호가 동일한지 아닌 지 판단을 해야하는 데, 이를 위해서는 equals와 hashCode를 오버라이드해야한다.
// value class는 원시값을 넣었을 때, 객체가 만들어지지 않기 때문에 효율적인 성능을 가질 수 있다.
// 그리고 equals와 hashCode를 override 할 수 있다는 점에서 이점?
