# Projeto Transação

## Descrição
Este é um projeto de demonstração Spring Boot (`transacao`) que serve como uma aplicação web. Ele utiliza Spring Data JPA para interação com um banco de dados PostgreSQL e Spring Cloud OpenFeign para comunicação com outros serviços. O projeto é empacotado como um arquivo WAR e pode ser executado localmente ou em um contêiner Docker.

## Tecnologias Utilizadas
*   **Java 21**
*   **Spring Boot 3.5.4**
    *   `spring-boot-starter-web`: Para construção de APIs RESTful.
    *   `spring-boot-starter-data-jpa`: Para persistência de dados com JPA.
    *   `spring-boot-starter-tomcat`: Servidor web embarcado (empacotado como WAR).
    *   `spring-boot-starter-test`: Para testes.
*   **Spring Cloud OpenFeign**: Para clientes REST declarativos.
*   **PostgreSQL**: Driver JDBC para conexão com banco de dados PostgreSQL.
*   **Lombok**: Biblioteca para reduzir código boilerplate.
*   **Maven**: Ferramenta de automação de build e gerenciamento de dependências.
*   **Docker**: Para conteinerização da aplicação.

## Como Começar

### Pré-requisitos
*   **JDK 21**
*   **Apache Maven**
*   **Docker** e **Docker Compose** (opcional, para execução em contêineres)
*   Um servidor **PostgreSQL** em execução e acessível.

### Construção do Projeto
Para construir o projeto, navegue até o diretório raiz (`C:/Programacao/Projetos/transacao`) e execute o seguinte comando Maven:
```bash
mvn clean install
```
Este comando irá compilar o código, executar os testes e empacotar a aplicação em um arquivo `.war` no diretório `target/`.

### Execução Local

#### Configuração do Banco de Dados
Certifique-se de que seu banco de dados PostgreSQL esteja configurado e que as credenciais de conexão (geralmente em `src/main/resources/application.properties` ou `application.yml`) estejam corretas.

#### Executando a Aplicação
Após a construção, você pode executar a aplicação diretamente usando o Maven ou o arquivo WAR gerado:

**Via Maven:**
```bash
mvn spring-boot:run
```

**Via arquivo WAR:**
```bash
java -jar target/transacao-0.0.1-SNAPSHOT.war
```

### Execução com Docker
O projeto inclui um `Dockerfile` e um `docker-compose.yml` para facilitar a conteinerização.

#### Construindo a Imagem Docker
No diretório raiz do projeto, execute:
```bash
docker build -t transacao-app .
```

#### Executando com Docker Compose
Se o `docker-compose.yml` estiver configurado para orquestrar o banco de dados e a aplicação, você pode iniciar tudo com:
```bash
docker-compose up
```
Alternativamente, você pode executar a imagem Docker diretamente:
```bash
docker run -p 8080:8080 transacao-app
```
(A porta `8080` é a porta padrão do Spring Boot, mas pode ser configurada de forma diferente no projeto.)

## Endpoints da API
Esta aplicação expõe endpoints RESTful. Para detalhes específicos sobre os endpoints disponíveis (como `/api/transacoes`, `/api/usuarios`, etc.), é necessário consultar o código-fonte na pasta `src/main/java` e a documentação gerada (se houver).