package org.danilopianini.symmetricmatrix

/**
 * Application entrypoint.
 */
class MutableULongSymmetricMatrix(
    override val size: Int,
) : AbstractSymmetricMatrix<ULong>(),
    MutableSymmetricMatrix<ULong> {
    @OptIn(ExperimentalUnsignedTypes::class)
    private val data: ULongArray = ULongArray(size * (size + 1) / 2)

    @OptIn(ExperimentalUnsignedTypes::class)
    override operator fun get(
        i: Int,
        j: Int,
    ): ULong = data[indexOf(i, j)]

    @OptIn(ExperimentalUnsignedTypes::class)
    override operator fun set(
        i: Int,
        j: Int,
        value: ULong,
    ) {
        data[indexOf(i, j)] = value
    }
}
