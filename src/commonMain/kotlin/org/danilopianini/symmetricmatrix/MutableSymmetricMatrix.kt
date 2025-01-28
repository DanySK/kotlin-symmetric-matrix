package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix:
 * a matrix where the element at position (i, j) is the same as the element at position (j, i).
 */
interface MutableSymmetricMatrix<T> : SymmetricMatrix<T> {
    /**
     * Set the element at position ([i], [j]) to [value].
     */
    operator fun set(
        i: Int,
        j: Int,
        value: T,
    )

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
        ) = fill(size) { _, _ -> element }

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        inline fun <T> fill(
            size: Int,
            crossinline element: (i: Int, j: Int) -> T,
        ): MutableSymmetricMatrix<T> =
            object : AbstractSymmetricMatrix<T>(), MutableSymmetricMatrix<T> {
                override val size: Int = size

                private val data: MutableList<T> =
                    MutableList(size * (size + 1) / 2) { i ->
                        indicesFromIndex(i).let { (i, j) -> element(i, j) }
                    }

                override fun get(
                    i: Int,
                    j: Int,
                ): T = data[indexOf(i, j)]

                override fun set(
                    i: Int,
                    j: Int,
                    value: T,
                ) {
                    data[indexOf(i, j)] = value
                }
            }
    }
}
