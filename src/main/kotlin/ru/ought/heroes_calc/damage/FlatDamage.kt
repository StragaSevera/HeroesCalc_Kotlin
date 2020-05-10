package ru.ought.heroes_calc.damage

import ru.ought.heroes_calc.random.IRandom

class FlatDamage(private val amount: Int) : IDamage {
    override fun resolve(random: IRandom): Int = amount
}