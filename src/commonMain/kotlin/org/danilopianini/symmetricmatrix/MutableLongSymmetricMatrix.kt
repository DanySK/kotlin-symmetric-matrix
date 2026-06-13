package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of longs.
 */
class MutableLongSymmetricMatrix(override val size: Int, init: (Int, Int) -> Long) :
    AbstractSymmetricMatrix<Long>(),
    MutableSymmetricMatrix<Long> {
    private val data: LongArray = LongArray(internalSize(size))

    constructor(size: Int) : this(size, 0L)

    constructor(size: Int, value: Long) : this(size, { _, _ -> value })

    init {
        fillWithSymmetric(init) { index, value -> data[index] = value }
    }

    override operator fun get(i: Int, j: Int): Long = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: Long) {
        data[indexOf(i, j)] = value
    }
}
