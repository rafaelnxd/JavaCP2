

## Descrição do Projeto

Este projeto consiste no desenvolvimento de um aplicativo para uma empresa de brinquedos voltados para crianças de até 12 anos. Utilizando o framework Spring Boot com Maven em linguagem Java, o aplicativo realiza operações básicas de Create e Read (CRUD) em uma base de dados Oracle.

A aplicação expõe endpoints RESTful que permitem a criação e consulta de brinquedos através de requisições HTTP, utilizando o software Postman para testes. Os dados são persistidos em uma tabela no banco de dados ORACLE_FIAP do SQL Developer.

## Requisitos

- Java 17 ou superior
- Maven
- Banco de Dados Oracle (ORACLE_FIAP)
- SQL Developer
- Postman


## Instalação

1. Clone o repositório do projeto:

    ```bash
    git clone https://github.com/rafaelnxd/JavaCP2
    ```

2. Importe o projeto na sua IDE de preferência (Eclipse, IntelliJ, etc.):

    - Selecione a opção de importar um projeto Maven existente.
    - Navegue até a pasta raiz do projeto clonado.

3. Atualize as dependências do Maven:

    - Execute o comando `mvn clean install` no terminal, dentro da pasta do projeto, ou use a opção de atualizar projeto Maven na sua IDE.

## Configuração do Banco de Dados

Configuração do `application.properties`:

No arquivo `src/main/resources/application.properties`, configure as credenciais e detalhes de conexão com o banco de dados Oracle:

```properties
# Configuração de Conexão com o Banco de Dados Oracle
spring.datasource.url=
spring.datasource.username="seu-usuario"
spring.datasource.password="sua-senha"
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

# Configurações do JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
```


## Executando a Aplicação

### Via Maven

No terminal, dentro da pasta do projeto, execute:

```bash
mvn spring-boot:run
```

### Via IDE

- Localize a classe `BrinquedosApplication` no pacote `com.fiap.brinquedos`.
- Execute a aplicação como um aplicativo Java ou Spring Boot.

### Verificando se a aplicação está no ar

Acesse `http://localhost:8080/brinquedos` no seu navegador ou Postman.

Você deve receber uma resposta (provavelmente uma lista vazia em JSON).

## Endpoints

A aplicação disponibiliza os seguintes endpoints:

1. **Listar todos os brinquedos**
    - **URL**: `/brinquedos`
    - **Método HTTP**: `GET`
    - **Descrição**: Retorna uma lista de todos os brinquedos cadastrados.

2. **Consultar um brinquedo por ID**
    - **URL**: `/brinquedos/{id}`
    - **Método HTTP**: `GET`
    - **Descrição**: Retorna os detalhes de um brinquedo específico pelo seu ID.

3. **Cadastrar um novo brinquedo**
    - **URL**: `/brinquedos`
    - **Método HTTP**: `POST`
    - **Descrição**: Cadastra um novo brinquedo na aplicação (dados inicialmente armazenados em uma lista e posteriormente persistidos no banco de dados).


 4. **Deletar um brinquedo**
    - **URL**: `/brinquedos`
    - **Método HTTP**: `DELETE`
    - **Descrição**: Deleta um brinquedo.

## Teste com Postman


### Cadastrar um novo brinquedo

- **Requisição**:

    ```bash
    POST http://localhost:8080/brinquedos
    ```
![image](https://github.com/user-attachments/assets/ea2132bd-8ec3-4e8f-8313-e8f3a284be75)


