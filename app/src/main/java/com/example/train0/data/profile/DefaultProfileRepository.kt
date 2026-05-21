package com.example.train0.data.profile

import com.example.train0.feature.profile.domain.ChildSummary
import com.example.train0.feature.profile.domain.ProfileDetail
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultProfileRepository @Inject constructor() : ProfileRepository {

    override suspend fun getProfile(userId: String): ProfileDetail =
        ProfileDetail(
            userId = userId,
            displayName = "Brandon",
            ageYears = 24,
            child = ChildSummary(name = "Jack", ageYears = 43),
        )
}
