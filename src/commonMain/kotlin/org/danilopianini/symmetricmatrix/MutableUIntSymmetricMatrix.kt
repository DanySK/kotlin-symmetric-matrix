package org.danilopianini.symmetricmatrix

/**
 *  A mutable symmetric matrix of unsigned integers.
 */
@OptIn(ExperimentalUnsignedTypes::class)
class MutableUIntSymmetricMatrix(override val size: Int, init: (Int, Int) -> UInt) :
    AbstractSymmetricMatrix<UInt>(),
    MutableSymmetricMatrix<UInt> {
    private val data: UIntArray = UIntArray(internalSize(size))

    constructor(size: Int) : this(size, 0u)

    constructor(size: Int, value: UInt) : this(size, { _, _ -> value })

    init {
        fillWithSymmetric(init) { index, value -> data[index] = value }
    }

    override operator fun get(i: Int, j: Int): UInt = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: UInt) {
        data[indexOf(i, j)] = value
    }
}
