package ir.sina.movieapp.di

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import ir.sina.movieapp.data.TestInterface
import ir.sina.movieapp.data.TestInterfaceImpl
import ir.sina.movieapp.ui.home.GameManager
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGameManager() = GameManager()

    @Provides
    @MohsenName
    fun provideMohsenName() :String= "Mohesn"
    @Provides
    @EhsanName
    fun provideEhsanName() :String= "Ehsan"

}

@Module
@InstallIn(SingletonComponent::class)
abstract class CustomModule {

    @Binds
    abstract fun provideTestInterfaceImpl(
        testInterfaceImpl: TestInterfaceImpl
    ): TestInterface
}


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MohsenName
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EhsanName