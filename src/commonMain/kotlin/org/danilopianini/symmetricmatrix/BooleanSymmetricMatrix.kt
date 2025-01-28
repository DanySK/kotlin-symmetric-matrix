package org.danilopianini.symmetricmatrix

import kotlin.math.max
import kotlin.math.min

/**
 * Application entrypoint.
 */
class MutableBooleanSymmetricMatrix(override val size: Int) : AbstractSymmetricMatrix<Boolean>(), MutableSymmetricMatrix<Boolean> {

    private val data: BooleanArray = BooleanArray(size * (size + 1) / 2)

    override operator fun get(i: Int, j: Int): Boolean = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: Boolean) {
        data[indexOf(i, j)] = value
    }
}