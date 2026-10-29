package com.example.agendapessoal.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.agendapessoal.model.Contato


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    contatos: List<Contato>,
    onCadastrar: () -> Unit,
    onVerDetalhes: (Int) -> Unit,
    onSobre: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agenda Pessoal") }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text("Meus contatos")

            Button(
                onClick = onCadastrar,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cadastrar novo contato")
            }
            Button(
                onClick = onSobre,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sobre o aplicativo")
            }

            LazyColumn(
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(contatos) { contato ->
                    Card(
                        onClick = {
                            onVerDetalhes(contato.id)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(contato.nome)
                            Text(contato.telefone)
                            Text(contato.email)
                            Text("Toque para ver detalhes")
                        }
                    }
                }
            }
        }
    }
}