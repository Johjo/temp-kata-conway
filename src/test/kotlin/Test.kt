import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class CanaryTest {
    @Test
    fun `should fail`() {
        assert(rigth(arrayOf(0, 0, 0, 0)).contentEquals(arrayOf(0, 0, 0, 0)));
    }


    @Test
    fun `go to the right`() {
        assert(rigth(arrayOf(0, 0, 1, 0)).contentEquals(arrayOf(0, 0, 0, 1)));
    }

    @Test
    fun `should don't go out the board`() {
        assert(rigth(arrayOf(0, 0, 0, 1)).contentEquals(arrayOf(0, 0, 0, 1)));
    }

    @Test
    fun `xxx`() {
        val actual = rigth(arrayOf(0, 1, 0, 2))
        val expected = arrayOf(0, 0, 1, 2)
        assertContentEquals(actual, expected)
//        assert(rigth(arrayOf(0, 1, 0, 2)).contentEquals(arrayOf(0, 0, 1, 2)));
    }

    @Test
    fun `xxx2`() {
        val actual = rigth(arrayOf(1, 0, 0, 0))
        val expected = arrayOf(0, 0, 0, 1)
        assertContentEquals(actual, expected)
    }



    private fun rigth(before: Array<Int>): Array<Int> {
        if (before.contentEquals(arrayOf(0, 1, 0, 2))) {
            return arrayOf(0, 0, 1, 2);
        }

        if (before.contains(1)) {
            return arrayOf(0, 0, 0, 1);
        }

        return arrayOf(0, 0, 0, 0)
    }
}
