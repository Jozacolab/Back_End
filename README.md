Você acabou misturando a abertura de blocos de código (as três crases ```), títulos incompletos e fechamentos de Markdown no meio do arquivo.

Aqui está o código **100% corrigido, limpo e estruturado** para você copiar e colar diretamente no seu arquivo `README.md`:

```markdown
# 🚀 Sistema de Gerenciamento de Produtos - Back-End Java

Repositório para fins acadêmicos, referente às fases do projeto da disciplina de Back-End.

A aplicação consiste em um sistema de console desenvolvido em Java aplicando os princípios de **Programação Orientada a Objetos (POO)**, **Gestão de Exceções Customizadas** e **Coleções em Memória (HashMap e ArrayList)** para realizar operações de **CRUD**[cite: 1].

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

```

---

## ⚙️ Compilação e Execução

### Comando para compilar

```powershell
& "C:\Program Files\Java\jdk-17\bin\javac.exe" -encoding utf-8 -d bin -sourcepath src src\br\com\faculdade\Main.java

```

### Comando para executar a aplicação no terminal

```powershell
java -cp bin br.com.faculdade.Main

```

---

## 📝 Relatório de Decisões de Design e Dificuldades

### 1. Decisões de Design e Arquitetura

* **Programação Orientada a Objetos (POO):**
* **Abstração e Herança:** A classe abstrata `Entidade` foi criada como modelo base para reuso do atributo `id` e imposição da assinatura do método `getExibicaoDetalhada()`. A classe `Produto` herda de `Entidade`, aproveitando a estrutura base.


* **Polimorfismo:** Sobrescrita do método `getExibicaoDetalhada()` na classe `Produto` (`@Override`), permitindo representações personalizadas dos dados da entidade.




* **Estruturas de Dados (Coleções):**
* **HashMap:** Utilizado no `ProdutoRepository` como banco de dados em memória. Permite buscas, atualizações e remoções eficientes indexadas pela chave primária (`id`) com complexidade $O(1)$.


* **ArrayList:** Utilizado para retornar coleções ordenadas e iteráveis de elementos para a camada de apresentação (`Main`).




* **Gestão de Exceções:**
* Criação de exceções customizadas (`EntidadeNaoEncontradaException` e `ValidacaoException`) para separar a lógica de erros de negócio do fluxo principal. Todas foram devidamente capturadas no loop do console (`try-catch`), garantindo a estabilidade do sistema.





### 2. Dificuldades Encontradas durante o Desenvolvimento

1. **Configuração de Codificação de Caracteres (Encoding):**
* *Problema:* Durante a compilação no PowerShell do Windows, ocorreram erros de caracteres incompatíveis (`unmappable character for encoding windows-1252`) devido à utilização de UTF-8 no código-fonte.


* *Solução:* Adicionado o parâmetro `-encoding utf-8` explicitamente no comando de compilação do `javac`.




2. **Ambiente e PATH do JDK:**
* *Problema:* O compilador `javac` não estava reconhecido nativamente nas variáveis de ambiente do sistema.


* *Solução:* Execução da compilação apontando para o caminho absoluto do binário dentro de `C:\Program Files\Java\jdk-17\bin\javac.exe`.




3. **Limpeza do Buffer do Scanner:**
* *Problema:* Ao alternar entre a leitura de números (`nextInt()`, `nextDouble()`) e textos (`nextLine()`), o caractere de quebra de linha permanecia no buffer, pulando leituras no console.


* *Solução:* Inclusão do método `scanner.nextLine()` após as leituras numéricas para esvaziar o buffer antes de capturar entradas de texto.





```

```