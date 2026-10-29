package com.example.agendapessoal.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.agendapessoal.model.Contato

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesScreen(
    contatoId: Int,
    contato: Contato?,
    onVoltar: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalhes") },
                navigationIcon = {
                    TextButton(onClick = onVoltar) {
                        Text("Voltar")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (contato == null) {
                Text("Contato não encontrado. ID: $contatoId")
            } else {
                Text("ID: ${contato.id}")
                Text("Nome: ${contato.nome}")
                Text("Telefone: ${contato.telefone}")
                Text("E-mail: ${contato.email}")
            }

            Button(onClick = onVoltar) {
                Text("Voltar para a lista")
            }
        }
    }
}