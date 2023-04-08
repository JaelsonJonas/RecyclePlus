# Recycle+

Documentação para o a API do projeto Recycle+

## Endpoints
  
- Usuario
    - [Criar usuario](#criar-novo-usuario)

    - [Autenticar acesso (Login)](#autenticar-acesso)

    - [Buscar pelo ID](#buscar-pelo-id)

    - [Realizar atualização](#atualizar-o-usuario)

    - [Redefinir Senha](#redefinir-senha)

- Transações
    - [Criar transação](#extrato)

    - [Extrato](#extrato)

- Endereço
    - [Criar](#criar-endereço)

    - [Atualizar](#atualizar-endereço)

- Material
    - [Listar os materiais reciclaveis](#listar-os-materiais-reciclaveis)



### Criar novo usuario

<br/>

`POST` /user

**Campos da requisição**
|   Campo  |    tipo    |   Obrigatorio | Descrição
|:-:|:-:|:-:|:-:
login|String|sim|Campo para armazenar o login
email|String|sim|Campo para armazenar o e-mail
senha|String|sim|Campo para armazenar a senha
nomeCompleto|String|sim|Campo para armazenar o nome completo
documento|String|sim|Campo para armazenar CPF/CNPJ
telefone|String|sim|Campo para armazenar telefone/celular
dataNasc|LocalDate|sim|Campo para armazenar a data de nascimento
genero|String|sim|Campo para armazenar o gênero
foto|String|não|Campo para armazenar o caminho que a foto foi salva em nosso server

**Exemplo de payload**

```JSON
    {
      "login": "joao.silva",
      "email": "joao.silva@email.com",
      "senha": "senha123",
      "nomeCompleto": "João da Silva",
      "documento": "123456.789-00",
      "telefone": "(11) 98765-4321",
      "dataNasc": "1990-01-01",
      "sexo": "masculino",
      "foto": "https://www.exemplo.com/fotos/joao.silva.jpg"
   }
```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | usuario cadastrado
| 400 | Campo invalido (A API vai informar qual campo esta incorreto)


### Autenticar acesso

<br/>

`POST` /login

<br/>

**Campos da requisição**
|   Campo  |    tipo    |   Obrigatorio | Descrição
|:-:|:-:|:-:|:-:
login|String|sim|campo reponsavel por armazenar o e-mail do usuario
senha|String|sim|Campo responsavel por armazenar a senha do usuario

**Exemplo de payload**

```JSON
{
    "login":"jow@fiap.com.br",
    "senha":"jow6969"
}
```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | usuario/senha autenticados
| 401 | usuario/senha invalidos


### Buscar pelo id

<br/>


`GET` /user{id}

<br/>

**Exemplo de corpo da resposta**

```JSON
    {
      "login": "joao.silva",
      "email": "joao.silva@email.com",
      "senha": "senha123",
      "nomeCompleto": "João da Silva",
      "documento": "123456.789-00",
      "telefone": "(11) 98765-4321",
      "dataNasc": "1990-01-01",
      "sexo": "masculino",
      "foto": "https://www.exemplo.com/fotos/joao.silva.jpg",
      "endereco": {
            "id":1
            "logradouro": "Rua Domingos de Morais, 1234",
            "CEP": "12345-678",
            "bairro": "Vila Mariana",
            "estado": "São Paulo",
            "cidade": "São Paulo"
      }
   }
```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | Usuario localizado
| 404 | usuario não existe


### Atualizando o usuario

<br/>

`PUT` /user{id}

<br/>

**Campos da requisição**
|   Campo  |    tipo    |   Obrigatorio | Descrição
|:-:|:-:|:-:|:-:
nomeCompleto|String|sim|Campo para armazenar o nome completo
documento|String|sim|Campo para armazenar CPF/CNPJ
telefone|String|sim|Campo para armazenar telefone/celular
dataNasc|LocalDate|sim|Campo para armazenar a data de nascimento
genero|String|sim|Campo para armazenar o gênero
foto|String|não|Campo para armazenar o caminho que a foto foi salva em nosso server

**Exemplo de payload**

```JSON
      {
      "login": "joao.silva",
      "email": "joao.silva@email.com",
      "senha": "senha123",
      "nomeCompleto": "Jaum da massa",
      "documento": "123456.789-00",
      "telefone": "(11) 3234-5678",
      "dataNasc": "1990-01-01",
      "sexo": "masculino",
      "foto": "https://www.exemplo.com/fotos/joao.silva.jpg"
   }

```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | update realizado com sucesso
| 400 | Campo invalido (A API vai informar qual campo esta incorreto)
| 404 | Usuario não encontrado

### Redefinir Senha

<br/>

`POST` /password-reset

<br/>

**Campos da requisição**
|   Campo  |    tipo    |   Obrigatorio | Descrição
|:-:|:-:|:-:|:-:
email|String|sim|campo reponsavel por armazenar o e-mail do usuario

**Exemplo de payload**

```JSON
{
    "email":"jow@fiap.com.br"
}
```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | Processo concluido
| 404 | e-mail para redefinir senha não localizado, tente novamente

### Criando transação

<br/>

`POST` /transactions

<br/>

**Campos da requisição**

|   Campo  |    tipo    |   Obrigatorio | Descrição
|:-:|:-:|:-:|:-:
data|LocalDate|sim|campo para armazenar a data
valor|BigDecimal|sim|campo para armazenar o valor
enviadoRecebido|String|sim|campo para armazenar o tipo, se é enviado ou recebido.
horaio|LocalTime|sim|campo para armazenar o horario
**Exemplo de corpo da resposta**

```JSON
{
  "data": "2023-04-08",
  "valor": 1500.00,
  "enviadoRecebido": "enviado",
  "horario": "14:30:00"
}
```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | Extrato coletado
| 404 | Nenhuma transação ate o momento

### Extrato

<br/>

`GET` /transactions

<br/>

**Exemplo de corpo da resposta**

```JSON
{
  "id": 12345,
  "data": "2023-04-08",
  "valor": 1500.00,
  "enviadoRecebido": "enviado",
  "horario": "14:30:00"
}
```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | Extrato coletado
| 404 | Nenhuma transação ate o momento

### Criar Endereço

<br/>

`POST` /adress

<br/>

**Campos da requisição**
|   Campo  |    tipo    |   Obrigatorio | Descrição
|:-:|:-:|:-:|:-:
cep|String|sim|Campo para armazenar o CEP
estado|String|sim|Campo para armazenar o estado
cidade|String|sim|Campo para armazenar a cidade
bairro|String|sim|Campo para armazenar o bairro
rua|String|sim|Campo para armazenar o lougradouro

**Exemplo de payload**

```JSON
   {
      "logradouro": "Rua Domingos de Morais, 1234",
      "CEP": "12345-678",
      "bairro": "Vila Mariana",
      "estado": "São Paulo",
      "cidade": "São Paulo"
   }
```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | Endereço cadastrado!
| 400 | Campo invalido (A API vai informar qual campo esta incorreto)


### Atualizar Endereço

<br/>

`PUT` /adress{id}

<br/>

**Campos da requisição**
|   Campo  |    tipo    |   Obrigatorio | Descrição
|:-:|:-:|:-:|:-:
cep|String|sim|Campo para armazenar o CEP
estado|String|sim|Campo para armazenar o estado
cidade|String|sim|Campo para armazenar a cidade
bairro|String|sim|Campo para armazenar o bairro
rua|String|sim|Campo para armazenar o lougradouro

**Exemplo de payload**

```JSON
   {
      "logradouro": "Rua dos loucos, 0",
      "CEP": "12345-678",
      "bairro": "Capão Redondo",
      "estado": "São Paulo",
      "cidade": "São Paulo"
   }
```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | Endereço atualizado
| 400 | Campo invalido (A API vai informar qual campo esta incorreto)


### Listar os materiais reciclaveis

<br/>

`GET` /materials

<br/>


**Exemplo de corpo da resposta**

```JSON
{
  "materiais":[
    {
        "nome": "Papelão",
        "valor": "0.12",
        "tipo": "Papel"
    },
    {
        "nome": "Garrafa Pet",
        "valor": "1.40",
        "tipo": "Plástico"
    },
    {
        "nome": "Latinha de refigerante",
        "valor": "5.35",
        "tipo": "Aluminio"
    },
    {
        "nome": "Garrafa de Vidro",
        "valor": "3.79",
        "tipo": "Vidro"
    },
  ]
}
```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | Lista de materiais coletada
| 404 | Lista esta vazia