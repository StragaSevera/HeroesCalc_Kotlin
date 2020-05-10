package ru.ought.heroes_calc.damage

import ch.tutteli.atrium.api.fluent.en_GB.toBe
import ch.tutteli.atrium.api.verbs.expect
import io.mockk.mockk
import io.mockk.verifySequence
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ru.ought.heroes_calc.random.IRandom
import ru.ought.heroes_calc.random.RandomStub

object RangeDamageTest : Spek({
    describe("basic tests") {
        val sut by memoized { RangeDamage(min = 4, max = 10, mult = 4.0) }

        it("gives the random amount of damage in range with multiplier") {
            val random = RandomStub(5)

            expect(sut.resolve(random)).toBe(20)
        }

        it("calls random with correct parameters") {
            val randomMock = mockk<IRandom>(relaxed = true)

            sut.resolve(randomMock)

            verifySequence { randomMock.nextInt(4, 11) }
        }
    }
})
