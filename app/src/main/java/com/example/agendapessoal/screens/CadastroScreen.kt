package com.example.agendapessoal.screens

import android.util.Patterns
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(
    onVoltar: () -> Unit,
    onSalvar: (String, String, String) -> Unit
) {
    var nome by rememberSaveable { mutableStateOf("") }
    var telefone by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var tentouSalvar by rememberSaveable { mutableStateOf(false) }

    val nomeValido = nome.isNotBlank()
    val telefoneValido = telefone.isNotBlank()
    val emailValido =
        Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Novo contato") },
                navigationIcon = {
                    TextButton(onClick = onVoltar) {
                        Text("Cancelar")
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
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome *") },
                isError = tentouSalvar && !nomeValido,
                supportingText = {
                    if (tentouSalvar && !nomeValido) {
                        Text("Informe o nome.")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = telefone,
                onValueChange = { telefone = it },
                label = { Text("Telefone *") },
                isError = tentouSalvar && !telefoneValido,
                supportingText = {
                    if (tentouSalvar && !telefoneValido) {
                        Text("Informe o telefone.")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-mail *") },
                isError = tentouSalvar && !emailValido,
                supportingText = {
                    if (tentouSalvar && !emailValido) {
                        Text("Informe um e-mail válido.")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    tentouSalvar = true

                    if (nomeValido && telefoneValido && emailValido) {
                        onSalvar(nome.trim(), telefone.trim(), email.trim())
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Salvar contato")
            }

            TextButton(
                onClick = onVoltar,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancelar cadastro")
            }
        }
    }
}