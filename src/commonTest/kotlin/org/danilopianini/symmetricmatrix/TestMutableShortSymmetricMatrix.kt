package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestMutableShortSymmetricMatrix {

    @Test
    fun getReturnsCorrectValue() {
        val matrix = MutableShortSymmetricMatrix(3)
        matrix[0, 1] = 10
        assertEquals(10, matrix[0, 1])
    }

    @Test
    fun setUpdatesValueCorrectly() {
        val matrix = MutableShortSymmetricMatrix(3)
        matrix[1, 2] = 20
        assertEquals(20, matrix[1, 2])
    }

    @Test
    fun getThrowsExceptionForInvalidIndices() {
        val matrix = MutableShortSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0]
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3]
        }
    }

    @Test
    fun setThrowsExceptionForInvalidIndices() {
        val matrix = MutableShortSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0] = 10
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3] = 10
        }
    }

    @Test
    fun getReturnsSymmetricValue() {
        val matrix = MutableShortSymmetricMatrix(3)
        matrix[1, 2] = 30
        assertEquals(30, matrix[2, 1])
    }

    @Test
    fun setUpdatesSymmetricValueCorrectly() {
        val matrix = MutableShortSymmetricMatrix(3)
        matrix[2, 1] = 40
        assertEquals(40, matrix[1, 2])
    }
}