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

## Deploy no Heroku

Para testar a aplicação utilizando o Postman, foi realizado o deploy no Heroku. 

### Testes:

#### Cadastro de Usuário (POST)

URL:
https://financas-pessoais.herokuapp.com/api/user

Corpo da requisição: 
{
	"name":"João Silva",
	"email":"joao@gmail.com"
}

#### Lista todos usuários (GET)

URL:
https://financas-pessoais.herokuapp.com/api/user/listall

#### Cadastra Lançamento (POST)

URL:
https://financas-pessoais.herokuapp.com/api/lancamento

Corpo da requisição: 
{
	"user":"1",
	"description":"Salário",
	"type":"INCOME",
	"value":"6000",
	"day":"15",
	"month":"3",
	"year":"2019"
}

#### Listar lançamentos (GET)

https://financas-pessoais.herokuapp.com/api/lancamento/listar

Para consultar todo mapeamento e suas funções consulte os arquivos dentro de ./api/resource

