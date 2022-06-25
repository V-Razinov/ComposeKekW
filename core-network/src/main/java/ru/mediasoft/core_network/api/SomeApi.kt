package ru.mediasoft.core_network.api

import retrofit2.http.GET

interface SomeApi {
    @GET("")
    suspend fun doSomeThing(): Unit
}