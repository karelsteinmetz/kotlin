package foo

// NOTE THIS FILE IS AUTO-GENERATED by the generateTestDataForReservedWords.kt. DO NOT EDIT!

class TestClass {
    fun `try`() { `try`() }

    fun test() {
        testNotRenamed("try", { ::`try` })
    }
}

fun box(): String {
    TestClass().test()

    return "OK"
}