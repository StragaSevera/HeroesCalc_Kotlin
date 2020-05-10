package ru.ought.heroes_calc.random

interface IRandom {
    fun nextInt(from: Int, until: Int): Int
}