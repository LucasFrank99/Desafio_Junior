# Projeto Transação

## Descrição
Este projeto é uma implementação simplificada de uma plataforma de pagamentos, permitindo depósitos e transferências entre usuários e lojistas. Foi desenvolvido como parte de um desafio técnico para a vaga de Desenvolvedor Backend Júnior. 
Repositório original do desafio: (https://github.com/PicPay/picpay-desafio-backend)

## ⚙️ Funcionalidades Implementadas
- Cadastro de usuários com validação de CPF, CNPJ e e-mail únicos.
- Criação de carteiras digitais associadas a cada usuário.
- Envio de dinheiro entre usuários e para lojistas, com validação de saldo.
- Integração com serviço autorizador externo para validação de transações.
- Notificação de transações via serviço externo.
- Tratamento de erros e exceções.
- Documentação da API com Swagger.

## Tecnologias Utilizadas
*   **Java 21**
*   **Spring Boot 3.5.4**
    *   `spring-boot-starter-web`: Para construção de APIs RESTful.
    *   `spring-boot-starter-data-jpa`: Para persistência de dados com JPA.
    *   `spring-boot-starter-tomcat`: Servidor web embarcado (empacotado como WAR).
*   **Spring Cloud OpenFeign**: Para clientes REST declarativos.
*   **PostgreSQL**: Driver JDBC para conexão com banco de dados PostgreSQL.
*   **Lombok**: Biblioteca para reduzir código boilerplate.
*   **Maven**: Ferramenta de automação de build e gerenciamento de dependências.
*   **Docker**: Para conteinerização da aplicação.


### Pré-requisitos
*   **JDK 21**
*   **Apache Maven**
*   **Docker** e **Docker Compose** (opcional, para execução em contêineres)
*   Um servidor **PostgreSQL** em execução e acessível.

## 📦 Como Executar
1. Clone este repositório:
```bash
git clone https://github.com/LucasFrank99/Desafio_Junior
```

2. Navegue até o diretório do projeto:
```bash
cd Desafio_Junior
```

3. Inicie o banco de dados com Docker Compose:
```bash
docker-compose up
```

4. Execute a aplicação Spring Boot:
```bash
./mvnw spring-boot:run
```

## 📚 Documentação da API
A API RESTful está documentada com Swagger. Para acessá-la, inicie a aplicação e navegue até [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).
