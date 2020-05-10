package ru.ought.heroes_calc.damage

import ch.tutteli.atrium.api.fluent.en_GB.toBe
import ch.tutteli.atrium.api.verbs.expect
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ru.ought.heroes_calc.random.RandomStub

object FlatDamageTest : Spek({
    describe("basic tests") {
        it("gives the flat amount of damage") {
            val random = RandomStub(5)
            val sut = FlatDamage(8)

            expect(sut.resolve(random)).toBe(5)
        }
    }
})
