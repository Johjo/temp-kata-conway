package kata.base

import io.kotest.matchers.booleans.shouldBeTrue
import org.junit.jupiter.api.Test

class CanaryTest {
    @Test
    fun `should fail`() {
        true.shouldBeTrue()
    }
}
