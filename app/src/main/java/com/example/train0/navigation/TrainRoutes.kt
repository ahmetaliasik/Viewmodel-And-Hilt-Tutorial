package com.example.train0.navigation

/**
 * Central route contracts. Keeps NavHost free of magic strings and scales with more features.
 */
object TrainRoutes {
    const val COUNTER = "counter"
    const val SECOND_PATTERN = "second/{${Args.COUNT}}"
    const val SOMETHING = "something"
    const val PROFILE_PATTERN = "profile/{${Args.USER_ID}}"
    const val HOME = "home"
    const val HEARTH_BEAT = "hearth_beat"

    object Args {
        const val COUNT = "count"
        const val USER_ID = "userId"
    }

    fun second(count: Int): String = "second/$count"

    fun profile(userId: String): String = "profile/$userId"
}
