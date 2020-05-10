package ru.ought.heroes_calc.damage

import ru.ought.heroes_calc.random.IRandom

interface IDamage {
    fun resolve(random: IRandom): Int
}