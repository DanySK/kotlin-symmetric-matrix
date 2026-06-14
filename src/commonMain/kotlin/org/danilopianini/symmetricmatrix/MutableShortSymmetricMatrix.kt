package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of shorts.
 */
class MutableShortSymmetricMatrix(override val size: Int, init: (Int, Int) -> Short) :
    AbstractSymmetricMatrix<Short>(),
    MutableSymmetricMatrix<Short> {
    private val data: ShortArray = ShortArray(internalSize(size))

    constructor(size: Int) : this(size, 0)

    constructor(size: Int, value: Short) : this(size, { _, _ -> value })

    init {
        fillWithSymmetric(init) { index, value -> data[index] = value }
    }

    override operator fun get(i: Int, j: Int): Short = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: Short) {
        data[indexOf(i, j)] = value
    }
}
