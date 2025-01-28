package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestMutableLongSymmetricMatrix {

    @Test
    fun getReturnsCorrectValue() {
        val matrix = MutableLongSymmetricMatrix(3)
        matrix[0, 1] = 10L
        assertEquals(10L, matrix[0, 1])
    }

    @Test
    fun setUpdatesValueCorrectly() {
        val matrix = MutableLongSymmetricMatrix(3)
        matrix[1, 2] = 20L
        assertEquals(20L, matrix[1, 2])
    }

    @Test
    fun getThrowsExceptionForInvalidIndices() {
        val matrix = MutableLongSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0]
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3]
        }
    }

    @Test
    fun setThrowsExceptionForInvalidIndices() {
        val matrix = MutableLongSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0] = 10L
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3] = 10L
        }
    }

    @Test
    fun getReturnsSymmetricValue() {
        val matrix = MutableLongSymmetricMatrix(3)
        matrix[1, 2] = 30L
        assertEquals(30L, matrix[2, 1])
    }

    @Test
    fun setUpdatesSymmetricValueCorrectly() {
        val matrix = MutableLongSymmetricMatrix(3)
        matrix[2, 1] = 40L
        assertEquals(40L, matrix[1, 2])
    }
}