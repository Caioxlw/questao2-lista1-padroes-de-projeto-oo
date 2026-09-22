# Uso de Inteligência Artificial na Atividade

Nesta atividade, a Inteligência Artificial foi utilizada como suporte para ajudar a interpretar o problema proposto e estruturar a aplicação correta do padrão de projeto **Observer**. 

A interação com a IA consistiu principalmente em fornecer o enunciado e o código fonte original, solicitando explicações e um guia passo a passo do que deveria ser feito para atender às restrições do professor.

## O Plano de Implementação Sugerido

# Implementação do Padrão Observer no Telefone

Este plano detalha o que o seu professor espera para a atividade e como faremos as modificações no código para implementar o padrão de projeto **Observer**.

## Explicação do que o Professor Quer

O objetivo desta atividade é desacoplar a interface de usuário (UI, representada pela classe `Screen`) dos dados (representados pela classe `PhoneModel`). Atualmente, o `PhoneModel` armazena os dígitos, mas não há um mecanismo para avisar a UI quando um novo dígito é teclado.

O padrão **Observer** resolve isso criando uma relação de "Publicador - Assinante". 
1. **O Publicador (Subject):** Será o `PhoneModel`. Ele manterá uma lista de "observadores" (interessados) e os avisará sempre que um novo dígito for adicionado.
2. **A Interface Observer:** Servirá como um contrato, garantindo que todo observador possua um método para ser notificado (ex: `update`).
3. **Os Assinantes (Observers):** A classe `Screen` criará dois observadores que "assinarão" as atualizações do `PhoneModel`. Um deles imprimirá cada dígito na tela assim que digitado, e o outro aguardará a digitação de todos os dígitos para imprimir a mensagem final ("Agora discando...").

A restrição "Somente a UI pode imprimir na tela" significa que os `System.out.println` que reagem às mudanças no telefone precisam ficar dentro das classes de observer criadas no `Screen`.

## Proposed Changes

---

### Observador (Interface)

#### [NEW] [Observer.java]
Criação da interface `Observer` contendo o método `void update(int newDigit);` ou `void update();`.

### Modelo (Subject)

#### [MODIFY] [PhoneModel.java]
- Adicionar uma lista de `Observer`: `private List<Observer> observers = new ArrayList<>();`
- Criar o método `public void addObserver(Observer observer)` para registrar os observadores.
- Criar o método `private void notifyObservers(int newDigit)` para iterar sobre a lista e chamar o `update` de cada um.
- Modificar o método `addDigit` para chamar o `notifyObservers` sempre que um novo dígito for adicionado.

### UI (Screen)

#### [MODIFY] [Screen.java]
- Dentro do construtor, criar e adicionar o Primeiro Observador ao `model`. Ele imprimirá apenas o dígito recebido.
- Dentro do construtor, criar e adicionar o Segundo Observador ao `model`. Ele verificará o tamanho da lista de dígitos do `model` e, se chegar a 12 (todos os dígitos inseridos), fará a impressão de `"Agora discando " + numeroCompleto + "..."`.