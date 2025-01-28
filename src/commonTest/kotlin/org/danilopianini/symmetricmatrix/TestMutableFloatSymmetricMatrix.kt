package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestMutableFloatSymmetricMatrix {

    @Test
    fun getReturnsCorrectValue() {
        val matrix = MutableFloatSymmetricMatrix(3)
        matrix[0, 1] = 1.5f
        assertEquals(1.5f, matrix[0, 1])
    }

    @Test
    fun setUpdatesValueCorrectly() {
        val matrix = MutableFloatSymmetricMatrix(3)
        matrix[1, 2] = 2.5f
        assertEquals(2.5f, matrix[1, 2])
    }

    @Test
    fun getThrowsExceptionForInvalidIndices() {
        val matrix = MutableFloatSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0]
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3]
        }
    }

    @Test
    fun setThrowsExceptionForInvalidIndices() {
        val matrix = MutableFloatSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0] = 1.0f
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3] = 1.0f
        }
    }

    @Test
    fun getReturnsSymmetricValue() {
        val matrix = MutableFloatSymmetricMatrix(3)
        matrix[1, 2] = 3.5f
        assertEquals(3.5f, matrix[2, 1])
    }

    @Test
    fun setUpdatesSymmetricValueCorrectly() {
        val matrix = MutableFloatSymmetricMatrix(3)
        matrix[2, 1] = 4.5f
        assertEquals(4.5f, matrix[1, 2])
    }
}