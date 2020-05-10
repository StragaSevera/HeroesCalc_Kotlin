package ru.ought.heroes_calc.damage

import ch.tutteli.atrium.api.fluent.en_GB.toBe
import ch.tutteli.atrium.api.verbs.expect
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object StatBlockTest : Spek({
    describe("basic tests") {
        it("calculates correct damage with simple setup") {
            val source = StatBlock(stackSize = 4, minDmg = 3, maxDmg = 5, attack = 1, defence = 1)
            val target = StatBlock(stackSize = 1, minDmg = 1, maxDmg = 1, attack = 1, defence = 1)

            expect(source.damageTarget(target)).toBe(RangeDamage(
                mult = 4.0, min = 3, max = 5
            ))
        }

        it("calculates correct damage when attack is higher than defence") {
            val source = StatBlock(stackSize = 4, minDmg = 3, maxDmg = 5, attack = 3, defence = 1)
            val target = StatBlock(stackSize = 1, minDmg = 1, maxDmg = 1, attack = 1, defence = 1)

            expect(source.damageTarget(target)).toBe(RangeDamage(
                mult = 4.4, min = 3, max = 5
            ))
        }

        it("calculates correct damage when attack is lower than defence") {
            val source = StatBlock(stackSize = 4, minDmg = 3, maxDmg = 5, attack = 3, defence = 1)
            val target = StatBlock(stackSize = 1, minDmg = 1, maxDmg = 1, attack = 1, defence = 7)

            expect(source.damageTarget(target)).toBe(RangeDamage(
                mult = 4 / 1.2, min = 3, max = 5
            ))
        }
    }
})
