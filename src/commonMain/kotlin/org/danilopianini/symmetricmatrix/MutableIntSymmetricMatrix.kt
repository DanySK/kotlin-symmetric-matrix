package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of integers.
 */
class MutableIntSymmetricMatrix(override val size: Int, init: (Int, Int) -> Int) :
    AbstractSymmetricMatrix<Int>(),
    MutableSymmetricMatrix<Int> {
    private val data: IntArray = IntArray(internalSize(size))

    constructor(size: Int) : this(size, 0)

    constructor(size: Int, value: Int) : this(size, { _, _ -> value })

    init {
        fillWithSymmetric(init) { index, value -> data[index] = value }
    }

    override operator fun get(i: Int, j: Int): Int = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: Int) {
        data[indexOf(i, j)] = value
    }
}
