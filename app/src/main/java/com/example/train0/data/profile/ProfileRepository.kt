package com.example.train0.data.profile

import com.example.train0.feature.profile.domain.ProfileDetail

/**
 * Loads user-facing profile information. Swap implementation for remote data without touching ViewModels.
 */
interface ProfileRepository {
    suspend fun getProfile(userId: String): ProfileDetail
}
