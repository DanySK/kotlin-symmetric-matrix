package org.danilopianini.symmetricmatrix

/**
 * Application entrypoint.
 */
class MutableLongSymmetricMatrix(
    override val size: Int,
) : AbstractSymmetricMatrix<Long>(),
    MutableSymmetricMatrix<Long> {
    private val data: LongArray = LongArray(size * (size + 1) / 2)

    override operator fun get(
        i: Int,
        j: Int,
    ): Long = data[indexOf(i, j)]

    override operator fun set(
        i: Int,
        j: Int,
        value: Long,
    ) {
        data[indexOf(i, j)] = value
    }
}
