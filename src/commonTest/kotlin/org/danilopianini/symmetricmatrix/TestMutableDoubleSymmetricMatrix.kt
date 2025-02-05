package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestMutableDoubleSymmetricMatrix {

    @Test
    fun `create a matrix with a single element`() {
        val matrix = MutableDoubleSymmetricMatrix(1)
        assertEquals(matrix.size, 1)
        matrix[0, 0] = SAMPLE_VALUE
        assertEquals(SAMPLE_VALUE, matrix[0, 0])
    }

    @Test
    fun `get should return the expected value`() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        matrix[0, 1] = SAMPLE_VALUE
        assertEquals(SAMPLE_VALUE, matrix[0, 1])
    }

    @Test
    fun `set should update value correctly`() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        matrix[1, 2] = SAMPLE_VALUE
        assertEquals(SAMPLE_VALUE, matrix[1, 2])
    }

    @Test
    fun `get throws exception for invalid indices`() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0]
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3]
        }
    }

    @Test
    fun `set throws exception for invalid indices`() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        assertFailsWith<IllegalArgumentException> {
            matrix[3, 0] = SAMPLE_VALUE
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3] = SAMPLE_VALUE
        }
    }

    @Test
    fun `get should work symmetrically`() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        matrix[1, 2] = SAMPLE_VALUE
        assertEquals(SAMPLE_VALUE, matrix[2, 1])
    }

    @Test
    fun `set should updates symmetric value correctly`() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        matrix[2, 1] = SAMPLE_VALUE
        assertEquals(SAMPLE_VALUE, matrix[1, 2])
    }

    @Test
    fun `on a 4x4 changing 0-2 does not change 1-1`() {
        val differentSample = SAMPLE_VALUE + 1
        val matrix = MutableDoubleSymmetricMatrix(4)
        matrix[1, 1] = SAMPLE_VALUE
        assertEquals(SAMPLE_VALUE, matrix[1, 1])
        matrix[0, 2] = differentSample
        assertEquals(differentSample, matrix[0, 2])
        assertEquals(SAMPLE_VALUE, matrix[1, 1])
    }

    companion object {
        private const val SAMPLE_VALUE = 5.5
    }
}
