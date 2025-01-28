package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of unsigned shorts.
 */
class MutableUShortSymmetricMatrix(
    override val size: Int,
) : AbstractSymmetricMatrix<UShort>(),
    MutableSymmetricMatrix<UShort> {
    @OptIn(ExperimentalUnsignedTypes::class)
    private val data: UShortArray = UShortArray(size * (size + 1) / 2)

    @OptIn(ExperimentalUnsignedTypes::class)
    override operator fun get(
        i: Int,
        j: Int,
    ): UShort = data[indexOf(i, j)]

    @OptIn(ExperimentalUnsignedTypes::class)
    override operator fun set(
        i: Int,
        j: Int,
        value: UShort,
    ) {
        data[indexOf(i, j)] = value
    }
}
