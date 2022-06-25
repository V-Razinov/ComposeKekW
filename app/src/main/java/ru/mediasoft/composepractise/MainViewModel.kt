package ru.mediasoft.composepractise

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.mediasoft.core_navigation.router.Router
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val router: Router
) : ViewModel(), Router by router {
}