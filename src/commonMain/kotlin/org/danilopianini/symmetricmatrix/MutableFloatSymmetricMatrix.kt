package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of floats.
 */
class MutableFloatSymmetricMatrix(override val size: Int, init: (Int, Int) -> Float) :
    AbstractSymmetricMatrix<Float>(),
    MutableSymmetricMatrix<Float> {
    private val data: FloatArray = FloatArray(internalSize(size))

    constructor(size: Int) : this(size, 0f)

    constructor(size: Int, value: Float) : this(size, { _, _ -> value })

    init {
        fillWithSymmetric(init) { index, value -> data[index] = value }
    }

    override operator fun get(i: Int, j: Int): Float = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: Float) {
        data[indexOf(i, j)] = value
    }
}
