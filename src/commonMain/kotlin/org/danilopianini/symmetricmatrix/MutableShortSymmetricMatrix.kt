package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of shorts.
 */
class MutableShortSymmetricMatrix(
    override val size: Int,
) : AbstractSymmetricMatrix<Short>(),
    MutableSymmetricMatrix<Short> {
    private val data: ShortArray = ShortArray(size * (size + 1) / 2)

    override operator fun get(
        i: Int,
        j: Int,
    ): Short = data[indexOf(i, j)]

    override operator fun set(
        i: Int,
        j: Int,
        value: Short,
    ) {
        data[indexOf(i, j)] = value
    }
}
