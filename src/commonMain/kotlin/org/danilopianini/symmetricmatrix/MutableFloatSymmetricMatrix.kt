package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of floats.
 */
class MutableFloatSymmetricMatrix(
    override val size: Int,
) : AbstractSymmetricMatrix<Float>(),
    MutableSymmetricMatrix<Float> {
    private val data: FloatArray = FloatArray(size * (size + 1) / 2)

    override operator fun get(
        i: Int,
        j: Int,
    ): Float = data[indexOf(i, j)]

    override operator fun set(
        i: Int,
        j: Int,
        value: Float,
    ) {
        data[indexOf(i, j)] = value
    }
}
