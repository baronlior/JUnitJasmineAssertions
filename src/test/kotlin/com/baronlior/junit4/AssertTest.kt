package com.baronlior.junit4

import org.junit.Assert.*
import org.junit.Test
import java.io.File

class AssertTest {

    @Test
    fun jUnitBaseline() {
        assertEquals("", 1, 1)
    }


    @Test
    fun toBe() {
        it("toBe") {

            expect { 2 + 2 toBe 4 }
            expect { Long.MAX_VALUE toBe Long.MAX_VALUE }
            expect { "ab" + "cd" toBe "abcd" }
            expect { true toBe true }
            expect { null toBe null }
            expect { 1 to "2" toBe Pair(1,"2") }
            expect { File("/usr") toBe File("/usr") }

            expect { 2 + 2 notToBe 5 }
            expect { Long.MAX_VALUE notToBe Long.MIN_VALUE }
            expect { "ab" + "cd" notToBe "ab+cd" }
            expect { false notToBe true }
            expect { "assd" notToBe null }
            expect { null notToBe 5 }
            expect { arrayOf(1) notToBe arrayOf(1) }

        }
    }

    @Test
    fun toLessOrGreater() {
        it("toLessOrGreater") {

            expect { 2 + 2 toBeLessThan 11 }

        }
    }

    fun match() {

        it("The 'toMatch' matcher is for regular expressions") {
            val message = "foo bar baz";

            expect { message toMatchRegex "bar" }
            expect { message notToMatchRegex "quux" }

        }
    }


    @Test
    fun toBeDeepEqual() {
        it("toBeDeepEqual") {

            expect("different object references") { arrayOf("1", "2") notToBe arrayOf("1", "2") }
            expect{ arrayOf(1, "2") toBeDeepEqual arrayOf(1, "2") }
        }
    }

}
