package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestMutableUByteSymmetricMatrix {
    @Test
    fun getReturnsCorrectValue() {
        val matrix = MutableUByteSymmetricMatrix(3)
        matrix[0, 1] = 10u
        assertEquals(10u, matrix[0, 1])
    }

    @Test
    fun setUpdatesValueCorrectly() {
        val matrix = MutableUByteSymmetricMatrix(3)
        matrix[1, 2] = 20u
        assertEquals(20u, matrix[1, 2])
    }

    @Test
    fun getThrowsExceptionForInvalidIndices() {
        val matrix = MutableUByteSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0]
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3]
        }
    }

    @Test
    fun setThrowsExceptionForInvalidIndices() {
        val matrix = MutableUByteSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0] = 10u
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3] = 10u
        }
    }

    @Test
    fun getReturnsSymmetricValue() {
        val matrix = MutableUByteSymmetricMatrix(3)
        matrix[1, 2] = 30u
        assertEquals(30u, matrix[2, 1])
    }

    @Test
    fun setUpdatesSymmetricValueCorrectly() {
        val matrix = MutableUByteSymmetricMatrix(3)
        matrix[2, 1] = 40u
        assertEquals(40u, matrix[1, 2])
    }
}
