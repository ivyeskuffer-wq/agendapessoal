package com.example.agendapessoal.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.agendapessoal.model.Contato

class ContatoViewModel : ViewModel() {

    private val _contatos = mutableStateListOf(
        Contato(1, "Ana", "(27) 99999-1111", "ana@email.com"),
        Contato(2, "Bruno", "(27) 99999-2222", "bruno@email.com"),
        Contato(3, "Carlos", "(27) 99999-3333", "carlos@email.com")
    )

    val contatos: List<Contato>
        get() = _contatos

    private var proximoId = 4

    fun adicionarContato(nome: String, telefone: String, email: String) {
        _contatos.add(
            Contato(proximoId++, nome.trim(), telefone.trim(), email.trim())
        )
    }

    fun buscarPorId(id: Int): Contato? {
        return _contatos.find { it.id == id }
    }
}