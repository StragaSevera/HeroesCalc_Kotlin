package ru.ought.heroes_calc.random

import kotlin.random.Random

class RandomWrapper(private val innerRandom: Random = Random.Default) : IRandom {
    override fun nextInt(from: Int, until: Int) = innerRandom.nextInt(from, until)
}