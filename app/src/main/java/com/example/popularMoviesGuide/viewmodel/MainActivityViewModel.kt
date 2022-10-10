package com.example.popularMoviesGuide.viewmodel

//import com.example.popularMoviesGuide.data.User
import com.example.popularMoviesGuide.data.repository.UserDataRepositoryImpl
import com.example.popularMoviesGuide.data.storage.UserStorage
import com.example.popularMoviesGuide.data.storage.firebasestorage.FirebaseUserStorage
import com.example.popularMoviesGuide.domain.models.User
import com.example.popularMoviesGuide.domain.repositories.UserDataRepository
import com.example.popularMoviesGuide.domain.usecase.UpdateUserDataUseCase
import com.example.popularMoviesGuide.model.repository.FirebaseRepository
import com.example.popularMoviesGuide.model.repository.FirebaseRepositoryImpl

class MainActivityViewModel {
    //private val firebaseRepository : FirebaseRepository = FirebaseRepositoryImpl()

    private val userDataRepository: UserDataRepository = UserDataRepositoryImpl()
    private val updateUserDataUseCase = UpdateUserDataUseCase(userDataRepository)


//    fun updateUserData(firebaseUser: User, uId: String) {
//        firebaseRepository.updateUserData(firebaseUser, uId)
//    }

    fun updateUserData(firebaseUser: User) {
        updateUserDataUseCase.updateUserData(firebaseUser)
    }

}