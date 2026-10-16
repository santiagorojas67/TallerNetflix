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

@Composable
fun RegisterScreen(onBackClick: () -> Unit = {}, onNextClick: () -> Unit = {}) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NetflixBlack)
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        RegisterTopBar(1, onBackClick)
        Spacer(Modifier.height(8.dp))
        Text("Crea tu contraseña", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(4.dp))
        Text("Solo unos pasos más y podrás disfrutar del contenido.", color = Color.Gray)
        Spacer(Modifier.height(24.dp))
        NetflixField("Correo electrónico", email, { email = it })
        Spacer(Modifier.height(12.dp))
        NetflixField("Crea una contraseña", password, { password = it }, password = true)
        Spacer(Modifier.height(12.dp))
        NetflixField("Confirma tu contraseña", confirm, { confirm = it }, password = true)
        Spacer(Modifier.height(24.dp))
        NetflixButton("Siguiente", onNextClick)
    }
}
