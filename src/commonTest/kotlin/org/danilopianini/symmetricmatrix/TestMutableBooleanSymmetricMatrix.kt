package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestMutableBooleanSymmetricMatrix {
    @Test
    fun getReturnsCorrectValue() {
        val matrix = MutableBooleanSymmetricMatrix(3)
        matrix[0, 1] = true
        assertEquals(true, matrix[0, 1])
    }

    @Test
    fun setUpdatesValueCorrectly() {
        val matrix = MutableBooleanSymmetricMatrix(3)
        matrix[1, 2] = true
        assertEquals(true, matrix[1, 2])
    }

    @Test
    fun getThrowsExceptionForInvalidIndices() {
        val matrix = MutableBooleanSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0]
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3]
        }
    }

    @Test
    fun setThrowsExceptionForInvalidIndices() {
        val matrix = MutableBooleanSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0] = true
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3] = true
        }
    }

    @Test
    fun getReturnsSymmetricValue() {
        val matrix = MutableBooleanSymmetricMatrix(3)
        matrix[1, 2] = true
        assertEquals(true, matrix[2, 1])
    }

    @Test
    fun setUpdatesSymmetricValueCorrectly() {
        val matrix = MutableBooleanSymmetricMatrix(3)
        matrix[2, 1] = true
        assertEquals(true, matrix[1, 2])
    }
}
