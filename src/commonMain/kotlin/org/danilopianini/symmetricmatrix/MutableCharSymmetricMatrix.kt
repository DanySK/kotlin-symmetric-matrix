package org.danilopianini.symmetricmatrix

/**
 * A mutable symmetric matrix of chars.
 */
class MutableCharSymmetricMatrix(override val size: Int, init: (Int, Int) -> Char) :
    AbstractSymmetricMatrix<Char>(),
    MutableSymmetricMatrix<Char> {
    private val data: CharArray = CharArray(internalSize(size))

    constructor(size: Int) : this(size, '\u0000')

    constructor(size: Int, value: Char) : this(size, { _, _ -> value })

    init {
        fillWithSymmetric(init) { index, value -> data[index] = value }
    }

    override operator fun get(i: Int, j: Int): Char = data[indexOf(i, j)]

    override operator fun set(i: Int, j: Int, value: Char) {
        data[indexOf(i, j)] = value
    }
}
