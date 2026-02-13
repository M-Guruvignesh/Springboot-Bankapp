# 🏦 Bank Management Application

A simple RESTful Bank Management System built using Spring Boot.
This project was created for learning purposes by following SJ Programming Solutions tutorials.

## 🚀 Features

* Create Account
* View Account by Account Number
* View All Accounts
* Deposit Money
* Withdraw Money
* Delete Account

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## 🔗 API Endpoints

POST `/accounts` – Create account
GET `/accounts/{accountNumber}` – Get account by ID
GET `/accounts` – Get all accounts
PUT `/accounts/{accountNumber}/deposit?amount=1000` – Deposit money
PUT `/accounts/{accountNumber}/withdraw?amount=500` – Withdraw money
DELETE `/accounts/{accountNumber}` – Delete account

## ⚙️ Run the Project

1. Clone the repository
2. Configure `application.properties` with your MySQL credentials
3. Run:

mvn spring-boot:run

Application runs at:
[http://localhost:9092](http://localhost:9092)

## 📚 Learning Outcome

* REST API Development
* CRUD Operations
* Layered Architecture
* JPA & Hibernate Integration

## 👨‍💻 Author

Guruvignesh M
[GitHub Profile](https://github.com/M-Guruvignesh/Springboot-Bankapp) 
