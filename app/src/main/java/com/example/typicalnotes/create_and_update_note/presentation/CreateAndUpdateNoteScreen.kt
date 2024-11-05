package com.example.typicalnotes.create_and_update_note.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.typicalnotes.core.ui_kit.composables.BasicFilledButton
import com.example.typicalnotes.core.ui_kit.composables.OutlinedTextField
import com.example.typicalnotes.core.ui_kit.composables.TopBar
import com.example.typicalnotes.R
import com.example.typicalnotes.ui.theme.TypicalNotesTheme

@Composable
internal fun CreateAndUpdateNoteScreen(
    modifier: Modifier = Modifier,
    uiState: CreateAndUpdateNoteUiState,
    topBarTitle: Int?,
    onSaveButtonClick: () -> Unit,
    navigateToHomeScreen: () -> Unit,
    onTitleChanged: (String) -> Unit,
    onDescriptionChanged: (String) -> Unit,
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .imePadding(),
        topBar = { TopBar(title = stringResource(topBarTitle!!)) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when(uiState) {
                is CreateAndUpdateNoteUiState.Content -> Content(
                    title = uiState.title,
                    description = uiState.description,
                    onTitleChanged = onTitleChanged,
                    onDescriptionChanged = onDescriptionChanged,
                    onSaveButtonClick = onSaveButtonClick,
                    navigateToHomeScreen = navigateToHomeScreen
                )
            }
        }
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onTitleChanged: (String) -> Unit,
    onDescriptionChanged: (String) -> Unit,
    onSaveButtonClick: () -> Unit,
    navigateToHomeScreen: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier
                .width(300.dp)
                .padding(top = 40.dp),
            text = title,
            placeHolderText = stringResource(R.string.title_text_field_placeholder),
            singleLine = true,
            onValueChange = onTitleChanged
        )

        Spacer(modifier = Modifier.height(22.dp))

        OutlinedTextField(
            modifier = Modifier
                .width(300.dp)
                .height(400.dp),
            text = description,
            placeHolderText = stringResource(R.string.create_note_description),
            onValueChange = onDescriptionChanged
        )

        Spacer(modifier = Modifier.height(20.dp))

        BasicFilledButton(
            modifier = Modifier
                .width(160.dp)
                .height(50.dp),
            text = stringResource(R.string.save_button_text),
            onClick = {
                if (title.isEmpty()) {
                    Toast.makeText(
                        context, context.getText(R.string.please_fill_out_the_title_field), Toast.LENGTH_LONG
                    ).show()
                    return@BasicFilledButton
                }
                onSaveButtonClick()
                navigateToHomeScreen()
            }
        )
    }
}

@Composable
@Preview
private fun CreateAndUpdateNoteScreenPreview() {

    val uiState = CreateAndUpdateNoteUiState.Content(0,"Note", "new description")

    TypicalNotesTheme(dynamicColor = false) {
        CreateAndUpdateNoteScreen(
            uiState = uiState,
            topBarTitle = R.string.create_note_topbar_title,
            onSaveButtonClick = {},
            navigateToHomeScreen = {},
            onTitleChanged = {},
            onDescriptionChanged = {}
        )
    }
}
