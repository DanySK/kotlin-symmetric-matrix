package org.danilopianini.symmetricmatrix

import kotlin.math.max
import kotlin.math.min

/**
 *
 */
abstract class AbstractSymmetricMatrix<T> : SymmetricMatrix<T> {
    protected val internalSize = size * (size + 1) / 2

    protected fun indicesFromIndex(
        size: Int,
        index: Int,
    ): Pair<Int, Int> {
        require(index in 0 until internalSize) {
            "Invalid index: $index, not in [0, $internalSize)"
        }
        var i = 0
        while (i * (i + 1) / 2 <= index) {
            i++
        }
        i-- // Adjust back to the correct row
        val j = index - i * (i + 1) / 2
        return Pair(min(i, j), max(i, j))
    }

    protected fun indexOf(
        i: Int,
        j: Int,
    ): Int =
        min(i, j).let { min ->
            require(min in 0 until size) {
                "Invalid index: ($i, $j), min($i, $j) not in [0, $size)"
            }
            min * (min + 1) / 2 +
                max(i, j).also { max ->
                    require(max in 0 until size) {
                        "Invalid index: ($i, $j), max($i, $j) not in [0, $size)"
                    }
                }
        }

    override fun row(i: Int): List<T> = (0 until size).map { j -> get(i, j) }

    override fun column(j: Int): List<T> = (0 until size).map { i -> get(i, j) }

    override fun toString(): String = "SymmetricMatrix($size, $size)"

    override fun iterator(): Iterator<T> = (0 until size).asSequence().flatMap { row(it).asSequence() }.iterator()
}
