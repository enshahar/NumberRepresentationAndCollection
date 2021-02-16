package com.enshahar.nrac

sealed class List<out T> {
    fun append(l: List<@UnsafeVariance T>): List<T> {
        return when (this) {
            is CONS -> CONS(head, tail.append(l))
            is NIL  -> l
        }
    }
}
object NIL: List<Nothing>()
class CONS<T>(val head:T, val tail:List<T>): List<T>() {
    override fun toString(): String = "CONS[${super.toString()}](${head},${tail})"
}

fun main() {
    val nil = NIL
    val l123 = CONS(1, CONS(2, CONS(3, NIL)))
    val l456 = CONS(1, CONS(2, CONS(3, NIL)))

    println(l123)
    println(l456)
}