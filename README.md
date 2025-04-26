# URL Shortener

Um encurtador de URLs simples desenvolvido em Java utilizando o framework Spring Boot.

## Funcionalidades

- **Encurtar URLs**: Gera uma URL única e curta para um link fornecido.
- **Redirecionamento**: Redireciona para a URL original a partir de sua versão encurtada.
- **Validade**: URLs encurtadas têm validade de 30 dias.
- **Remoção Automática**: URLs expiradas são removidas automaticamente.

## Tecnologias Utilizadas

- [Java](https://www.java.com/) (100%)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [JPA/Hibernate](https://hibernate.org/)

## Estrutura do Projeto

- `UrlApplication.java`: Classe principal que inicializa o aplicativo.
- `UrlController.java`: Controlador REST responsável por gerenciar as requisições de encurtamento e redirecionamento de URLs.
- `UrlService.java`: Contém a lógica de negócios para encurtar URLs e buscar URLs originais.
- `UrlRepository.java`: Interface JPA para acesso ao banco de dados.
- `Url.java`: Modelo de dados para armazenar informações de URLs no banco de dados.

## Como Usar

### Pré-requisitos

- **Java 17** ou superior.
- **Maven** para gerenciamento de dependências.

### Passos para Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/davicbtoliveira/urlShortener.git
   cd urlShortener
   ```

2. Compile e execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Acesse o aplicativo no navegador em `http://localhost:8080`.

### Exemplos de Uso

#### Encurtar uma URL

- **Endpoint**: `POST /url/shorten`
- **Corpo da Requisição**:
  ```json
  {
    "url": "http://example.com"
  }
  ```
- **Resposta**:
  ```json
  {
    "url": "https://xxx.com/abc123"
  }
  ```

#### Redirecionar para a URL Original

- **Endpoint**: `GET /url/{shortUrl}`
- **Exemplo**:
  - Requisição: `GET /url/abc123`
  - Resposta: Redireciona para `http://example.com`.

## Contato

- Autor: [Davi Oliveira](https://github.com/davicbtoliveira)
