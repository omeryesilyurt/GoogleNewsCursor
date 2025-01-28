package com.example.googlenewscursor.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.googlenewscursor.R
import com.example.googlenewscursor.viewmodel.NewsViewModel
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: NewsViewModel = androidx.hilt.navigation.compose.hiltViewModel()) {
    // Verileri çekmek için ViewModel'den fetchNews() çağrısı yapın
    viewModel.fetchNews("general")

    // API'den çekilen verileri gözlemleyin
    val newsResponse = viewModel.newsResponse.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Google News", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center) }
        )
        LazyRow(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items(listOf("General", "Sport", "Economy", "Technology")) { category ->
                Button(onClick = { /* Handle category click */ }) {
                    Text(text = category)
                }
            }
        }

        //TODO VERİLER BAŞARILI BİR ŞEKİLDE ÇEKİLDİ. UI DA DÜZENLEMELER YAPILIP DEVAM EDILECEK.
        LazyColumn {
            newsResponse.value?.result?.let { newsItems ->
                items(newsItems) { newsItem ->
                    // title null kontrolü ekledik
                    val title = newsItem.title ?: "Varsayılan Başlık"  // Varsayılan bir değer belirleyebilirsiniz
                    NewsItem(
                        image = painterResource(id = R.drawable.news), // Varsayılan bir resim kullanabilirsiniz
                        title = title,
                        text = newsItem.description,
                        isFavorite = false,
                        onFavoriteToggle = { /* Toggle favorite logic */ }
                    ).let {
                        NewsCard(
                            newsItem = it
                        )
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFunction1() {
    HomeScreen()
}