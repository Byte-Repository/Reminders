package com.example.reminders.data

import com.example.reminders.R
import com.example.reminders.model.Day
import com.example.reminders.model.Reminder

object DataSource {
    val reminders = listOf(
        Reminder(R.string.reminder2, R.drawable.exercise),
        Reminder(R.string.reminder7, R.drawable.friends),
        Reminder(R.string.reminder1, R.drawable.medication),
        Reminder(R.string.reminder4, R.drawable.meditate),
        Reminder(R.string.reminder8, R.drawable.party),
        Reminder(R.string.reminder6, R.drawable.sleep),
        Reminder(R.string.reminder3, R.drawable.study),
        Reminder(R.string.reminder5, R.drawable.work)

    )

    val days = listOf(
        Day(R.string.day2, R.drawable.exercise),
        Day(R.string.day7, R.drawable.friends),
        Day(R.string.day1, R.drawable.medication),
        Day(R.string.day4, R.drawable.meditate),
        Day(R.string.day8, R.drawable.party),
        Day(R.string.day6, R.drawable.sleep),
        Day(R.string.day3, R.drawable.study),
        Day(R.string.day5, R.drawable.work)

    )

}