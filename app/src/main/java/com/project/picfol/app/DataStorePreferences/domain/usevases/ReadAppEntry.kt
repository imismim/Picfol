package com.project.picfol.app.DataStorePreferences.domain.usevases

import com.project.picfol.app.DataStorePreferences.data.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManger
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }
}