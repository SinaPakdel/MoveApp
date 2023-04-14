package ir.sina.movieapp.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieService: MovieService) {

    //Single source of truth --->  withContext(Dispatchers.IO){}
    suspend fun getMovieList(page: Int) = withContext(Dispatchers.IO) {
        movieService.getPopularMovies(page)
    }
}