package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestMutableDoubleSymmetricMatrix {

    @Test
    fun matrixWithSizeOne() {
        val matrix = MutableDoubleSymmetricMatrix(1)
        assertEquals(matrix.size, 1)
        matrix[0, 0] = 5.0
        assertEquals(5.0, matrix[0, 0])
    }

    @Test
    fun getReturnsCorrectValue() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        matrix[0, 1] = 1.5
        assertEquals(1.5, matrix[0, 1])
    }

    @Test
    fun setUpdatesValueCorrectly() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        matrix[1, 2] = 2.5
        assertEquals(2.5, matrix[1, 2])
    }

    @Test
    fun getThrowsExceptionForInvalidIndices() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0]
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3]
        }
    }

    @Test
    fun setThrowsExceptionForInvalidIndices() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0] = 1.0
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3] = 1.0
        }
    }

    @Test
    fun getReturnsSymmetricValue() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        matrix[1, 2] = 3.5
        assertEquals(3.5, matrix[2, 1])
    }

    @Test
    fun setUpdatesSymmetricValueCorrectly() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        matrix[2, 1] = 4.5
        assertEquals(4.5, matrix[1, 2])
    }

    @Test
    fun `regression test given a matrix of size 4 doing operations on 0-2 would change also the index 1-1`() {
        val matrix = MutableDoubleSymmetricMatrix(4)
        matrix[1, 1] = 5.0
        assertEquals(5.0, matrix[1, 1])
        matrix[0, 2] = 7.5
        assertEquals(7.5, matrix[0, 2])
        assertEquals(5.0, matrix[1, 1])
    }
}
