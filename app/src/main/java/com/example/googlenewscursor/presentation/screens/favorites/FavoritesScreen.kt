package com.example.googlenewscursor.presentation.screens.favorites

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.googlenewscursor.presentation.screens.search.SearchScreen
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.googlenewscursor.R

val quicksandFontFamily = FontFamily(Font(R.font.quicksand))

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen() {
    Column (modifier = Modifier.fillMaxSize()){
        TopAppBar(
            title = { Text("Favorites", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontFamily = quicksandFontFamily) }
        )
        // Empty LazyColumn for favorite news
        LazyColumn {
            // No items yet
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFunction(){
    FavoritesScreen()
}