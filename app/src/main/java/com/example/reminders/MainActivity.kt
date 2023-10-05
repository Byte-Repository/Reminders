package com.example.reminders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reminders.data.DataSource
import com.example.reminders.model.Reminder
import com.example.reminders.ui.theme.RemindersTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.layout.ContentScale
import com.example.reminders.model.Day

@Composable
fun MainContent() {
    ReminderList(DataSource.reminders, DataSource.days)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemindersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent() // Use MainContent composable here
                }
            }
        }
    }
}

@Preview
@Composable
fun ReminderApp() {
    ReminderList(DataSource.reminders, DataSource.days)
}

@Composable
fun ReminderList(reminderList: List<Reminder>, dayList: List<Day>, modifier: Modifier = Modifier) {
    val sortedReminders = reminderList.sortedBy { it.stringResourceId }

    LazyColumn(modifier = modifier) {
        items(sortedReminders) { reminder ->
            val matchingDay = dayList.firstOrNull { it.name == reminder.stringResourceId }
            val defaultDay = when (reminder.stringResourceId) {
                R.string.reminder1 -> Day(R.string.day1, R.drawable.medication)
                R.string.reminder2 -> Day(R.string.day2, R.drawable.exercise)
                R.string.reminder3 -> Day(R.string.day3, R.drawable.study)
                R.string.reminder4 -> Day(R.string.day4, R.drawable.meditate)
                R.string.reminder5 -> Day(R.string.day5, R.drawable.work)
                R.string.reminder6 -> Day(R.string.day6, R.drawable.sleep)
                R.string.reminder7 -> Day(R.string.day7, R.drawable.friends)
                R.string.reminder8 -> Day(R.string.day8, R.drawable.party)
                // Add more cases for other reminders here
                else -> Day(R.string.day1, R.drawable.medication)
            }
            ReminderCard(
                reminder = reminder,
                day = matchingDay ?: defaultDay,
                modifier = Modifier.padding(1.dp)
            )
        }
    }
}

@Composable
fun ReminderCard(reminder: Reminder, day: Day, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
    ) {
        Column {
            Text(
                text = stringResource(id = day.name),
                modifier = Modifier.padding(
                    start =16.dp,
                    top = 8.dp,
                    bottom = 8.dp
                ),
                style = MaterialTheme.typography.headlineSmall
            )
            Image(
                painter = painterResource(id = reminder.imageResourceId),
                contentDescription = stringResource(reminder.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
                    .background(Color.Black),
                //contentScale is commented out on purpose. You can uncomment it or change it
                //to try different looks for the image.
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = reminder.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
fun ReminderCardPreview() {
    // Call ReminderCard and pass in first reminder as sample data to preview
    ReminderCard(reminder = DataSource.reminders[0], day = DataSource.days[0])
}

