package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of bytes.
 */
class MutableByteSymmetricMatrix(override val size: Int, init: (Int, Int) -> Byte) :
    AbstractSymmetricMatrix<Byte>(),
    MutableSymmetricMatrix<Byte> {
    private val data: ByteArray = ByteArray(internalSize(size))

    constructor(size: Int) : this(size, 0)

    constructor(size: Int, value: Byte) : this(size, { _, _ -> value })

    init {
        fillWithSymmetric(init) { index, value -> data[index] = value }
    }

    override operator fun get(i: Int, j: Int): Byte = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: Byte) {
        data[indexOf(i, j)] = value
    }
}
