package com.example.feedtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.feedtest.db.AppDatabase
import com.example.feedtest.repository.PeopleRepository
import com.example.feedtest.ui.PeopleScreen
import com.example.feedtest.ui.PeopleViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = PeopleRepository(AppDatabase.getInstance(this))
        setContent {
            MaterialTheme {
                val viewModel: PeopleViewModel = viewModel(
                    factory = PeopleViewModel.Factory(repository)
                )
                PeopleScreen(viewModel)
            }
        }
    }
}
