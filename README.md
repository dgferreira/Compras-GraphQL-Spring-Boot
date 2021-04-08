## Compras-GraphQL-Spring-Boot
 
Projeto de estudo sobre GraphQL utilizando Java e Spring Boot, baseado no curso da Udemy - [API GraphQL com SpringBoot](https://www.udemy.com/course/graphql-springboot/)

 
## Tecnologias
 
Aqui estão as tecnologias utilizadas neste projeto:
 
* Java 1.8
* Spring Boot
* JPA
* MySQL
* Maven
* GraphQL
* Model Mapper
* Lombok
* Hibernate Cache
* JUnit Test
 
 
## Ferramentas utilizadas
 
* IntelliJ
* MySQL Workbench
* Github
* Heroku
 
 
## Instalação
 
É necessário utilizar o Java na versão 1.8 e o Banco de Dados MySQL. </br>
Você pode utilizar a base de dados já configurada no application.properties ou se preferir utilizar localmente, basta criar uma nova database e configurar no application-dev.properties. </br>
Para utilizar localmente você deve rodar a classe principal ComprasApplication.java, não esqueça de que em Run/Debug Configurations em Active profiles você deve colocar a palavra "dev" para que o IntelliJ possa reconhecer que é do application-dev.properties que ele utilizará as configurações (caso você não informe este profile, ele irá utilizar as configurações do application.properties). </br>
Rode os scripts de creates.sql e inserts.sql que estão na pasta "banco". </br>
Pronto. Seu projeto já está de pé. Basta agora acessar a url: [localhost:5000/playground](http://localhost:5000/playground) ou [localhost:5000/graphiql](http://localhost:5000/graphiql)
 
 
## Features
 
  <b>Query's:</b>
  - hello: String
  - soma(a: Int, b: Int): Int
  - compra(id: ID!): Compra
  - compras(page: Int = 0, size: Int = 10): [Compra]!
  - comprasRelatorio: [ComprasRelatorio]
  - cliente(id: ID!): Cliente
  - clientes: [Cliente]!
  - produto(id: ID!): Produto
  - produtos: [Produto]
  
  <b>Mutation's:</b>
  - saveCompra(compra: CompraInput!): Compra!
  - deleteCompra(id: ID!): Boolean!
  - saveCliente(cliente: ClienteInput!): Cliente!
  - deleteCliente(id: ID!): Boolean!
  - saveProduto(produto: ProdutoInput!): Produto!
  - deleteProduto(id: ID!): Boolean!
 
 
## Implantação
 
  - Link da aplicação publicada no Heroku: https://compras-graphql-springboot.herokuapp.com/playground (substituir a palavra "playground" (dark) por "graphiql" (white) caso queira mudar de tema)
  - Obs: O banco de dados está populado para que você possa testar as query's e mutation's.
 
 
## Versão
 
1.0.0
 
 
## Autor
 
* **Douglas Ferreira**: [@dgferreira](http://www.douglasferreira.dev.br)
 
 
Espero ter ajudado. Bons estudos!
