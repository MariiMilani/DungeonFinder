

DungeonFinder - API de fila de masmorras

O projeto a seguir tem a finalidade de consolidar novos conhecimentos agregando hobby's, desta maneira o mesmo foi inspirado pelo jogo online World of Warcraft

![image](DungeonFinderUI.png)

## 📋 Descrição

DungeonFinder é uma API REST desenvolvida em Spring Boot que permite cadastrar, consultar e atualizar informações de personagens e masmorras, inspirado pelo jogo online World of Warcraft.

## 🚀 Tecnologias Utilizadas

- **Java 17** - Linguagem de programação
- **Spring Boot 3.5.4** - Framework para desenvolvimento de aplicações Java
- **Spring Web** - Módulo para criação de APIs REST
- **Maven** - Gerenciador de dependências e build
- **Thymeleaf** - Mecanismo de Web template para Java

## 📁 Estrutura do Projeto

```
DungeonFinder/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── dev/DungeonFinder/DungeonFinder/
│   │   │       ├── Dungeons/
│   │   │       │   ├── DungeonController.java
│   │   │       │   ├── DungeonDTO.java
│   │   │       │   ├── DungeonMapper.java
│   │   │       │   ├── DungeonModel.java
│   │   │       │   ├── DungeonRepository.java
│   │   │       │   └── DungeonService.java
│   │   │       ├── Players/
│   │   │       │   ├── PlayersController.java
│   │   │       │   ├── PlayersControllerUI.java
│   │   │       │   ├── PlayersDTO.java
│   │   │       │   ├── PlayersMapper.java
│   │   │       │   ├── PlayersModel.java
│   │   │       │   ├── PlayersRepository.java
│   │   │       │   └── PlayersService.java
│   │   │       ├── DungeonFinderApplication.java
│   │   │       └── ModelMapperConfig
│   │   └── resources/
│   │       ├── db/migration                          # Flyway Migrations
│   │       ├── templates                             # HTML and CSS logic
│   │       └── application.properties                # Application configuration
│   └── test/
└── pom.xml
```

## 🛠️ Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6+ 

### Passos para execução
1. Clone o repositório
2. Navegue até a pasta do projeto: `cd DungeonFinder`
3. Execute o projeto: `./mvnw spring-boot:run`
4. A aplicação estará disponível em: `http://localhost:8090`

## 📡 Endpoints da API

### 👤 Player

####  Criação de players
- **URL**: `POST /player/add`
- **Parâmetros via corpo da requisição**:
    - `name` - nome do player,
    - `Lvl` - level do player,
    - `class` - classe do player.
- **Exemplo**:
    - `name` - `"Thrall"`,
    - `Lvl` - `60`,
    - `class` - `"Shaman"`
- **Resposta**: Novo objeto com informações fornecidas.

#### Deleção de player
- **URL**: `DELETE /player/delete/{id}`
- **Parâmetros**: `id` - O identificador do player desejado.
- **Exemplo**: `DELETE /player/delete/1`
- **Resposta**: Objeto com informações do player é deletado do banco de dados.

#### Alteração de player específico
- **URL**: `PATCH /player/update/{id}`
- **Parâmetros**: `id` - O identificador do player desejado.
- **Exemplo**: `PATCH /player/update/1`
- **Resposta**: Objeto com informações atualizadas do player.

#### Consulta de players
- **URL**: `GET /player/show`
- **Parâmetros**: Sem parâmetros.
- **Resposta**: Uma lista com todos os players já cadastrados.

#### Consulta de player específico
- **URL**: `GET /player/show/{id}`
- **Parâmetros**: `id` - O identificador do player desejado.
- **Exemplo**: `GET /player/show/1`
- **Resposta**: Objeto com informações do player.


#### 📊 Exemplo de Resposta

```json
{
  "id": 1,
  "name": "Thrall",
  "Lvl": 60,
  "class": "Shaman"
}
```

### 🙋 Masmorra

####  Criação de masmorras
- **URL**: `POST /dungeon/add`
- **Parâmetros via corpo da requisição**:
    - `name` - nome da masmorra,
    - `minimumLvl` - level minimo para os players entrarem na masmorra,
    - `bossesNumber` - número total de chefões na masmorra,
    - `bosses` - nome dos chefões
- **Exemplo**:
    - `name` - `"Shadowfang Keep"`,
    - `minimumLvl` - `22`,
    - `bossesNumber` - `1`,
    - `bosses` - `"Archmage Arugal"`
- **Resposta**: Novo objeto com informações fornecidas.

#### Deleção de masmorra
- **URL**: `DELETE /dungeon/delete/{id}`
- **Parâmetros**: `id` - O identificador da masmorra desejada.
- **Exemplo**: `DELETE /dungeon/delete/1`
- **Resposta**: Objeto com informações da masmorra é deletado do banco de dados.

#### Consulta de masmorra
- **URL**: `GET /dungeon/show`
- **Parâmetros**: Sem parâmetros.
- **Resposta**: Uma lista com todas as masmorras já cadastradas.

#### Consulta de masmorra específica
- **URL**: `GET /dungeon/show/{id}`
- **Parâmetros**: `id` - O identificador da masmorra desejada.
- **Exemplo**: `GET /dungeon/show/1`
- **Resposta**: Objeto com informações da masmorra.


#### 📊 Exemplo de Resposta

```json
{
  "id": 1,
  "name": "Shadowfang Keep",
  "minimumLvl": 22,
  "bossesNumber": 1,
  "bosses": "Archmage Arugal"
}
```

## 🏗️ Arquitetura

- **Dungeon Layer**: Gerencia e define as entidades relacionadas a masmorra e as requisições HTTP
- **Player Layer**: Gerencia e define as entidades relacionadas a players e as requisições HTTP

## 🔧 Configurações

O projeto utiliza as configurações padrão do Spring Boot. Para personalizar, edite o arquivo `application.properties`.

## 👨‍💻 Desenvolvido por

Este projeto foi desenvolvido por **[Mariana Milani Assunção](https://github.com/MariiMilani)** visando consolidar conceitos de Spring Boot.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.
