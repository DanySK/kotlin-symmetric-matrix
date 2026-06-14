package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of unsigned longs.
 */
@OptIn(ExperimentalUnsignedTypes::class)
class MutableULongSymmetricMatrix(override val size: Int, init: (Int, Int) -> ULong) :
    AbstractSymmetricMatrix<ULong>(),
    MutableSymmetricMatrix<ULong> {
    private val data: ULongArray = ULongArray(internalSize(size))

    constructor(size: Int) : this(size, 0uL)

    constructor(size: Int, value: ULong) : this(size, { _, _ -> value })

    init {
        fillWithSymmetric(init) { index, value -> data[index] = value }
    }

    override operator fun get(i: Int, j: Int): ULong = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: ULong) {
        data[indexOf(i, j)] = value
    }
}
