package com.appsnicolas.huilatravel.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appsnicolas.huilatravel.route.Route

object FavoritesRepository {
    private val _favorites = MutableLiveData<List<Route>>(emptyList())
    val favorites: LiveData<List<Route>> = _favorites

    fun add(route: Route) {
        val current = _favorites.value ?: emptyList()
        if (current.none { it.id == route.id }) {
            _favorites.value = current + route
        }
    }

    fun remove(route: Route) {
        val current = _favorites.value ?: emptyList()
        _favorites.value = current.filterNot { it.id == route.id }
    }

    fun isFavorite(route: Route): Boolean {
        val current = _favorites.value ?: emptyList()
        return current.any { it.id == route.id }
    }
}
