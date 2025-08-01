import kotlin.test.Test

class CanaryTest {
    @Test
    fun `should fail`() {

        assert(rigth().contentEquals(arrayOf(1,0,0,0)));
    }

    private fun rigth(): Array<Int> {
        return arrayOf(0,0,0,0)
    }
}
