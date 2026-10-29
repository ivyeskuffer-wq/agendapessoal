Agenda Pessoal

Objetivo
    Aplicativo Android desenvolvido para a Atividade Prática 3 da disciplina Desenvolvimento Mobile do IFES — Campus Serra.

    O aplicativo permite cadastrar contatos, visualizar a lista e consultar os detalhes de cada contato.

Autores
    Nome completo: Layslla Ivyes Kuffer Santos
    Nome completo: Jefferson Castro Silva

Tecnologias utilizadas
    Kotlin
    Jetpack Compose
    Material 3
    Navigation Compose
    ViewModel
    Intent implícito com ACTION_SEND
    
Como executar
    Abra o projeto no Android Studio.
    Aguarde a sincronização do Gradle.
    Execute o aplicativo em um emulador ou dispositivo Android.

Organização do projeto
    MainActivity.kt: inicia o aplicativo.
    model/Contato.kt: define os dados dos contatos.
    viewmodel/ContatoViewModel.kt: gerencia a lista compartilhada.
    navigation/AppNavigation.kt: configura as rotas e a navegação.
    screens/HomeScreen.kt: exibe os contatos.
    screens/CadastroScreen.kt: permite cadastrar contatos.
    screens/DetalhesScreen.kt: exibe os dados de um contato.
    screens/SobreScreen.kt: apresenta informações e permite compartilhar o projeto.

Funcionalidades
    Listagem de contatos.
    Cadastro com validação de campos.
    Atualização da lista após o cadastro.
    Consulta de detalhes por ID.
    Tratamento de contato inexistente.
    Navegação entre quatro telas.
    Compartilhamento por Intent.ACTION_SEND.

Testes realizados
    Preencher após executar os testes:
        Cadastro de contato válido.
        Validação de formulário inválido.
        Consulta de detalhes de contato.
        Cancelamento do cadastro.
        Navegação entre as quatro telas.
        Compartilhamento pelo Android.
        Tratamento de ID inexistente.
        
Uso de inteligência artificial
    Ferramenta: ChatGPT.
        Finalidade: auxiliar na adaptação do código, organização dos arquivos, implementação da navegação, gerenciamento de estado, validação do formulário e compartilhamento por Intent.
        Revisões realizadas: Para corrigir algumas partes do código que ficaram vermelhas.

    Limitações
        Os contatos são armazenados em memória durante a execução do aplicativo. Não há banco de dados, portanto os novos cadastros não são garantidos após o encerramento completo do processo.