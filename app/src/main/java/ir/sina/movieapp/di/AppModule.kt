package ir.sina.movieapp.di

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.sina.movieapp.data.TestInterface
import ir.sina.movieapp.data.TestInterfaceImpl
import ir.sina.movieapp.ui.home.GameManager

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideGameManager() = GameManager()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class CustomModule {

    @Binds
    abstract fun provideTestInterfaceImpl(
        testInterfaceImpl: TestInterfaceImpl
    ): TestInterface
}
