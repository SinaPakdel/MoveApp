package ir.sina.movieapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.sina.movieapp.data.MovieRepository
import ir.sina.movieapp.data.model.MovieResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private val _movieList = MutableLiveData<MovieResponse>()
    val movieList get() = _movieList

    fun getMovieList(page: Int) = viewModelScope.launch {
        val movieList = repository.getMovieList(page)
        _movieList.postValue(movieList)
    }
}