package ir.sina.movieapp.data

import android.util.Log
import javax.inject.Inject


interface TestInterface {
    fun A()
    fun B()
}

class TestInterfaceImpl @Inject constructor() : TestInterface {
    override fun A() {
        Log.e("testInterfaceImpl", "A: ", )
    }
    override fun B() {
        Log.e("testInterfaceImpl", "B: ", )
    }
}