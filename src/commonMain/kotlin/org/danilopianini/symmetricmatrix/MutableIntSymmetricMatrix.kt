package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of integers.
 */
class MutableIntSymmetricMatrix(
    override val size: Int,
) : AbstractSymmetricMatrix<Int>(),
    MutableSymmetricMatrix<Int> {
    private val data: IntArray = IntArray(size * (size + 1) / 2)

    override operator fun get(
        i: Int,
        j: Int,
    ): Int = data[indexOf(i, j)]

    override operator fun set(
        i: Int,
        j: Int,
        value: Int,
    ) {
        data[indexOf(i, j)] = value
    }
}
