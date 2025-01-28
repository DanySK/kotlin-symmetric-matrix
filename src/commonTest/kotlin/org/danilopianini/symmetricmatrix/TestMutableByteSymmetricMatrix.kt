package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestMutableByteSymmetricMatrix {
    @Test
    fun getReturnsCorrectValue() {
        val matrix = MutableByteSymmetricMatrix(3)
        matrix[0, 1] = 1
        assertEquals(1, matrix[0, 1])
    }

    @Test
    fun setUpdatesValueCorrectly() {
        val matrix = MutableByteSymmetricMatrix(3)
        matrix[1, 2] = 2
        assertEquals(2, matrix[1, 2])
    }

    @Test
    fun getThrowsExceptionForInvalidIndices() {
        val matrix = MutableByteSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0]
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3]
        }
    }

    @Test
    fun setThrowsExceptionForInvalidIndices() {
        val matrix = MutableByteSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0] = 1
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3] = 1
        }
    }

    @Test
    fun getReturnsSymmetricValue() {
        val matrix = MutableByteSymmetricMatrix(3)
        matrix[1, 2] = 3
        assertEquals(3, matrix[2, 1])
    }

    @Test
    fun setUpdatesSymmetricValueCorrectly() {
        val matrix = MutableByteSymmetricMatrix(3)
        matrix[2, 1] = 4
        assertEquals(4, matrix[1, 2])
    }
}
