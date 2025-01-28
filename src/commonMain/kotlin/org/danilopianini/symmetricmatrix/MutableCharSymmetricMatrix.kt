package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of booleans.
 */
class MutableCharSymmetricMatrix(
    override val size: Int,
) : AbstractSymmetricMatrix<Char>(),
    MutableSymmetricMatrix<Char> {
    private val data: CharArray = CharArray(size * (size + 1) / 2)

    override operator fun get(
        i: Int,
        j: Int,
    ): Char = data[indexOf(i, j)]

    override operator fun set(
        i: Int,
        j: Int,
        value: Char,
    ) {
        data[indexOf(i, j)] = value
    }
}
