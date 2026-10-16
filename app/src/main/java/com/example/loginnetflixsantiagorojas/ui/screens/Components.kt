package com.example.loginnetflixsantiagorojas.ui.screens

import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginnetflixsantiagorojas.ui.theme.NetflixRed

@Composable
fun NetflixLogo() {
    Text("NETFLIX", color = NetflixRed, fontSize = 32.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun NetflixButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = NetflixRed),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text, color = Color.White)
    }
}

@Composable
fun NetflixField(label: String, value: String, onChange: (String) -> Unit, password: Boolean = false) {
    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        label = { Text(label) },
        singleLine = true,
        visualTransformation = if (password) PasswordVisualTransformation() else VisualTransformation.None,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.Gray,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.Gray
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun RegisterTopBar(step: Int, onBackClick: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        IconButton(onClick = onBackClick) {
            Text("←", color = Color.White, fontSize = 24.sp)
        }
        Spacer(Modifier.width(8.dp))
        NetflixLogo()
    }
    Spacer(Modifier.height(16.dp))
    Text("PASO $step DE 3", color = Color.Gray, fontSize = 12.sp)
}