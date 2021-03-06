//PARAM_TYPES: C, AImpl, A
//PARAM_DESCRIPTOR: value-parameter val c: C defined in foo
trait A {
    fun doA()
}

open class AImpl: A {
    override fun doA() {
        throw UnsupportedOperationException()
    }
}

trait B {
    fun doB()
}

class C: AImpl(), B {
    override fun doA() {
        throw UnsupportedOperationException()
    }

    override fun doB() {
        throw UnsupportedOperationException()
    }

    fun doC() {
        throw UnsupportedOperationException()
    }
}

// SIBLING:
fun foo(c: C) {
    <selection>c.doA()</selection>
    c.doB()
    c.doC()
}