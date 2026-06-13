package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of unsigned shorts.
 */
@OptIn(ExperimentalUnsignedTypes::class)
class MutableUShortSymmetricMatrix(override val size: Int, init: (Int, Int) -> UShort) :
    AbstractSymmetricMatrix<UShort>(),
    MutableSymmetricMatrix<UShort> {
    private val data: UShortArray = UShortArray(internalSize(size))

    constructor(size: Int) : this(size, 0.toUShort())

    constructor(size: Int, value: UShort) : this(size, { _, _ -> value })

    init {
        fillWithSymmetric(init) { index, value -> data[index] = value }
    }

    override operator fun get(i: Int, j: Int): UShort = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: UShort) {
        data[indexOf(i, j)] = value
    }
}
