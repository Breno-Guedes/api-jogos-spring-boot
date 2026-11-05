# API de Jogos - Spring Boot

API REST desenvolvida como projeto de estudo durante o aprendizado de Spring Boot, com o objetivo de praticar o desenvolvimento de aplicações backend em Java, criação de endpoints HTTP, operações CRUD e persistência de dados utilizando Spring Data JPA e banco de dados H2.

O projeto permite cadastrar, consultar, atualizar e remover jogos, além de disponibilizar uma consulta específica para listar jogos que estão em promoção.

## Sumário

- [Objetivos do Projeto](#objetivos-do-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Arquitetura do Projeto](#arquitetura-do-projeto)
- [Modelo de Dados](#modelo-de-dados)
- [Endpoints da API](#endpoints-da-api)
- [Banco de Dados](#banco-de-dados)
- [Como Executar o Projeto](#como-executar-o-projeto)
- [Testes com Postman](#testes-com-postman)
- [Conceitos Praticados](#conceitos-praticados)
- [Possíveis Melhorias](#possíveis-melhorias)
- [Autor](#autor)

## Objetivos do Projeto

Este projeto foi desenvolvido com a finalidade de consolidar conhecimentos sobre desenvolvimento de APIs REST utilizando o ecossistema Spring.

Principais objetivos:

- Compreender a arquitetura de uma aplicação Spring Boot.
- Desenvolver endpoints REST utilizando anotações do Spring MVC.
- Implementar operações CRUD.
- Trabalhar com requisições e respostas HTTP.
- Realizar a transferência de dados utilizando JSON.
- Implementar persistência de dados com Spring Data JPA.
- Utilizar o banco de dados H2.
- Trabalhar com injeção de dependências.
- Separar responsabilidades entre Controller, Service e Repository.
- Testar endpoints utilizando Postman.

## Tecnologias Utilizadas

| Tecnologia | Finalidade |
|---|---|
| Java 21 | Linguagem de programação |
| Spring Boot 3.3.0 | Framework principal |
| Spring Web | Desenvolvimento da API REST |
| Spring Data JPA | Persistência e acesso aos dados |
| Hibernate | Implementação ORM |
| H2 Database | Banco de dados relacional |
| Maven | Gerenciamento de dependências e build |
| Postman | Testes das requisições HTTP |
| Git e GitHub | Versionamento e hospedagem do código |

## Arquitetura do Projeto

A aplicação utiliza uma arquitetura em camadas, separando as responsabilidades de cada componente.

```text
src/
└── main/
    ├── java/
    │   └── br/edu/ifpi/api_jogos/
    │       ├── controller/
    │       │   └── JogoController.java
    │       │
    │       ├── service/
    │       │   └── JogoService.java
    │       │
    │       ├── repository/
    │       │   └── JogoRepository.java
    │       │
    │       ├── models/
    │       │   └── Jogo.java
    │       │
    │       └── ApiJogosApplication.java
    │
    └── resources/
        └── application.properties
```

### Responsabilidades das Camadas

**Controller**

Responsável por receber as requisições HTTP, identificar os endpoints correspondentes, capturar parâmetros e encaminhar as operações para a camada Service.

**Service**

Responsável por concentrar as regras de negócio e intermediar a comunicação entre Controller e Repository.

**Repository**

Responsável pelo acesso e pela persistência dos dados no banco de dados, utilizando os recursos do Spring Data JPA.

**Models**

Contém as classes que representam as entidades da aplicação. A classe `Jogo` representa os dados armazenados no banco de dados.

## Modelo de Dados

A entidade principal da aplicação é `Jogo`.

| Atributo | Tipo | Descrição |
|---|---|---|
| id | Long | Identificador do jogo |
| titulo | String | Nome do jogo |
| plataforma | String | Plataforma em que o jogo está disponível |
| preco | Double | Preço do jogo |
| promocao | Boolean | Indica se o jogo está em promoção |

### Exemplo de objeto JSON

```json
{
  "titulo": "The Witcher 3",
  "plataforma": "PC",
  "preco": 79.90,
  "promocao": true
}
```

## Endpoints da API

A aplicação disponibiliza operações para cadastro, consulta, atualização e exclusão de jogos.

**Endereço-base:**

```text
http://localhost:8081
```

### 1. GET - Consultas

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/jogos` | Lista todos os jogos |
| GET | `/jogos/{id}` | Busca um jogo pelo ID |
| GET | `/jogos/promocao` | Lista os jogos em promoção |

#### Listar todos os jogos

```http
GET /jogos
```

Retorna uma lista contendo os jogos cadastrados.

#### Buscar jogo por ID

```http
GET /jogos/1
```

Retorna os dados do jogo correspondente ao identificador informado.

#### Listar jogos em promoção

```http
GET /jogos/promocao
```

Retorna somente os jogos cujo atributo `promocao` está definido como `true`.

### 2. POST - Cadastro

**Endpoint:**

```http
POST /jogos
```

Responsável por cadastrar um novo jogo.

**Corpo da requisição:**

```json
{
  "titulo": "The Witcher 3",
  "plataforma": "PC",
  "preco": 79.90,
  "promocao": true
}
```

**Resposta esperada:**

```http
201 Created
```

O cadastro retorna os dados do jogo criado.

### 3. PUT - Atualização

**Endpoint:**

```http
PUT /jogos/1
```

Responsável por atualizar os dados de um jogo existente, utilizando seu identificador.

**Corpo da requisição:**

```json
{
  "titulo": "The Witcher 3 Complete Edition",
  "plataforma": "PC",
  "preco": 49.90,
  "promocao": true
}
```

**Resposta:** retorna os dados atualizados do jogo.

### 4. DELETE - Remoção

**Endpoint:**

```http
DELETE /jogos/1
```

Responsável por remover um jogo do banco de dados utilizando seu identificador.

**Resposta esperada:**

```http
204 No Content
```

## Banco de Dados

O projeto utiliza o H2 Database, um banco de dados relacional que permite armazenar e consultar informações sem a necessidade de instalar um servidor externo de banco de dados.

A persistência é realizada utilizando Spring Data JPA, enquanto o Hibernate atua como implementação ORM.

### Configuração

O banco de dados está configurado para armazenamento em arquivo:

```properties
spring.datasource.url=jdbc:h2:file:./data/jogosdb
```

### Console do H2

O console pode ser acessado pelo endereço:

```text
http://localhost:8081/h2-console
```

O console permite visualizar e executar consultas SQL diretamente no banco de dados.

## Como Executar o Projeto

### Pré-requisitos

Antes de executar a aplicação, é necessário possuir:

- Java JDK 21 ou superior compatível com o projeto.
- Maven.
- Git (opcional, para clonar o repositório).

### 1. Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
```

### 2. Acessar o diretório

```bash
cd api-jogos
```

### 3. Executar a aplicação

Utilizando Maven:

```bash
mvn spring-boot:run
```

Ou executar diretamente a classe principal:

```text
ApiJogosApplication.java
```

### 4. Acessar a API

Após a inicialização, a aplicação estará disponível em:

```text
http://localhost:8081
```

## Testes com Postman

As requisições HTTP foram organizadas em uma Collection do Postman, separadas por tipo de operação.

```text
API de Jogos - IFPI
│
├── GET - Consultas
│   ├── Listar Todos os Jogos
│   ├── Buscar Jogo por ID
│   └── Listar Jogos em Promoção
│
├── POST - Cadastro
│   └── Cadastrar Jogo
│
├── PUT - Atualização
│   └── Atualizar Jogo
│
└── DELETE - Remoção
    └── Apagar Jogo
```

A Collection permite testar individualmente os endpoints e verificar o comportamento das operações CRUD.

## Conceitos Praticados

Durante o desenvolvimento deste projeto, foram trabalhados os seguintes conceitos:

- Desenvolvimento de APIs REST.
- Arquitetura em camadas.
- Injeção de dependências.
- Inversão de controle (IoC).
- Spring MVC.
- Anotações do Spring Boot.
- Mapeamento de rotas HTTP.
- Path Variables.
- Serialização e desserialização JSON.
- Operações CRUD.
- Mapeamento objeto-relacional (ORM).
- Spring Data JPA.
- Repositórios JPA.
- Persistência de dados.
- Banco de dados relacional.
- Códigos de status HTTP.

## Possíveis Melhorias

Algumas funcionalidades que podem ser implementadas para ampliar o projeto:

- Implementação de DTOs.
- Validação de dados com Bean Validation.
- Tratamento global de exceções com `@ControllerAdvice`.
- Documentação interativa com Swagger/OpenAPI.
- Implementação de paginação e ordenação.
- Testes automatizados com JUnit e Mockito.
- Implementação de autenticação e autorização.
- Migração do H2 para PostgreSQL ou MySQL.
- Implementação de filtros e pesquisas por atributos dos jogos.

## Autor

**Breno Souza Guedes**

Estudante de Análise e Desenvolvimento de Sistemas no Instituto Federal do Piauí (IFPI) - Campus Corrente.

Projeto desenvolvido com finalidade acadêmica e educacional, como parte dos estudos de desenvolvimento backend com Java e Spring Boot.