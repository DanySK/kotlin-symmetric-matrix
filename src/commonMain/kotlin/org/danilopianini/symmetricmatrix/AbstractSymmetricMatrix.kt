package org.danilopianini.symmetricmatrix

import kotlin.math.max
import kotlin.math.min

/**
 * Indexing functions for symmetric matrices.
 */
abstract class AbstractSymmetricMatrix<T> : SymmetricMatrix<T> {
    protected val internalSize: Int get() = symmetricMatrixInternalSize(size)

    protected fun fillWithSymmetric(function: (i: Int, j: Int) -> T, set: (index: Int, value: T) -> Unit) {
        for (i in 0 until size) {
            set(indexOf(i, i), function(i, i))
            for (j in 0 until i) {
                val value = function(i, j)
                val opposite = function(j, i)
                val equal = value == opposite ||
                    (value is Float && opposite is Float && value.isNaN() && opposite.isNaN()) ||
                    (value is Double && opposite is Double && value.isNaN() && opposite.isNaN())
                require(equal) {
                    "Invalid symmetric function: element at ($i, $j) is $value, but element at ($j, $i) is $opposite"
                }
                set(indexOf(i, j), value)
            }
        }
    }

    /**
     * Given an [index] in the internal representation of the matrix, return the corresponding indices.
     */
    protected fun indicesFromIndex(index: Int): Pair<Int, Int> = symmetricMatrixIndicesFromIndex(size, index)

    /**
     * Given two indices ([i], [j]), return the corresponding index in the internal representation of the matrix.
     */
    protected fun indexOf(i: Int, j: Int): Int = symmetricMatrixIndexOf(size, i, j)

    override fun row(i: Int): List<T> = (0 until size).map { j -> get(i, j) }

    override fun column(j: Int): List<T> = (0 until size).map { i -> get(i, j) }

    override fun toString(): String = "SymmetricMatrix($size, $size)"

    override fun iterator(): Iterator<T> = (0 until size).asSequence().flatMap { row(it).asSequence() }.iterator()

    @PublishedApi
    internal companion object {

        @PublishedApi
        internal fun internalSize(size: Int): Int = symmetricMatrixInternalSize(size)

        fun symmetricMatrixInternalSize(size: Int): Int {
            require(size >= 0) { "Invalid matrix size: $size" }
            return symmetricMatrixTriangularNumber(size)
        }

        @PublishedApi
        internal fun symmetricMatrixIndicesFromIndex(size: Int, index: Int): Pair<Int, Int> {
            val internalSize = symmetricMatrixInternalSize(size)
            require(index in 0 until internalSize) {
                "Invalid index: $index, not in [0, $internalSize)"
            }
            var i = 0
            while (symmetricMatrixTriangularNumber(i) <= index) {
                i++
            }
            i-- // Adjust back to the correct row
            val j = index - symmetricMatrixTriangularNumber(i)
            return Pair(min(i, j), max(i, j))
        }

        @PublishedApi
        internal fun symmetricMatrixIndexOf(size: Int, i: Int, j: Int): Int = max(i, j).let { max ->
            require(max in 0 until size) {
                "Invalid index: ($i, $j), max($i, $j) not in [0, $size)"
            }
            symmetricMatrixTriangularNumber(max) +
                min(i, j).also { min ->
                    require(min in 0 until size) {
                        "Invalid index: ($i, $j), min($i, $j) not in [0, $size)"
                    }
                }
        }

        @PublishedApi
        internal fun symmetricMatrixTriangularNumber(size: Int): Int {
            val result = size.toLong() * (size.toLong() + 1L) / 2L
            require(result <= Int.MAX_VALUE) { "Triangular number too large for index: $size" }
            return result.toInt()
        }
    }
}
