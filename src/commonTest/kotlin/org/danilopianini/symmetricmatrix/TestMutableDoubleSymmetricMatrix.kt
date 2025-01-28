package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestMutableDoubleSymmetricMatrix {
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
}
