package ru.ought.heroes_calc.damage

import ru.ought.heroes_calc.random.IRandom

class RangeDamage(private val min: Int, private val max: Int, private val mult: Float) : IDamage {
    override fun resolve(random: IRandom): Int {
        return (mult * random.nextInt(min, max + 1)).toInt()
    }
}