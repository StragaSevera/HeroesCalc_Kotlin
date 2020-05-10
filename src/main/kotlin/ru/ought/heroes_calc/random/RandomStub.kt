package ru.ought.heroes_calc.random

class RandomStub(private val num: Int) : IRandom {
    override fun nextInt(from: Int, until: Int): Int {
        require(num in from until until)
        return num
    }
}