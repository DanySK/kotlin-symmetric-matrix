# Kotlin symmetric matrices

This project provides a simple implementation of symmetric matrices in Kotlin. 
The implementation is based on a single array that stores the elements of the matrix in a compact form. 
The matrix is assumed to be symmetric, 
so only the elements in the upper triangular part of the matrix are stored. 
The elements are stored in row-major order.

The implementation provides a class `SymmetricMatrix` that can be used to create symmetric matrices of different types. 
The class provides methods to access and, if `MutableSymmetricMatrix` is used, modify the elements of the matrix.

Provided types:
* `Boolean`
* `Byte`
* `Double`
* `Float`
* `Int`
* `Long`
* `Short`
* `UByte`
* `UInt`
* `ULong`
* `UShort`
