package org.danilopianini.symmetricmatrix

import kotlin.jvm.JvmStatic

/**
 * A symmetric matrix:
 * a matrix where the element at position (i, j) is the same as the element at position (j, i).
 */
interface SymmetricMatrix<T> : Iterable<T> {
    /**
     * The size of the matrix.
     */
    val size: Int

    /**
     * Get the element at position ([i], [j]).
     */
    operator fun get(
        i: Int,
        j: Int,
    ): T

    /**
     * Get elements in the row at index [i].
     */
    fun row(i: Int): List<T>

    /**
     * Get elements in the column at index [j].
     */
    fun column(j: Int): List<T>

    /**
     * Fill the matrix with the same element.
     */
    @Suppress("TooManyFunctions")
    companion object {
        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun <T> of(
            size: Int,
            element: T,
        ): SymmetricMatrix<T> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun <T> of(
            size: Int,
            element: (i: Int, j: Int) -> T,
        ): SymmetricMatrix<T> = MutableSymmetricMatrix.fill(size, element)

        // FUNCTIONS FOR Boolean, Char, Byte, Short Int, Long, Float, Double, UByte, UShort, UInt, ULong

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun ofBoolean(
            size: Int,
            element: Boolean,
        ): SymmetricMatrix<Boolean> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun ofBoolean(
            size: Int,
            element: (i: Int, j: Int) -> Boolean,
        ): SymmetricMatrix<Boolean> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun ofChar(
            size: Int,
            element: Char,
        ): SymmetricMatrix<Char> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun ofChar(
            size: Int,
            element: (i: Int, j: Int) -> Char,
        ): SymmetricMatrix<Char> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun ofByte(
            size: Int,
            element: Byte,
        ): SymmetricMatrix<Byte> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun ofByte(
            size: Int,
            element: (i: Int, j: Int) -> Byte,
        ): SymmetricMatrix<Byte> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun ofShort(
            size: Int,
            element: Short,
        ): SymmetricMatrix<Short> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun ofShort(
            size: Int,
            element: (i: Int, j: Int) -> Short,
        ): SymmetricMatrix<Short> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun ofInt(
            size: Int,
            element: Int,
        ): SymmetricMatrix<Int> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun ofInt(
            size: Int,
            element: (i: Int, j: Int) -> Int,
        ): SymmetricMatrix<Int> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun ofLong(
            size: Int,
            element: Long,
        ): SymmetricMatrix<Long> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun ofLong(
            size: Int,
            element: (i: Int, j: Int) -> Long,
        ): SymmetricMatrix<Long> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun ofFloat(
            size: Int,
            element: Float,
        ): SymmetricMatrix<Float> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun ofFloat(
            size: Int,
            element: (i: Int, j: Int) -> Float,
        ): SymmetricMatrix<Float> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun ofDouble(
            size: Int,
            element: Double,
        ): SymmetricMatrix<Double> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun ofDouble(
            size: Int,
            element: (i: Int, j: Int) -> Double,
        ): SymmetricMatrix<Double> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun ofUByte(
            size: Int,
            element: UByte,
        ): SymmetricMatrix<UByte> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun ofUByte(
            size: Int,
            element: (i: Int, j: Int) -> UByte,
        ): SymmetricMatrix<UByte> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun ofUShort(
            size: Int,
            element: UShort,
        ): SymmetricMatrix<UShort> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun ofUShort(
            size: Int,
            element: (i: Int, j: Int) -> UShort,
        ): SymmetricMatrix<UShort> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun ofUInt(
            size: Int,
            element: UInt,
        ): SymmetricMatrix<UInt> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun ofUInt(
            size: Int,
            element: (i: Int, j: Int) -> UInt,
        ): SymmetricMatrix<UInt> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        @JvmStatic
        fun ofULong(
            size: Int,
            element: ULong,
        ): SymmetricMatrix<ULong> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        @JvmStatic
        fun ofULong(
            size: Int,
            element: (i: Int, j: Int) -> ULong,
        ): SymmetricMatrix<ULong> = MutableSymmetricMatrix.fill(size, element)
    }
}
