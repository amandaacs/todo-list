# TODO List - Java (Console)

Aplicação de TODO List desenvolvida em **Java puro**, executada via **terminal**, como parte de um desafio técnico.

O objetivo do projeto é permitir o gerenciamento de tarefas, contendo informações como nome, descrição, data de término, prioridade, categoria e status, respeitando todos os requisitos definidos no enunciado, sem uso de frameworks.

# Funcionalidades

## Requisitos obrigatórios implementados

* Cadastro de tarefas com os seguintes atributos:
  * Nome
  * Descrição
  * Data de término
  * Nível de prioridade (1 a 5)
  * Categoria
  * Status (TODO, DOING, DONE)
* CRD de tarefas (Create, Read e Update)
*  Menu simples no terminal
*  Listagem de tarefas por:
    * Categoria
    * Prioridade
    * Status
* Rebalanceamento automático das tarefas com base na prioridade
* Implementação exclusivamente em Java, sem uso de frameworks

## Funcionalidades opcionais implementadas


* Contagem de tarefas por status (TODO, DOING, DONE)
* Atualização de tarefas existentes
* Filtro de tarefas por data limite
* Persistência de dados em arquivo .csv, garantindo que as tarefas não sejam perdidas ao encerrar a aplicação

## Organização por responsabilidade
* model: entidades e enums do domínio
* repository: armazenamento em memória e persistência em arquivo
* service: regras de negócio e ordenação
* ui: interação com o usuário via terminal
* util: classes utilitárias (datas e arquivos)

## Como executar o projeto
* Pré-requisitos
    * Java JDK 17 ou superior
    * Terminal / Prompt de comando

### Passos
1. Clone o repositório:
```
git clone https://github.com/seu-usuario/todo-list-java.git
```
2. Acesse o diretório do projeto:
```
cd todo-list-java
```
3. Compile o projeto:
```
javac -d out src/main/java/com/project/Main.java
```
4. Execute a aplicação:
```
java -cp out com.project.Main
```

## Menu da Aplicação
1 - Criar tarefa

2 - Listar todas as tarefas

3 - Listar por categoria

4 - Listar por prioridade

5 - Listar por status

6 - Listar por data limite

7 - Atualizar tarefa

8 - Contagem por status

0 - Sair

## Autoria
Projeto desenvolvido por Amanda Costa
