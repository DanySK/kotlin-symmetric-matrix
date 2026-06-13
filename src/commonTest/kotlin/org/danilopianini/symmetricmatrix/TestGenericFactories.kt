package org.danilopianini.symmetricmatrix

import kotlin.test.Test
import kotlin.test.assertEquals

class TestGenericFactories {
    private fun <T> immutableMatrixOf(element: T): SymmetricMatrix<T> = SymmetricMatrix.of(2, element)

    private fun <T> mutableMatrixOf(element: T): MutableSymmetricMatrix<T> = MutableSymmetricMatrix.of(2, element)

    @Test
    fun symmetricMatrixFactoryAcceptsGenericElements() {
        val matrix = immutableMatrixOf("value")
        assertEquals("value", matrix[0, 1])
    }

    @Test
    fun mutableSymmetricMatrixFactoryAcceptsGenericElements() {
        val matrix = mutableMatrixOf("value")
        matrix[0, 1] = "updated"
        assertEquals("updated", matrix[1, 0])
    }
}
