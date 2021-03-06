// !CHECK_TYPE

import kotlin.reflect.KMemberProperty

class C {
    val baz: Int = 12
}

fun Int.baz() {}

fun test() {
    C::baz checkType { it : _<KMemberProperty<C, Int>>}
}