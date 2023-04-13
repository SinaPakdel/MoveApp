package ir.sina.movieapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ir.sina.movieapp.R
import ir.sina.movieapp.data.TestInterface
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var gameManager: GameManager

    @Inject
    lateinit var testInterface: TestInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testInterface.A()
    }
}