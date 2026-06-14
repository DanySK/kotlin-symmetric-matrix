package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals

class TestLargeIndexing {
    private class ExposedIndexMatrix(override val size: Int) : AbstractSymmetricMatrix<Unit>() {
        fun index(i: Int, j: Int): Int = indexOf(i, j)

        fun indices(index: Int): Pair<Int, Int> = indicesFromIndex(index)

        override fun get(i: Int, j: Int): Unit = Unit
    }

    @Test
    fun indexingUsesLongArithmeticForLargeValidMatrices() {
        val matrix = ExposedIndexMatrix(65_535)
        val index = matrix.index(65_534, 65_534)
        val expectedIndex = (65_535L * 65_536L / 2L - 1L).toInt()
        assertEquals(expectedIndex, index)
        assertEquals(65_534 to 65_534, matrix.indices(index))
    }
}
