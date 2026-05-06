package com.example.train0.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

data class UserProfile (
    val name : String?, val age : Int?,
    val child : Child?
)
data class Child(
    val name : String?,
    val age : Int?,
)


@Composable
fun ProfileScreen(modifier: Modifier = Modifier, userId: String ) {
    val userProfile = UserProfile(
        name = "Brandon", age = 24,
        child = Child(name = "Jack", age = 43)
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = userProfile.name ?: "")
        Text(text = (userProfile.age ?: 0) .toString())
        Text(text = (userProfile.child ?: Child("",0)) .name ?: "")
        Text(text = (userProfile.child ?: Child("", 0)).age.toString())
        Text(text = "id : $userId")
    }
}