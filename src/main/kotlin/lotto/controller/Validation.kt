package lotto.controller

class Validation {
    fun isEmpty(input: String) {
        require(input.isNotEmpty())
    }

    fun isInteger(input: String) {
        requireNotNull(input.toIntOrNull())
    }

    fun isNegativeNumber(input: String) {
        require(input.toInt() > 0)
    }

    fun isUnits(input: String) {
        require(input.toInt() % 1000 == 0)
    }
}
