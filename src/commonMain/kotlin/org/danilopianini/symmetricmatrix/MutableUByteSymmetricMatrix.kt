package org.danilopianini.symmetricmatrix

/**
 * Application entrypoint.
 */
class MutableUByteSymmetricMatrix(
    override val size: Int,
) : AbstractSymmetricMatrix<UByte>(),
    MutableSymmetricMatrix<UByte> {
    @OptIn(ExperimentalUnsignedTypes::class)
    private val data: UByteArray = UByteArray(size * (size + 1) / 2)

    @OptIn(ExperimentalUnsignedTypes::class)
    override operator fun get(
        i: Int,
        j: Int,
    ): UByte = data[indexOf(i, j)]

    @OptIn(ExperimentalUnsignedTypes::class)
    override operator fun set(
        i: Int,
        j: Int,
        value: UByte,
    ) {
        data[indexOf(i, j)] = value
    }
}
