import kotlin.test.Test
import kotlin.test.assertContentEquals

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
    fun `yyyy`() {
        assert(rigth(arrayOf(0, 1, 0, 0)).contentEquals(arrayOf(0, 0, 0, 1)));
    }

    @Test
    fun `yyyy2`() {
        assert(rigth(arrayOf(1, 0, 0, 0)).contentEquals(arrayOf(0, 0, 0, 1)));
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

    @Test
    fun `xxx3`() {
        val actual = rigth(arrayOf(0, 1, 2, 0))
        val expected = arrayOf(0, 0, 1, 2)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `xxx4`() {
        val actual = rigth(arrayOf(0, 2, 2, 0))
        val expected = arrayOf(0, 0, 0, 4)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `xxx5`() {
        val actual = rigth(arrayOf(2, 0, 2, 0))
        val expected = arrayOf(0, 0, 0, 4)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `xxx6`() {
        val actual = rigth(arrayOf(0, 0, 2, 2))
        val expected = arrayOf(0, 0, 0, 4)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `xxx7`() {
        val actual = rigth(arrayOf(0, 0, 1, 1))
        val expected = arrayOf(0, 0, 0, 2)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `xxx8`() {
        val actual = rigth(arrayOf(0, 1, 1, 4))
        val expected = arrayOf(0, 0, 2, 4)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `xxx9`() {
        val actual = rigth(arrayOf(3, 1, 1, 4))
        val expected = arrayOf(0, 3, 2, 4)
        assertContentEquals(expected, actual)
    }
    @Test
    fun `xxx10`() {
        val actual = rigth(arrayOf(1, 2, 3, 4))
        val expected = arrayOf(1, 2, 3, 4)
        assertContentEquals(expected, actual)
    }
    @Test
    fun `xxx11`() {
        val actual = rigth(arrayOf(1, 1, 4, 0))
        val expected = arrayOf(0, 0, 2, 4)
        assertContentEquals(expected, actual)
    }



    private fun rigth(before: Array<Int>): Array<Int> {
        var after = mutableListOf<Int>();
        moveToTheRight(before, after)
        after = merge(after)
        return complete(after)
    }

    private fun moveToTheRight(before: Array<Int>, after: MutableList<Int>) {
        if (before[0] != 0) after.add(before[0])
        if (before[1] != 0) after.add(before[1])
        if (before[2] != 0) after.add(before[2])
        if (before[3] != 0) after.add(before[3])
    }

    private fun merge(after: MutableList<Int>): MutableList<Int> {
        var bis = mutableListOf<Int>();
        var i = 0

        while (after.size > i) {
            if (after.size == i + 1 || after[i] != after[i + 1]) {
                bis.add(after[i])
                i ++
            } else {
                bis.add(after[i] + after[i + 1])
                i += 2;
            }
        }

        return bis

    }

    private fun complete(after: MutableList<Int>): Array<Int> {
        while (after.size < 4)
            after.add(0, 0)
        return after.toTypedArray()
    }
}
