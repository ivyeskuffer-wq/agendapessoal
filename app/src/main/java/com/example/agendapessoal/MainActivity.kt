package com.example.agendapessoal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.agendapessoal.navigation.AppNavigation
import com.example.agendapessoal.ui.theme.AgendapessoalTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgendapessoalTheme {
                AppNavigation()
            }
        }
    }
}
