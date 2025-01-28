package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestMutableULongSymmetricMatrix  {

    @Test
    fun getReturnsCorrectValue() {
        val matrix = MutableULongSymmetricMatrix(3)
        matrix[0, 1] = 10uL
        assertEquals(10uL, matrix[0, 1])
    }

    @Test
    fun setUpdatesValueCorrectly() {
        val matrix = MutableULongSymmetricMatrix(3)
        matrix[1, 2] = 20uL
        assertEquals(20uL, matrix[1, 2])
    }

    @Test
    fun getThrowsExceptionForInvalidIndices() {
        val matrix = MutableULongSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0]
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3]
        }
    }

    @Test
    fun setThrowsExceptionForInvalidIndices() {
        val matrix = MutableULongSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0] = 10uL
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3] = 10uL
        }
    }

    @Test
    fun getReturnsSymmetricValue() {
        val matrix = MutableULongSymmetricMatrix(3)
        matrix[1, 2] = 30uL
        assertEquals(30uL, matrix[2, 1])
    }

    @Test
    fun setUpdatesSymmetricValueCorrectly() {
        val matrix = MutableULongSymmetricMatrix(3)
        matrix[2, 1] = 40uL
        assertEquals(40uL, matrix[1, 2])
    }
}