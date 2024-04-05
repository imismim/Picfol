package com.project.picfol.app.di

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import com.project.picfol.app.DataStorePreferences.data.manger.LocalUserManger
import com.project.picfol.app.DataStorePreferences.domain.manger.LocalUserMangerImpl
import com.project.picfol.app.DataStorePreferences.domain.usevases.AppEntryUseCases
import com.project.picfol.app.DataStorePreferences.domain.usevases.ReadAppEntry
import com.project.picfol.app.DataStorePreferences.domain.usevases.SaveAppEntry
import com.project.picfol.app.SignUpSigIn.data.AuthRepository
import com.project.picfol.app.SignUpSigIn.data.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesRepositoryImpl(firebaseAuth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth)
    }


    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun providesAppEntryUseCases(
        localUserManger: LocalUserManger
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

}