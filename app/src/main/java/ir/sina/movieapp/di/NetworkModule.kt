package ir.sina.movieapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.sina.movieapp.data.MovieService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @MyFirstLanguage
    fun provideInterceptorEnglish() = Interceptor { chain ->
        val url = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("api_key", "3f2c9c04c927e1283a2d15121fdb299c")
            .addQueryParameter("language", "en-US")
            .build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        chain.proceed(request)
    }
    @Provides
    @Singleton
    @MySecondLanguage
    fun provideInterceptorFrance() = Interceptor { chain ->
        val url = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("api_key", "3f2c9c04c927e1283a2d15121fdb299c")
            .addQueryParameter("language", "fr")
            .build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        chain.proceed(request)
    }

    @Provides
    @Singleton
    fun provideOkHttpLog(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
       @MyFirstLanguage interceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ) = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieService = retrofit.create(MovieService::class.java)

//    inline fun <reified T>provideApi(retrofit: Retrofit): T {
//        return retrofit.create(T::class.java)
//    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MyFirstLanguage
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MySecondLanguage
