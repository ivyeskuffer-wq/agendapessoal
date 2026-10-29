package com.example.agendapessoal.navigation

import android.content.ActivityNotFoundException
import android.content.Intent
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.agendapessoal.screens.*
import com.example.agendapessoal.viewmodel.ContatoViewModel

object Routes {
    const val HOME = "home"
    const val CADASTRO = "cadastro"
    const val DETALHES = "detalhes"
    const val SOBRE = "sobre"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val contatoViewModel: ContatoViewModel = viewModel()
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                contatos = contatoViewModel.contatos,
                onCadastrar = {
                    navController.navigate(Routes.CADASTRO)
                },
                onVerDetalhes = { id ->
                    navController.navigate("${Routes.DETALHES}/$id")
                },
                onSobre = {
                    navController.navigate(Routes.SOBRE)
                }
            )
        }

        composable(Routes.CADASTRO) {
            CadastroScreen(
                onVoltar = {
                    navController.popBackStack()
                },
                onSalvar = { nome, telefone, email ->
                    contatoViewModel.adicionarContato(
                        nome, telefone, email
                    )
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "${Routes.DETALHES}/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) { entry ->
            val id = entry.arguments?.getInt("id") ?: -1

            DetalhesScreen(
                contatoId = id,
                contato = contatoViewModel.buscarPorId(id),
                onVoltar = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.SOBRE) {
            SobreScreen(
                onVoltar = {
                    navController.popBackStack()
                },
                onCompartilhar = {
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(
                            Intent.EXTRA_TEXT,
                            "Agenda Pessoal — IFES Campus Serra. " +
                                    "Aplicativo Android para cadastrar " +
                                    "contatos e consultar seus detalhes."
                        )
                    }

                    try {
                        context.startActivity(
                            Intent.createChooser(
                                intent,
                                "Compartilhar Agenda Pessoal"
                            )
                        )
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(
                            context,
                            "Nenhum aplicativo compatível encontrado.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            )
        }
    }
}