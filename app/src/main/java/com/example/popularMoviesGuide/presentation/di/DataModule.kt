package com.example.popularMoviesGuide.presentation.di

import android.content.Context
import com.example.popularMoviesGuide.data.mappers.UserMapper
import com.example.popularMoviesGuide.data.mappers.UserMapperImpl
import com.example.popularMoviesGuide.data.repository.LocalRepositoryImpl
import com.example.popularMoviesGuide.data.repository.RegisteringRepositoryImpl
import com.example.popularMoviesGuide.data.storage.AuthStorage
import com.example.popularMoviesGuide.data.storage.LocalStorage
import com.example.popularMoviesGuide.data.storage.firebaseStorage.FirebaseAuthStorage
import com.example.popularMoviesGuide.data.storage.sharedprefStorage.SharedPrefStorage
import com.example.popularMoviesGuide.domain.repositories.LocalRepository
import com.example.popularMoviesGuide.domain.repositories.RegisteringRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideDataUserMapper(): UserMapper {
        return UserMapperImpl()
    }

    @Provides
    fun provideAuthStorage(): AuthStorage {
        return FirebaseAuthStorage()
    }

    @Provides
    fun provideLocalStorage(context: Context): LocalStorage {
        return SharedPrefStorage(context)
    }

    @Provides
    fun provideRegisteringRepository(
        mapper: UserMapper,
        authStorage: AuthStorage,
        localStorage: LocalStorage
    ): RegisteringRepository {
        return RegisteringRepositoryImpl(mapper, authStorage, localStorage)
    }

    @Provides
    fun provideLocalRepository(): LocalRepository {
        return LocalRepositoryImpl()
    }

}