package com.example.googlenewscursor.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.googlenewscursor.R

data class NewsItem(
    val image: Painter?,
    val title: String,
    val text: String,
    val isFavorite: Boolean,
    val onFavoriteToggle: () -> Unit
)

val quicksandFontFamily = FontFamily(Font(R.font.quicksand))

@Composable
fun NewsCard(newsItem: NewsItem) {
    val imagePainter = newsItem.image ?: painterResource(R.drawable.news)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .clickable { /* Navigate to news detail */ },
    ) {
        Box(modifier = Modifier.fillMaxWidth()){
            Image(
                painter = imagePainter,
                contentDescription = newsItem.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
            )
            Icon(
                painter = if (newsItem.isFavorite) painterResource(R.drawable.ic_favorite) else painterResource(id = R.drawable.ic_favorite_border),
                contentDescription = "Toggle Favorite",
                modifier = Modifier
                    .size(48.dp)
                    .clickable { newsItem.onFavoriteToggle() }
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
            )
        }
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = newsItem.title,
                fontFamily = quicksandFontFamily,
                fontSize = 14.sp,
                style = TextStyle(fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
            )
            Text(
                text = newsItem.text,
                fontFamily = quicksandFontFamily,
                fontSize = 16.sp,
                style = TextStyle(fontWeight = androidx.compose.ui.text.font.FontWeight.ExtraBold)
            )
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", fontFamily = quicksandFontFamily)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFunction() {
    NewsCard(
        newsItem = NewsItem(
            image = painterResource(id = R.drawable.news),
            title = "Sample News Title",
            text = "Sample news description goes here.",
            isFavorite = false,
            onFavoriteToggle = { /* Toggle favorite logic */ })
    )
}