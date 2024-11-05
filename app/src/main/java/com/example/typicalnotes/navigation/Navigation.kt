package com.example.typicalnotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.typicalnotes.create_and_update_note.presentation.navigation.CreateAndUpdateNoteResArg
import com.example.typicalnotes.create_and_update_note.presentation.navigation.createAndUpdateNoteScreen
import com.example.typicalnotes.create_and_update_note.presentation.navigation.navigateToCreateAndUpdateNote
import com.example.typicalnotes.home.presentation.navigation.HOME_SCREEN_ROUTE
import com.example.typicalnotes.home.presentation.navigation.homeScreen
import com.example.typicalnotes.home.presentation.navigation.navigateToHomeScreen

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME_SCREEN_ROUTE) {

        homeScreen(
            navigateToCreateNoteScreen = {
                navController.navigateToCreateAndUpdateNote(CreateAndUpdateNoteResArg.CREATE_NOTE,null)
            },
            navigateToUpdateNote = {
                navController.navigateToCreateAndUpdateNote(CreateAndUpdateNoteResArg.UPDATE_NOTE, it)
            }
        )

        createAndUpdateNoteScreen { navController.navigateToHomeScreen() }
    }
}
