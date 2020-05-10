package ru.ought.heroes_calc.damage

data class StatBlock(val stackSize: Int, val minDmg: Int, val maxDmg: Int, val attack: Int, val defence: Int) {
    fun damageTarget(target: StatBlock): IDamage {
        var multiplier = stackSize.toDouble()
        val diff = attack - target.defence
        if (diff > 0) {
            multiplier *= 1 + 0.05 * diff
        } else if (diff < 0) {
            multiplier /= 1 + 0.05 * (-diff)
        }
        return RangeDamage(mult = multiplier, min = minDmg, max = maxDmg)
    }
}