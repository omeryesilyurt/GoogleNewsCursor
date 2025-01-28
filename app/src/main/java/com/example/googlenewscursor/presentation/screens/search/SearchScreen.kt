package com.example.googlenewscursor.presentation.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.googlenewscursor.R
import com.example.googlenewscursor.presentation.screens.home.NewsCard
import com.example.googlenewscursor.presentation.screens.home.NewsItem
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

val quicksandFontFamily = FontFamily(Font(R.font.quicksand))

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    Column (modifier = Modifier.fillMaxSize()){
        TopAppBar(
            title = { Text("Search", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontFamily = quicksandFontFamily) }
        )
        // Search bar
        TextField(
            value = "",
            onValueChange = { /* Handle search input */ },
            label = { Text("Search", fontFamily = quicksandFontFamily) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        // Empty LazyColumn for search results
        LazyColumn {
            // No items yet
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFunction(){
    SearchScreen()
}