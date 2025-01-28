package org.danilopianini.symmetricmatrix

import kotlin.math.max
import kotlin.math.min

/**
 * Application entrypoint.
 */
class MutableShortSymmetricMatrix(override val size: Int) : AbstractSymmetricMatrix<Short>(), MutableSymmetricMatrix<Short> {

    private val data: ShortArray = ShortArray(size * (size + 1) / 2)

    override operator fun get(i: Int, j: Int): Short = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: Short) {
        data[indexOf(i, j)] = value
    }
}
