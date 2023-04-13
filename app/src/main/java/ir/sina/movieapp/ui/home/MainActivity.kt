package ir.sina.movieapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ir.sina.movieapp.R
import ir.sina.movieapp.data.TestInterface
import ir.sina.movieapp.di.EhsanName
import ir.sina.movieapp.di.MohsenName
import javax.inject.Inject
import javax.inject.Named


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var gameManager: GameManager

    @Inject
    lateinit var testInterface: TestInterface

    @Inject
    @MohsenName
    lateinit var mohsenName: String

    @Inject
    @EhsanName
    lateinit var ehsanName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testInterface.A()
        Log.e("MainActivity", "onCreate: $mohsenName", )
        Log.e("MainActivity", "onCreate: $ehsanName", )
    }
}