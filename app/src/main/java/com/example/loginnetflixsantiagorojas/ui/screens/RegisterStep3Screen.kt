package com.example.loginnetflixsantiagorojas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginnetflixsantiagorojas.ui.theme.NetflixBlack
import com.example.loginnetflixsantiagorojas.ui.theme.NetflixGray
import com.example.loginnetflixsantiagorojas.ui.theme.NetflixRed

@Composable
fun RegisterStep3Screen(onBackClick: () -> Unit = {}, onNextClick: () -> Unit = {}) {
    val metodos = listOf("Tarjeta", "PSE", "Nequi", "Efecty")
    var metodo by remember { mutableStateOf("Tarjeta") }
    var numero by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var vence by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NetflixBlack)
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        RegisterTopBar(3, onBackClick)
        Spacer(Modifier.height(8.dp))
        Text("Configura el pago", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            metodos.forEach {
                Button(
                    onClick = { metodo = it },
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (metodo == it) NetflixRed else NetflixGray
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(it, fontSize = 12.sp, color = Color.White)
                }
            }
        }
        Spacer(Modifier.height(16.dp))
        NetflixField("Número de tarjeta", numero, { numero = it })
        Spacer(Modifier.height(12.dp))
        NetflixField("Nombre completo", nombre, { nombre = it })
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Box(Modifier.weight(1f)) { NetflixField("MM/AA", vence, { vence = it }) }
            Box(Modifier.weight(1f)) { NetflixField("CVV", cvv, { cvv = it }, password = true) }
        }
        Spacer(Modifier.height(24.dp))
        NetflixButton("Iniciar membresía", onNextClick)
    }
}