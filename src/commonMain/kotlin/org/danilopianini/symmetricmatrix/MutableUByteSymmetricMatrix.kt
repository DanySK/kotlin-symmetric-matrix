package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of unsigned bytes.
 */
@OptIn(ExperimentalUnsignedTypes::class)
class MutableUByteSymmetricMatrix(override val size: Int, init: (Int, Int) -> UByte) :
    AbstractSymmetricMatrix<UByte>(),
    MutableSymmetricMatrix<UByte> {
    private val data: UByteArray = UByteArray(internalSize(size))

    constructor(size: Int) : this(size, 0.toUByte())

    constructor(size: Int, value: UByte) : this(size, { _, _ -> value })

    init {
        fillWithSymmetric(init) { index, value -> data[index] = value }
    }

    override operator fun get(i: Int, j: Int): UByte = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: UByte) {
        data[indexOf(i, j)] = value
    }
}
