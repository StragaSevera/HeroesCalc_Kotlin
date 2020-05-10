package ru.ought.heroes_calc.random

import ch.tutteli.atrium.api.fluent.en_GB.toBe
import ch.tutteli.atrium.api.fluent.en_GB.toThrow
import ch.tutteli.atrium.api.verbs.expect
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object RandomStubTest : Spek({
    val sut by memoized { RandomStub(5) }
    
    describe("basic tests") {
        it("correctly gives stubbed number") {
            expect(sut.nextInt(0, 6)).toBe(5)
        }

        it("throws error when stubbed number is out of bounds") {
            expect {sut.nextInt(0, 5)}.toThrow<IllegalArgumentException>()
        }
    }
})
