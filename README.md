```Comando para compilar
& "C:\Program Files\Java\jdk-17\bin\javac.exe" -encoding utf-8 -d bin -sourcepath src src\br\com\faculdade\Main.java

```Comando para executar a aplicação no terminal
java -cp bin br.com.faculdade.Main

# 🚀 Sistema de Gerenciamento de Produtos - Back-End Java

Repositório para fins acadêmicos, referente às fases do projeto da disciplina de Back-End.

A aplicação consiste em um sistema de console desenvolvido em Java aplicando os princípios de **Programação Orientada a Objetos (POO)**, **Gestão de Exceções Customizadas** e **Coleções em Memória (HashMap e ArrayList)** para realizar operações de **CRUD**.

---

## 🛠️ Tecnologias e Pré-requisitos

- **Linguagem:** Java 17 (JDK 17+)
- **Git / GitHub:** Controle de versão
- **Ambiente:** Terminal / PowerShell (Windows) ou Bash (Linux/Mac)

---

## 📂 Estrutura do Projeto

```text
Back_End/
└── src/
    └── br/
        └── com/
            └── faculdade/
                ├── exception/
                │   ├── EntidadeNaoEncontradaException.java
                │   └── ValidacaoException.java
                ├── model/
                │   ├── Entidade.java
                │   └── Produto.java
                ├── repository/
                │   └── ProdutoRepository.java
                └── Main.java