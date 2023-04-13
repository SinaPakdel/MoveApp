package ir.sina.movieapp.data

import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieService: MovieService) {

    suspend fun getMovieList(page:Int) = movieService.getPopularMovies(page)
}