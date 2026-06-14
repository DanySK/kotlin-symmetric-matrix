package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of doubles.
 */
class MutableDoubleSymmetricMatrix(override val size: Int, init: (Int, Int) -> Double) :
    AbstractSymmetricMatrix<Double>(),
    MutableSymmetricMatrix<Double> {
    private val data: DoubleArray = DoubleArray(internalSize(size))

    constructor(size: Int) : this(size, 0.0)

    constructor(size: Int, value: Double) : this(size, { _, _ -> value })

    init {
        fillWithSymmetric(init) { index, value -> data[index] = value }
    }

    override operator fun get(i: Int, j: Int): Double = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: Double) {
        data[indexOf(i, j)] = value
    }
}
