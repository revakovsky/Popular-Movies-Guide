package com.example.popularMoviesGuide.presentation.di

import android.content.Context
import com.example.popularMoviesGuide.data.mappers.DataUserMapper
import com.example.popularMoviesGuide.data.mappers.DataUserMapperImpl
import com.example.popularMoviesGuide.data.repository.LocalRepositoryImpl
import com.example.popularMoviesGuide.data.repository.RemoteRepositoryImpl
import com.example.popularMoviesGuide.data.storage.AuthStorage
import com.example.popularMoviesGuide.data.storage.LocalStorage
import com.example.popularMoviesGuide.data.storage.UserStorage
import com.example.popularMoviesGuide.data.storage.firebaseStorage.FirebaseAuthStorage
import com.example.popularMoviesGuide.data.storage.firebaseStorage.FirebaseUserStorage
import com.example.popularMoviesGuide.data.storage.sharedprefStorage.SharedPrefStorage
import com.example.popularMoviesGuide.domain.repositories.LocalRepository
import com.example.popularMoviesGuide.domain.repositories.RemoteRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideDataUserMapper(): DataUserMapper {
        return DataUserMapperImpl()
    }

    @Provides
    fun provideUserStorage(): UserStorage {
        return FirebaseUserStorage()
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
    fun provideRemoteRepository(
        mapper: DataUserMapper,
        userStorage: UserStorage,
        authStorage: AuthStorage
    ): RemoteRepository {
        return RemoteRepositoryImpl(mapper, userStorage, authStorage)
    }

    @Provides
    fun provideLocalRepository(
        mapper: DataUserMapper,
        localStorage: LocalStorage
    ): LocalRepository {
        return LocalRepositoryImpl(mapper, localStorage)
    }

}