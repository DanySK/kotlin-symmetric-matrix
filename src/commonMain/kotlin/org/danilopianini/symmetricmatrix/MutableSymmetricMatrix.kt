package org.danilopianini.symmetricmatrix

import org.danilopianini.symmetricmatrix.AbstractSymmetricMatrix.Companion.symmetricMatrixIndicesFromIndex
import org.danilopianini.symmetricmatrix.AbstractSymmetricMatrix.Companion.symmetricMatrixInternalSize

/**
 * A mutable symmetric matrix:
 * a matrix where the element at position (i, j) is the same as the element at position (j, i).
 */
interface MutableSymmetricMatrix<T> : SymmetricMatrix<T> {
    /**
     * Set the element at position ([i], [j]) to [value].
     */
    operator fun set(i: Int, j: Int, value: T)

    /**
     * Fill the matrix with the same element.
     */
    companion object {
        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        inline fun <reified T> of(size: Int, element: T): MutableSymmetricMatrix<T> =
            constantMutableSymmetricMatrix(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        inline fun <reified T> of(size: Int, crossinline element: (i: Int, j: Int) -> T): MutableSymmetricMatrix<T> =
            computedMutableSymmetricMatrix(size) { i, j -> element(i, j) }

        @PublishedApi
        internal inline fun <reified T> constantMutableSymmetricMatrix(
            size: Int,
            element: T,
        ): MutableSymmetricMatrix<T> = computedMutableSymmetricMatrix(size) { _, _ -> element }

        @PublishedApi
        internal inline fun <reified T> computedMutableSymmetricMatrix(
            size: Int,
            crossinline element: (i: Int, j: Int) -> T,
        ): MutableSymmetricMatrix<T> = ArrayBackedMutableSymmetricMatrix(
            size,
            Array(symmetricMatrixInternalSize(size)) { index ->
                val (i, j) = symmetricMatrixIndicesFromIndex(size, index)
                element(i, j)
            },
        )

        @PublishedApi
        internal class ArrayBackedMutableSymmetricMatrix<T>(override val size: Int, private val data: Array<T>) :
            AbstractSymmetricMatrix<T>(),
            MutableSymmetricMatrix<T> {
            override fun get(i: Int, j: Int): T = data[indexOf(i, j)]

            override fun set(i: Int, j: Int, value: T) {
                data[indexOf(i, j)] = value
            }
        }
    }
}
