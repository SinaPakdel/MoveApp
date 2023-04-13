package ir.sina.movieapp.data

import ir.sina.movieapp.data.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


//https://api.themoviedb.org/3/movie/popular?api_key=3f2c9c04c927e1283a2d15121fdb299c&language=en-US&page=1
interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ): MovieResponse
}