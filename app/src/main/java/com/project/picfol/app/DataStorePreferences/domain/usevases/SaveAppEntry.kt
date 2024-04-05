package com.project.picfol.app.DataStorePreferences.domain.usevases

import com.project.picfol.app.DataStorePreferences.data.manger.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }
}