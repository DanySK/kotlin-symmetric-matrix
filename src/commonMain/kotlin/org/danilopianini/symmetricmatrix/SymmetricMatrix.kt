package org.danilopianini.symmetricmatrix

import kotlin.math.max
import kotlin.math.min

interface SymmetricMatrix<T> : Iterable<T> {

    val size: Int

    operator fun get(i: Int, j: Int): T

    fun row(i: Int): List<T>

    fun column(j: Int): List<T>

    companion object {

        fun <T> fill(size: Int, element: T): SymmetricMatrix<T> = MutableSymmetricMatrix.fill(size, element)

        fun <T> fill(size: Int, element: (i: Int, j: Int) -> T): SymmetricMatrix<T> =
            MutableSymmetricMatrix.fill(size, element)

    }
}
