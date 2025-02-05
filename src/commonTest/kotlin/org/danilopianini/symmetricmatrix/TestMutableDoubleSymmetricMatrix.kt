package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestMutableDoubleSymmetricMatrix {
    val five = 5.5

    @Test
    fun `create a matrix with a single element`() {
        val matrix = MutableDoubleSymmetricMatrix(1)
        assertEquals(matrix.size, 1)
        matrix[0, 0] = five
        assertEquals(five, matrix[0, 0])
    }

    @Test
    fun `get should return the expected value`() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        matrix[0, 1] = five
        assertEquals(five, matrix[0, 1])
    }

    @Test
    fun `set should update value correctly`() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        matrix[1, 2] = five
        assertEquals(five, matrix[1, 2])
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
            matrix[3, 0] = five
        }
        assertFailsWith<IllegalArgumentException> {
            matrix[0, 3] = five
        }
    }

    @Test
    fun `get should return symmetric value`() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        matrix[1, 2] = five
        assertEquals(five, matrix[2, 1])
    }

    @Test
    fun `set should updates symmetric value correctly`() {
        val matrix = MutableDoubleSymmetricMatrix(3)
        matrix[2, 1] = five
        assertEquals(five, matrix[1, 2])
    }

    @Test
    fun `on a 4x4, changing <0.2> does not change <1:1>~!@#$%*()_-+={}[]:;?/\`() {
        val seven = 7.0
        val matrix = MutableDoubleSymmetricMatrix(4)
        matrix[1, 1] = five
        assertEquals(five, matrix[1, 1])
        matrix[0, 2] = seven
        assertEquals(seven, matrix[0, 2])
        assertEquals(five, matrix[1, 1])
    }
}
