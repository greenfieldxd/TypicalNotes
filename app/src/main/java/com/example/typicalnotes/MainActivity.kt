package com.example.typicalnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.typicalnotes.navigation.Navigation
import com.example.typicalnotes.ui.theme.TypicalNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TypicalNotesTheme(dynamicColor = false) {
                Navigation()
            }
        }
    }
}