<h1 align="center">
  Banco API
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Dev&message=Kevin Rodrigues&color=8257E5&labelColor=000000" alt="@giulianabezerra" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Desafio" />
</p>

API para gerenciar transferencias de um banco via (CRUD) que faz parte [desse desafio](https://github.com/Supera-Inovacao-Tecnologia/PS-Java-React) para pessoas desenvolvedoras backend júnior, que se candidatam para a Supera.

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar <...caminhoParaSeuJar>
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta springdoc OpenApi 3 e Insomnia:

### Endpoints de Transferencias
![Schema](/docs/images/transferencia_endpoints.png)

### Endpoints de Contas
![Schema](/docs/images/contas_endpoints.png)

### Schemas da API
![Schema](/docs/images/schemas.png)

para mais informações e testes de endpoints abra o swagger da aplicação citado acima.

