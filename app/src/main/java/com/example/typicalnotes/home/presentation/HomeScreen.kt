package com.example.typicalnotes.home.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.typicalnotes.R
import com.example.typicalnotes.core.domain.model.Note
import com.example.typicalnotes.core.ui_kit.composables.CreateNoteFloatingActionButton
import com.example.typicalnotes.core.ui_kit.composables.TopBar
import com.example.typicalnotes.core.ui_kit.composables.NoteItem
import com.example.typicalnotes.ui.theme.TypicalNotesTheme


@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenUiState,
    onCreateNoteFloatingActionButtonClick: () -> Unit,
    onDeleteNoteButtonClick: (Note) -> Unit,
    onNoteClick: (String) -> Unit
) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopBar(
                modifier = Modifier.shadow(4.dp),
                title = stringResource(R.string.typical_notes_main_topbar_title)
            )
        },
        floatingActionButton = {
            CreateNoteFloatingActionButton {
                onCreateNoteFloatingActionButtonClick()
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when(uiState) {
                is HomeScreenUiState.Empty -> HomeScreenEmpty()
                is HomeScreenUiState.Content -> HomeScreenContent(
                    notes = uiState.notes,
                    onDeleteNoteButtonClick = onDeleteNoteButtonClick,
                    onNoteClick = onNoteClick
                )
            }
        }
    }
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier,
    notes: List<Note>,
    onDeleteNoteButtonClick: (Note) -> Unit,
    onNoteClick: (String) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(notes) { note ->
            Spacer(modifier = Modifier.height(20.dp))
            NoteItem(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .clickable { onNoteClick(note.id.toString()) },
                title = note.title,
                description = note.description,
                onDeleteButtonClick = { onDeleteNoteButtonClick(note) }
            )
        }
    }
}

@Composable
private fun HomeScreenEmpty(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(R.string.dont_have_any_notes_banner),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 27.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenEmptyPreview() {
    TypicalNotesTheme(dynamicColor = false) {
        HomeScreenEmpty()
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenContentPreview() {
    val note = Note(0, "Title", "Description")
    val notes = listOf(note, note.copy(), note.copy(), note.copy(), note.copy())
    TypicalNotesTheme(dynamicColor = false) {
        HomeScreenContent(
            notes = notes,
            onDeleteNoteButtonClick = {},
            onNoteClick = {}
        )
    }
}