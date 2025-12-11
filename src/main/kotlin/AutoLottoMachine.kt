class AutoLottoMachine : LottoMachine {
    override fun issue(): Lotto {
        val numbers: List<Int> = (LottoNumber.START_NUMBER .. LottoNumber.END_NUMBER).shuffled().take(Lotto.SIZE)
        return Lotto.from(numbers)
    }
}