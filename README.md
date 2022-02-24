# Bank API

## Overview
The project runs through an RESTful API and create some essential functions related to managing bank accounts in Java <br>
JPA with Hibernate implementation is used to persist data in the database. <br>
Bellow there is a class diagram that represents the project:
![alt text](https://github.com/Schinaman/donus-challenge/blob/master/ClassDiagram.JPG)


## Restrictions:
*To open an account you only need the person's full name and CPF, but only one account is allowed per person; <br>
*With this account it is possible to make transfers to other accounts and deposit; <br>
*Transactions only allow Transfer and Deposit methods;<bR>
*Negative amounts on accounts are not allowed;<br>
*Deposit transaction cannot be greater than R$2,000; <br>
*Transfers between accounts are free and unlimited;


## Endpoints


<br>

__GET__ <br>
The GET method return clients for the following endpoint. <br>
http://localhost:8080/pf <br>

Response example:

```
[
    {
        "fullName": "Guiga",
        "cpf": "37322979850"
    },
    {
        "fullName": "Juquinha",
        "cpf": "37322979851"
    }
]
```

The GET method return accounts for the following endpoint. <br>
http://localhost:8080/contas <br>
Response example:

```
[
    {
        "balance": 0.0,
        "pf": {
            "fullName": "Guiga",
            "cpf": "37322979850"
        },
        "cpf": "37322979850"
    },
    {
        "balance": 0.0,
        "pf": {
            "fullName": "Juquinha",
            "cpf": "37322979851"
        },
        "cpf": "37322979851"
    }
]
```
The GET method return deposits for the following endpoint. <br>
http://localhost:8080/deposits <br>
Response example:

```
    {
        "id": 1,
        "amountDeposit": 1.0,
        "account": {
            "balance": 0.0,
            "pf": {
                "fullName": "Juquinha",
                "cpf": "37322979851"
            },
            "cpf": "37322979851"
        }
    }
```

The GET method return transfers for the following endpoint. <br>
http://localhost:8080/transfers <br>
Response example:

```
{
        "id": 1,
        "amountTransfer": 100.0,
        "accountFrom": {
            "balance": 0.0,
            "pf": {
                "fullName": "Juquinha",
                "cpf": "37322979851"
            },
            "cpf": "37322979851"
        },
        "accountTo": "37322979850"
    }
```

**POST** <br>
Attached to the project there is a Postman Collection where you can find and test all the post methods. <br>


## Test environment

Change profile to "test" in the "application.properties" file. <br>
Test environment database uses Spring Boot - H2 Database <br> 
It can be accessed from the following URI: <br>
//localhost:&#60;port&#62;/h2-console/
