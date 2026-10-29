package com.example.agendapessoal.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SobreScreen(
    onVoltar: () -> Unit,
    onCompartilhar: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Sobre") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Agenda Pessoal")
            Text("Aplicativo para cadastrar e consultar contatos.")
            Text(
                "Como usar:\n" +
                        "1. Consulte os contatos na tela inicial.\n" +
                        "2. Cadastre contatos pelo botão de cadastro.\n" +
                        "3. Toque em um contato para ver seus detalhes."
            )
            Text(
                "IFES — Campus Serra\n" +
                        "Autor(es): Agenda Pessoal"
            )

            Button(
                onClick = onCompartilhar,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Compartilhar aplicativo")
            }

            OutlinedButton(
                onClick = onVoltar,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Voltar")
            }
        }
    }
}
