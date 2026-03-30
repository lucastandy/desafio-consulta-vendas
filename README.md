# 📊 Sales Query API

API REST desenvolvida com **Java + Spring Boot** para consulta de vendas e geração de relatórios, utilizando **JPA, JPQL e paginação**.

Este projeto foi desenvolvido como parte de um desafio prático focado em consultas dinâmicas e boas práticas com Spring Data JPA.

---

## 🚀 Tecnologias utilizadas

* Java 17+;
* Spring Boot;
* Spring Data JPA;
* Hibernate;
* Maven;
* H2 Database (ambiente de teste);
* Postman.

---

## 📌 Funcionalidades

### 🔹 Relatório de vendas

Permite consultar vendas com filtros opcionais:

* Data inicial (`minDate`);
* Data final (`maxDate`);
* Nome do vendedor (`name`).

📤 Retorno:

* Listagem **paginada** contendo:

  * ID da venda;
  * Data;
  * Valor;
  * Nome do vendedor.

---

### 🔹 Sumário de vendas por vendedor

Retorna o total vendido por cada vendedor em um período.

📥 Parâmetros:

* Data inicial (`minDate`);
* Data final (`maxDate`).

📤 Retorno:

* Nome do vendedor;
* Soma total de vendas.

---

## 🔍 Exemplos de requisições

### 📄 Relatório de vendas

```http
GET /sales/report
```

```http
GET /sales/report?minDate=2022-05-01&maxDate=2022-05-31&name=odinson
```

---

### 📊 Sumário de vendas

```http
GET /sales/summary
```

```http
GET /sales/summary?minDate=2022-01-01&maxDate=2022-06-30
```

---

## ⚙️ Regras de negócio

* Caso `maxDate` não seja informado → será considerada a data atual;
* Caso `minDate` não seja informado → será considerado **1 ano antes da data final**;
* Caso `name` não seja informado → será considerado como string vazia;
* A busca por nome é **case insensitive**.

---

## 🧠 Conceitos aplicados

* Projeção com DTO no JPQL (`SELECT new`);
* Consultas dinâmicas com parâmetros opcionais;
* Paginação com `Pageable`;
* Tratamento de datas com `LocalDate`;
* Separação em camadas (Controller, Service, Repository).

---

## ▶️ Como executar o projeto

```bash
# Clonar repositório
git clone https://github.com/seu-usuario/seu-repo.git

# Entrar na pasta
cd seu-repo

# Executar
./mvnw spring-boot:run
```

---

## 🧪 Testes

As requisições podem ser testadas via:

* Postman;
* Insomnia;
* Navegador (para endpoints GET).

---

## 👨‍💻 Autor

Desenvolvido por **Lucas Tandy do Nascimento Silva**
 https://www.linkedin.com/in/lucas-tandy/

* 💼 Desenvolvedor de Software
* 🎓 Engenharia de Software | Ciência da Computação
  
