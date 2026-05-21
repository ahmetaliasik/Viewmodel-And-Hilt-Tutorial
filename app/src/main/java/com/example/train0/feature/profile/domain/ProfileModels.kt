package com.example.train0.feature.profile.domain

data class ChildSummary(
    val name: String,
    val ageYears: Int,
)

data class ProfileDetail(
    val userId: String,
    val displayName: String,
    val ageYears: Int,
    val child: ChildSummary,
)
