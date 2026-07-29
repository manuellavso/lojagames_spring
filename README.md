# 🎮 Projeto Loja Games - Backend com Spring Boot

<p align="center">
  <img src="https://ik.imagekit.io/iibl43pgxp/ChatGPT%20Image%2022%20de%20jul.%20de%202026,%2010_38_54.png" width="500"/>
</p>

[![MySQL](https://camo.githubusercontent.com/c49132f37ac3f2f1b7c9a8fa2352e3f5874c6393039371b6fa4c9f405a7d8c94/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4d7953514c2d3434373941313f7374796c653d666c61742d737175617265266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/c49132f37ac3f2f1b7c9a8fa2352e3f5874c6393039371b6fa4c9f405a7d8c94/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4d7953514c2d3434373941313f7374796c653d666c61742d737175617265266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465)[![Maven](https://camo.githubusercontent.com/83d21418c6ad8853ff0ebf48616a5134a5b73fdd5623fb444c3ef88a7015c08a/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4d6176656e2d4337314133363f7374796c653d666c61742d737175617265266c6f676f3d6170616368656d6176656e)](https://camo.githubusercontent.com/83d21418c6ad8853ff0ebf48616a5134a5b73fdd5623fb444c3ef88a7015c08a/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4d6176656e2d4337314133363f7374796c653d666c61742d737175617265266c6f676f3d6170616368656d6176656e)[![JPA](https://camo.githubusercontent.com/8a94a2fb5664e922e31e946fe8c049bcc99737b20c13bcc1795b54a3391fadc7/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a50412d48696265726e6174652d3539363636433f7374796c653d666c61742d737175617265)](https://camo.githubusercontent.com/8a94a2fb5664e922e31e946fe8c049bcc99737b20c13bcc1795b54a3391fadc7/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a50412d48696265726e6174652d3539363636433f7374796c653d666c61742d737175617265)[![License](https://camo.githubusercontent.com/7d217ebb91a61cb4d98e70dee31eb08e0a5f71bc518ebd4151a73c6fb1191d00/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4c6963656e73652d4d49542d626c75653f7374796c653d666c61742d737175617265)](https://camo.githubusercontent.com/7d217ebb91a61cb4d98e70dee31eb08e0a5f71bc518ebd4151a73c6fb1191d00/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4c6963656e73652d4d49542d626c75653f7374796c653d666c61742d737175617265)



## 1. Descrição

A **Loja Games API** é uma aplicação desenvolvida para realizar o gerenciamento de jogos de uma loja virtual, permitindo o cadastro, consulta, atualização e remoção de produtos do catálogo. Este projeto foi desenvolvido com fins educacionais, simulando uma aplicação real de e-commerce para praticar conceitos de **API REST**, **Programação Orientada a Objetos** e desenvolvimento backend utilizando **Java e Spring Boot**. 

Entre os principais recursos da aplicação, destacam-se: 

1. Cadastro e gerenciamento de usuários
2. Cadastro e gerenciamento de produtos
3. Organização dos produtos por categorias 
4. Consulta de produtos disponíveis no catálogo 
5. Consulta de produtos por nome
6. Consulta de produtos por preço
7. Atualização e exclusão de informações dos produtos, categorias e usuários
8. Cadastro de usuários com senha criptografada
9. Integração com banco de dados relacional



## 2. Sobre esta API

A API da **Loja Games** foi desenvolvida utilizando **Java** e o framework **Spring Boot**, seguindo os princípios da arquitetura **MVC (Model-View-Controller)** e do padrão arquitetural **REST**. A aplicação permite o gerenciamento dos recursos **Produtos** e **Categorias**, possibilitando a manipulação dos dados através de endpoints HTTP.

### 2.1. Principais funcionalidades da API:

1. Cadastro, consulta, atualização e remoção de produtos
2. Cadastro, consulta, atualização e remoção de categorias
3. Cadastro, autenticação e consulta de usuários
4. Atualização dos dados dos usuários
5. Associação de produtos às suas respectivas categorias
6. Criptografia das senhas dos usuários para maior segurança
7. Persistência dos dados utilizando banco de dados MySQL



## 3. Diagrama de Classes

<p align="center">
  <img src="https://ik.imagekit.io/iibl43pgxp/diagramadeclasses" width="900" />
</p>



## 4. Diagrama Entidade-Relacionamento (DER)

<p align="center">
  <img src="https://ik.imagekit.io/iibl43pgxp/Diagrama%20DER" width="900" />
</p>



## 5. Tecnologias utilizadas

| Item                          | Descrição       |
| ----------------------------- | --------------- |
| **Servidor**                  | Tomcat          |
| **Linguagem de programação**  | Java            |
| **Framework**                 | Spring Boot     |
| **ORM**                       | JPA + Hibernate |
| **Banco de dados Relacional** | MySQL           |
| **Segurança**                 | Spring Security |
| **Autenticação**              | JWT             |
| **Testes automatizados**      | JUnit           |
| **Documentação**              | SpringDoc       |



## 6. Modelo de Dados

A aplicação possui as seguintes entidades principais: 

### 🎮 Produtos

Representa os produtos disponíveis na loja. 

Principais atributos: 

- ID 

- Nome 

- Preço 

- Foto

- Estoque 

- Categoria 

  

### 🕹️ Categorias

Representa a classificação dos jogos. 

Exemplos: 

- Esporte
- Simulação
- Ação e Aventura
- Corrida
- Tiro



### 👤Usuários

Representa os usuários cadastrados na plataforma, responsáveis por realizar o acesso e interagir com a Loja Games.

Os dados cadastrados incluem:

- Nome

- Foto de perfil
- Data de nascimento
- Usuário (e-mail)
- Senha (armazenada de forma criptografada)



## 7. Requisitos

Para executar os códigos localmente, você precisará:

- [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Banco de dados [MySQL](https://dev.mysql.com/downloads/)
- [STS](https://spring.io/tools)
- [Insomnia](https://insomnia.rest/download) ou [Postman](https://www.postman.com/)



## 8. Como Executar o projeto no STS

### 8.1. Importando o Projeto

1. Clone o repositório do Projeto [Loja Games](https://github.com/manuellavso/lojagames_spring.git) dentro da pasta do *Workspace* do STS

```
git clone https://github.com/manuellavso/lojagames_spring.git
```

1. Abra o **Spring Tools Suite (STS)**
2. Acesse:

```
File → Import
```

3. Selecione:

```
General → Existing Projects into Workspace
```

4. Escolha a pasta onde o projeto foi clonado

5. Clique em **Finish**



### 8.2. Executando a aplicação

1. Abra a aba **Boot Dashboard**
2. Localize o projeto **Game Store API**
3. Clique em:

```
Start or Restart
```

1. Aguarde a inicialização no console do STS

Caso a aplicação seja iniciada corretamente, a API estará disponível em:

```
http://localhost:8080
```



## 9. Testando os endpoints

A API pode ser testada utilizando ferramentas como: 

- Insomnia 
- Postman



### 🎮 Recursos de Produtos

| Método | Endpoint                        | Descrição                                          |
| ------ | ------------------------------- | -------------------------------------------------- |
| GET    | `/produtos`                     | Lista todos os produtos.                           |
| GET    | `/produtos/{id}`                | Busca produto por ID.                              |
| GET    | `/produtos/nome/{nome}`         | Busca jogos pelo nome.                             |
| GET    | `/produtos/preco_menor/{preco}` | Busca jogos com preço menor que o valor informado. |
| GET    | `/produtos/preco_maior/{preco}` | Busca jogos com preço maior que o valor informado. |
| POST   | `/produtos`                     | Cadastra um novo produto.                          |
| PUT    | `/produtos`                     | Atualiza um produto.                               |
| DELETE | `/produtos/{id}`                | Remove um produto.                                 |

Exemplos de requisições: 

1. Buscar produtos pelo nome

   http GET http://localhost:8080/produtos/nome/FIFA

   

### 🕹️ Recursos de Categorias

| Método | Endpoint                  | Descrição                                              |
| ------ | ------------------------- | ------------------------------------------------------ |
| GET    | `/categorias`             | Lista todas as categorias.                             |
| GET    | `/categorias/{id}`        | Busca categoria por ID.                                |
| GET    | `/categorias/tipo/{tipo}` | Busca categoria cujo tipo contenha o termo pesquisado. |
| POST   | `/categorias`             | Cadastra uma nova categoria.                           |
| PUT    | `/categorias`             | Atualiza uma categoria.                                |
| DELETE | `/categorias/{id}`        | Remove uma categoria.                                  |

Exemplos de requisições:

1. Buscar todas as categorias  

   http   GET http://localhost:8080/categorias



### 👤 Recursos de Usuários

| Método | Endpoint              | Descrição                                             |
| ------ | --------------------- | ----------------------------------------------------- |
| GET    | `/usuarios/all`       | Lista todos os usuários cadastrados.                  |
| GET    | `/usuarios/{id}`      | Busca usuário específico por ID.                      |
| POST   | `/usuarios/cadastrar` | Cadastra um novo usuário.                             |
| POST   | `/usuarios/logar`     | Autentica um usuário pelo usuário (e-mail) e a senha. |
| PUT    | `/usuarios/atualizar` | Atualiza os dados de um usuário existente.            |

Exemplos de requisições:

1. Logar  usuário

   http   GET http://localhost:8080/usuarios/logar



## 9. Contribuição

Este repositório é parte de um projeto educacional, mas contribuições são sempre bem-vindas! Caso tenha sugestões, correções ou melhorias, fique à vontade para:

- Criar uma **issue**
- Enviar um **pull request**
- Compartilhar com colegas que estejam aprendendo Java!



## 10. Contato

Desenvolvido por [**Manuella Oliveira**](https://github.com/manuellavso) Para dúvidas, sugestões ou colaborações, entre em contato via GitHub ou abra uma issue!

🎮 Obrigada por visitar o projeto!
