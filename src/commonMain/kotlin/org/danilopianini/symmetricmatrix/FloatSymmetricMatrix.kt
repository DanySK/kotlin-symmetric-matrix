package org.danilopianini.symmetricmatrix

import kotlin.math.max
import kotlin.math.min

/**
 * Application entrypoint.
 */
class MutableFloatSymmetricMatrix(override val size: Int) : AbstractSymmetricMatrix<Float>(), MutableSymmetricMatrix<Float> {

    private val data: FloatArray = FloatArray(size * (size + 1) / 2)

    override operator fun get(i: Int, j: Int): Float = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: Float) {
        data[indexOf(i, j)] = value
    }
}
