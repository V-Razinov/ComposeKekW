package ru.mediasoft.core_navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mediasoft.core_navigation.router.Router
import ru.mediasoft.core_navigation.router.RouterImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class CoreNavigationModule {

    @Binds
    abstract fun bindRouter(router: RouterImpl) : Router
}