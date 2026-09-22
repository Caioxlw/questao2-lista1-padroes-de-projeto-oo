# Questão 2 - Lista 1 Padrões de Projeto OO
**Alunos:** Maria Letícia de Sousa Barboza e Caio Vinícius de Santana Gomes

Este repositório contém a solução para a lista de exercícios de Padrões de Projeto Orientados a Objetos, demonstrando a aplicação do padrão **Observer** no contexto de uma simulação de sistema de telefone.

## 📖 O Problema
O desafio consiste em adaptar o código inicial de um pacote de telefone para que ele utilize o padrão Observer. O objetivo é notificar a interface de usuário (UI) representada pela classe `Screen` sempre que um novo dígito for inserido, obedecendo às restrições de que **somente a UI pode imprimir na tela** e que **o telefone deve ser completamente desacoplado da UI**. A interface deve criar dois observadores com responsabilidades distintas na exibição dos dados.

## 🏗️ Modelagem da Solução

O projeto implementa o padrão **Observer** para criar uma relação de "Publicador-Assinante" entre os dados do telefone e a tela, removendo qualquer acoplamento direto.

### Mapeamento do Padrão:
- **Observer (`Observer`):** A interface que define o contrato para os observadores. Contém o método `update(int newDigit)` que é acionado para notificar o recebimento de uma atualização.
- **Subject / Observable (`PhoneModel`):** O modelo que armazena os dígitos do número de telefone. Atua como o publicador, mantendo uma lista de observadores registrados e os notificando ativamente a cada novo dígito inserido no teclado.
- **Concrete Observers (`Screen`):** A classe de interface. No momento de sua criação, ela registra dois observadores anônimos no modelo (`PhoneModel`):
  - **O primeiro observador:** Responsável por escutar e imprimir individualmente na tela o dígito mais recente.
  - **O segundo observador:** Monitora a quantidade de dígitos no modelo. Ao identificar que todos os 12 dígitos foram inseridos, aciona a impressão da mensagem final *"Agora discando [número]..."*.

## 🚀 Como Executar

O projeto não requer gerenciadores de dependência externos e pode ser executado diretamente no terminal local.

1. Navegue até o diretório que contém o código (`telephone`):
   ```bash
   cd telephone
   ```
2. Compile os arquivos Java:
   ```bash
   javac *.java
   ```
3. Execute o programa principal:
   ```bash
   java Main
   ```