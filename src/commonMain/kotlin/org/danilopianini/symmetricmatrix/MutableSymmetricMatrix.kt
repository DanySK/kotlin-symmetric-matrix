package org.danilopianini.symmetricmatrix

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
            object : AbstractSymmetricMatrix<T>(), MutableSymmetricMatrix<T> {

                private val data: Array<T> = Array(internalSize) { element }

                @Suppress("NoNameShadowing") // Both definitions of "size" belong to the public API
                override val size: Int get() = size

                override fun get(i: Int, j: Int): T = data[indexOf(i, j)]

                override fun set(i: Int, j: Int, value: T) {
                    data[indexOf(i, j)] = value
                }
            }

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        inline fun <reified T> of(size: Int, crossinline element: (i: Int, j: Int) -> T): MutableSymmetricMatrix<T> =
            object : AbstractSymmetricMatrix<T>(), MutableSymmetricMatrix<T> {

                private val data: Array<T> = Array(internalSize) { index ->
                    indicesFromIndex(index).let { (i, j) -> element(i, j) }
                }

                @Suppress("NoNameShadowing") // Both definitions of "size" belong to the public API
                override val size: Int get() = size

                override fun get(i: Int, j: Int): T = data[indexOf(i, j)]

                override fun set(i: Int, j: Int, value: T) {
                    data[indexOf(i, j)] = value
                }
            }
    }
}
