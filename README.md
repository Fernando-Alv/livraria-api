# 📚 Livraria API

API REST desenvolvida em Java com Spring Boot para gerenciamento de uma livraria, incluindo funcionalidades para cadastro de livros, usuários e controle de empréstimos e devoluções de livros.

---

## 🚀 Funcionalidades

- 📖 Cadastro, listagem, atualização e remoção de livros
- 👤 Cadastro, listagem, atualização e remoção de usuários
- 📦 Registro de empréstimos de livros
- 📬 Devolução de livros emprestados
- 📑 Consulta de histórico de empréstimos
- ✅ Validações de disponibilidade de livros
- ❌ Tratamento de exceções e mensagens de erro padronizadas

---

## 🛠️ Tecnologias utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Web
- Spring Data JPA
- MySQL
- MapStruct (para conversão entre entidades e DTOs)
- Lombok
- Maven

---

## 📁 Estrutura do Projeto

```bash
src/
├── controller       # Controladores REST
├── dto              # Objetos de transferência de dados (DTOs)
├── entity           # Entidades JPA
├── exception        # Classes de exceção e tratamento global
├── repository       # Interfaces de acesso ao banco (JPA)
├── service          # Camada de regras de negócio
├── mapstruct        # Mapeadores com MapStruct
