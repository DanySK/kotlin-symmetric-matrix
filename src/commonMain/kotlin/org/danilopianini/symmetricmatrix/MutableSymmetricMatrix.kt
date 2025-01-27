package org.danilopianini.symmetricmatrix

interface MutableSymmetricMatrix<T> : SymmetricMatrix<T> {

    operator fun set(i: Int, j: Int, value: T)

    companion object {

        fun <T> fill(size: Int, element: T) = fill(size) { _, _ -> element }

        inline fun <T> fill(size: Int, crossinline element:(i: Int, j: Int) -> T): MutableSymmetricMatrix<T> =
            object : AbstractSymmetricMatrix<T>(), MutableSymmetricMatrix<T> {

                override val size: Int = size

                private val data: MutableList<T> = MutableList(size * (size + 1) / 2) { i ->
                    indicesFromIndex(size, i).let { (i, j) -> element(i, j) }
                }

                override fun get(i: Int, j: Int): T {
                    return data[indexOf(i, j)]
                }

                override fun set(i: Int, j: Int, value: T) {
                    data[indexOf(i, j)] = value
                }
            }
    }
}
