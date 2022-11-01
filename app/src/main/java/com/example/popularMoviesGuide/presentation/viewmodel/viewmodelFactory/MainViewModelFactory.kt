package com.example.popularMoviesGuide.presentation.viewmodel.viewmodelFactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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
import com.example.popularMoviesGuide.domain.usecase.*
import com.example.popularMoviesGuide.presentation.viewmodel.MainViewModel

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val mapper: DataUserMapper = DataUserMapperImpl()
    private val userStorage: UserStorage = FirebaseUserStorage()
    private val authStorage: AuthStorage = FirebaseAuthStorage()
    private val localStorage: LocalStorage = SharedPrefStorage(context)

    private val remoteRepository: RemoteRepository =
        RemoteRepositoryImpl(mapper, userStorage, authStorage)

    private val localRepository: LocalRepository =
        LocalRepositoryImpl(mapper, localStorage)


    private val openRegistrationScreenUseCase = OpenRegistrationScreenUseCase(remoteRepository)
    private val updateUserDataUseCase = UpdateUserDataUseCase(remoteRepository)
    private val saveUserUidUseCase = SaveUserUidUseCase(localRepository)
    private val getUserUidUseCase = GetUserUidUseCase(localRepository)
    private val getEnteringCounterUseCase = GetEnteringCounterUseCase(localRepository)
    private val saveEnteringCounterUseCase = SaveEnteringCounterUseCase(localRepository)


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            openRegistrationScreenUseCase,
            updateUserDataUseCase,
            saveUserUidUseCase,
            getUserUidUseCase,
            getEnteringCounterUseCase,
            saveEnteringCounterUseCase
        ) as T
    }

}