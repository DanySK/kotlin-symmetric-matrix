package org.danilopianini.symmetricmatrix

/**
 * Application entrypoint.
 */
class MutableDoubleSymmetricMatrix(
    override val size: Int,
) : AbstractSymmetricMatrix<Double>(),
    MutableSymmetricMatrix<Double> {
    private val data: DoubleArray = DoubleArray(size * (size + 1) / 2)

    override operator fun get(
        i: Int,
        j: Int,
    ): Double = data[indexOf(i, j)]

    override operator fun set(
        i: Int,
        j: Int,
        value: Double,
    ) {
        data[indexOf(i, j)] = value
    }
}
