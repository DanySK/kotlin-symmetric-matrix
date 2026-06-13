package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of booleans.
 */
class MutableBooleanSymmetricMatrix(override val size: Int, init: (Int, Int) -> Boolean) :
    AbstractSymmetricMatrix<Boolean>(),
    MutableSymmetricMatrix<Boolean> {

    private val data: BooleanArray = BooleanArray(internalSize(size))

    constructor(size: Int) : this(size, false)

    constructor(size: Int, value: Boolean) : this(size, { _, _ -> value })

    init {
        fillWithSymmetric(init) { index, value -> data[index] = value }
    }

    override operator fun get(i: Int, j: Int): Boolean = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: Boolean) {
        data[indexOf(i, j)] = value
    }
}
