package org.danilopianini.symmetricmatrix

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
    companion object {
        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun <T> of(
            size: Int,
            element: T,
        ): SymmetricMatrix<T> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun <T> of(
            size: Int,
            element: (i: Int, j: Int) -> T,
        ): SymmetricMatrix<T> = MutableSymmetricMatrix.fill(size, element)

        // FUNCTIONS FOR Boolean, Char, Byte, Short Int, Long, Float, Double, UByte, UShort, UInt, ULong

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun ofBoolean(
            size: Int,
            element: Boolean,
        ): SymmetricMatrix<Boolean> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun ofBoolean(
            size: Int,
            element: (i: Int, j: Int) -> Boolean,
        ): SymmetricMatrix<Boolean> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun ofChar(
            size: Int,
            element: Char,
        ): SymmetricMatrix<Char> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun ofChar(
            size: Int,
            element: (i: Int, j: Int) -> Char,
        ): SymmetricMatrix<Char> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun ofByte(
            size: Int,
            element: Byte,
        ): SymmetricMatrix<Byte> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun ofByte(
            size: Int,
            element: (i: Int, j: Int) -> Byte,
        ): SymmetricMatrix<Byte> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun ofShort(
            size: Int,
            element: Short,
        ): SymmetricMatrix<Short> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun ofShort(
            size: Int,
            element: (i: Int, j: Int) -> Short,
        ): SymmetricMatrix<Short> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun ofInt(
            size: Int,
            element: Int,
        ): SymmetricMatrix<Int> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun ofInt(
            size: Int,
            element: (i: Int, j: Int) -> Int,
        ): SymmetricMatrix<Int> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun ofLong(
            size: Int,
            element: Long,
        ): SymmetricMatrix<Long> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun ofLong(
            size: Int,
            element: (i: Int, j: Int) -> Long,
        ): SymmetricMatrix<Long> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun ofFloat(
            size: Int,
            element: Float,
        ): SymmetricMatrix<Float> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun ofFloat(
            size: Int,
            element: (i: Int, j: Int) -> Float,
        ): SymmetricMatrix<Float> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun ofDouble(
            size: Int,
            element: Double,
        ): SymmetricMatrix<Double> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun ofDouble(
            size: Int,
            element: (i: Int, j: Int) -> Double,
        ): SymmetricMatrix<Double> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun ofUByte(
            size: Int,
            element: UByte,
        ): SymmetricMatrix<UByte> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun ofUByte(
            size: Int,
            element: (i: Int, j: Int) -> UByte,
        ): SymmetricMatrix<UByte> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun ofUShort(
            size: Int,
            element: UShort,
        ): SymmetricMatrix<UShort> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun ofUShort(
            size: Int,
            element: (i: Int, j: Int) -> UShort,
        ): SymmetricMatrix<UShort> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun ofUInt(
            size: Int,
            element: UInt,
        ): SymmetricMatrix<UInt> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun ofUInt(
            size: Int,
            element: (i: Int, j: Int) -> UInt,
        ): SymmetricMatrix<UInt> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] with the same [element].
         */
        fun ofULong(
            size: Int,
            element: ULong,
        ): SymmetricMatrix<ULong> = MutableSymmetricMatrix.fill(size, element)

        /**
         * Create a symmetric matrix of [size] computing each element based on the provided function [element].
         */
        fun ofULong(
            size: Int,
            element: (i: Int, j: Int) -> ULong,
        ): SymmetricMatrix<ULong> = MutableSymmetricMatrix.fill(size, element)
    }
}
