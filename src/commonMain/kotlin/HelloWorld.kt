
package org.danilopianini.symmetricmatrix

import kotlin.math.max
import kotlin.math.min

/**
 * Application entrypoint.
 */
class IntSymmetricMatrix(private val size: Int) {

    private val data: IntArray = IntArray(size * (size + 1) / 2)

    operator fun get(i: Int, j: Int): Int {
        validateIndices(i, j)
        return data[indexOf(min(i, j), max(i, j))]
    }

    operator fun set(i: Int, j: Int, value: Int) {
        validateIndices(i, j)
        data[indexOf(min(i, j), max(i,j))] = value
    }

    private fun indexOf(i: Int, j: Int): Int {
        return i * (i + 1) / 2 + j
    }

    fun indicesFromIndex(k: Int): Pair<Int, Int> {
        if (k !in data.indices) {
            throw IndexOutOfBoundsException("Invalid index: $k")
        }
        var i = 0
        while (i * (i + 1) / 2 <= k) {
            i++
        }
        i-- // Adjust back to the correct row
        val j = k - i * (i + 1) / 2
        return Pair(min(i, j), max(i, j))
    }

    private fun validateIndices(i: Int, j: Int) {
        if (i !in 0 until size || j !in 0 until size) {
            throw IndexOutOfBoundsException("Invalid index: ($i, $j)")
        }
    }
}

