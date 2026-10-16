package com.example.loginnetflixsantiagorojas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginnetflixsantiagorojas.ui.theme.NetflixBlack
import com.example.loginnetflixsantiagorojas.ui.theme.NetflixGray
import com.example.loginnetflixsantiagorojas.ui.theme.NetflixRed

@Composable
fun RegisterStep2Screen(onBackClick: () -> Unit = {}, onNextClick: () -> Unit = {}) {
    val planes = listOf(
        "Estándar con anuncios" to "COP 15.900/mes",
        "Estándar" to "COP 23.900/mes",
        "Premium" to "COP 31.900/mes"
    )
    var seleccionado by remember { mutableStateOf(2) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NetflixBlack)
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        RegisterTopBar(2, onBackClick)
        Spacer(Modifier.height(8.dp))
        Text("Elige tu plan", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))
        planes.forEachIndexed { index, plan ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .background(NetflixGray)
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = seleccionado == index,
                    onClick = { seleccionado = index },
                    colors = RadioButtonDefaults.colors(selectedColor = NetflixRed)
                )
                Text(plan.first, color = Color.White, modifier = Modifier.weight(1f))
                Text(plan.second, color = Color.White)
            }
        }
        Spacer(Modifier.height(24.dp))
        NetflixButton("Siguiente", onNextClick)
    }
}