package com.example.loginnetflixsantiagorojas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.loginnetflixsantiagorojas.ui.theme.NetflixBlack
import com.example.loginnetflixsantiagorojas.ui.theme.NetflixGray

data class Movie(val title: String, val imageUrl: String)

@Composable
fun HomeScreen(onLogoutClick: () -> Unit = {}) {
    val categorias = listOf(
        "Tendencias" to listOf(
            Movie("Stranger Things", "https://picsum.photos/seed/m1/300/450"),
            Movie("Dark", "https://picsum.photos/seed/m2/300/450"),
            Movie("La Casa de Papel", "https://picsum.photos/seed/m3/300/450"),
            Movie("Narcos", "https://picsum.photos/seed/m4/300/450")
        ),
        "Acción" to listOf(
            Movie("Extraction", "https://picsum.photos/seed/m5/300/450"),
            Movie("Red Notice", "https://picsum.photos/seed/m6/300/450"),
            Movie("The Gray Man", "https://picsum.photos/seed/m7/300/450"),
            Movie("Army of the Dead", "https://picsum.photos/seed/m8/300/450")
        ),
        "Comedia" to listOf(
            Movie("Wednesday", "https://picsum.photos/seed/m9/300/450"),
            Movie("Sex Education", "https://picsum.photos/seed/m10/300/450"),
            Movie("Big Mouth", "https://picsum.photos/seed/m11/300/450"),
            Movie("The Politician", "https://picsum.photos/seed/m12/300/450")
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(NetflixBlack)
            .padding(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                NetflixLogo()
                Spacer(Modifier.weight(1f))
                TextButton(onClick = onLogoutClick) {
                    Text("Salir", color = Color.White)
                }
            }
            Spacer(Modifier.height(16.dp))
        }
        items(categorias) { (nombre, peliculas) ->
            Text(nombre, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(peliculas) { movie ->
                    Column(modifier = Modifier.width(120.dp)) {
                        AsyncImage(
                            model = movie.imageUrl,
                            contentDescription = movie.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(width = 120.dp, height = 170.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(NetflixGray)
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(movie.title, color = Color.White, fontSize = 12.sp, maxLines = 1)
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}