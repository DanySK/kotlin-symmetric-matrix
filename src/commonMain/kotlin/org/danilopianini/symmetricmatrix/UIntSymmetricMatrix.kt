package org.danilopianini.symmetricmatrix

import kotlin.math.max
import kotlin.math.min

/**
 * Application entrypoint.
 */
class MutableUIntSymmetricMatrix(override val size: Int) : AbstractSymmetricMatrix<UInt>(), MutableSymmetricMatrix<UInt> {

    @OptIn(ExperimentalUnsignedTypes::class)
    private val data: UIntArray = UIntArray(size * (size + 1) / 2)

    @OptIn(ExperimentalUnsignedTypes::class)
    override operator fun get(i: Int, j: Int): UInt = data[indexOf(i, j)]

    @OptIn(ExperimentalUnsignedTypes::class)
    override operator fun set(i: Int, j: Int, value: UInt) {
        data[indexOf(i, j)] = value
    }
}
