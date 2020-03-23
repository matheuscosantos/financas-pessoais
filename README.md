# Projeto - Finanças pessoais
### Projeto desenvolvido com o intuito de aplicar os conteúdos aprendidos no Programa de Estagiários 2020 da empresa GSW.

### Tecnologias aplicadas:
* Spring Boot
* Spring Data JPA ( Hibernate )
* Postgres

### Arquiteturas utilizadas:
* API Rest
* Arquitetura Onion

### Requisitos do sistema

O sistema deve permitir que usuários gerenciem lançamentos financeiros de entrada e saída.

Abaixo estão os requisitos esperados do sistema:

* Lançamentos
    * Cadastrar lançamentos
    * Buscar lançamentos
    * Visualizar lançamentos
    * Editar lançamentos
    * Remover lançamentos
    * Definir tipo de lançamento

* Usuários
    * Criar usuário
    * Editar usuário
    * Remover usuário

Abaixo estão as entidades esperadas para o sistema:

* Entidades
    * Lançamento:
        * Id
        * Tipo
        * Valor
        * Descrição
    
    * Usuário
        * Id
        * Nome
        * E-mail
        * Lançamentos


