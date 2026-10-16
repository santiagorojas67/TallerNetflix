package com.example.loginnetflixsantiagorojas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginnetflixsantiagorojas.ui.theme.NetflixBlack

@Composable
fun LoginScreen(onLoginClick: () -> Unit = {}, onRegisterClick: () -> Unit = {}) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(NetflixBlack).padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NetflixLogo()
        Spacer(Modifier.height(32.dp))
        Text("Inicia sesión", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))
        NetflixField("Correo electrónico", email, { email = it })
        Spacer(Modifier.height(12.dp))
        NetflixField("Contraseña", password, { password = it }, password = true)
        Spacer(Modifier.height(24.dp))
        NetflixButton("Iniciar sesión", onLoginClick)
        Spacer(Modifier.height(16.dp))
        TextButton(onClick = onRegisterClick) {
            Text("¿Primera vez en Netflix? Suscríbete ya", color = Color.White)
        }
    }
}