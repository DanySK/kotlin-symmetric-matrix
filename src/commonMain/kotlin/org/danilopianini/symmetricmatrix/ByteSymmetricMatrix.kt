package org.danilopianini.symmetricmatrix

import kotlin.math.max
import kotlin.math.min

/**
 * Application entrypoint.
 */
class MutableByteSymmetricMatrix(override val size: Int) : AbstractSymmetricMatrix<Byte>(), MutableSymmetricMatrix<Byte> {

    private val data: ByteArray = ByteArray(size * (size + 1) / 2)

    override operator fun get(i: Int, j: Int): Byte = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: Byte) {
        data[indexOf(i, j)] = value
    }
}
