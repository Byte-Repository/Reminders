package com.example.reminders.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Reminder(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
)

data class Day(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
)
