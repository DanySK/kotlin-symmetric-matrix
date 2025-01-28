package org.danilopianini.symmetricmatrix

/**
 * A symmetric matrix:
 * a matrix where the element at position (i, j) is the same as the element at position (j, i).
 */
interface SymmetricMatrix<T> : Iterable<T> {
    /**
     * The size of the matrix.
     */
    val size: Int

    /**
     * Get the element at position ([i], [j]).
     */
    operator fun get(
        i: Int,
        j: Int,
    ): T

    /**
     * Get elements in the row at index [i].
     */
    fun row(i: Int): List<T>

    /**
     * Get elements in the column at index [j].
     */
    fun column(j: Int): List<T>

    /**
     * Fill the matrix with the same element.
     */
    companion object {
        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun <T> fill(
            size: Int,
            element: T,
        ): SymmetricMatrix<T> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun <T> fill(
            size: Int,
            element: (i: Int, j: Int) -> T,
        ): SymmetricMatrix<T> = MutableSymmetricMatrix.fill(size, element)
    }
}
