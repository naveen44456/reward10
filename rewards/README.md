## Environment:
- Java version: 1.8
- Maven version: 3.*
- Spring Boot version: 2.5.6

## Read-Only Files:
- src/test/*

## Data:
Example of a customer data JSON object:
```json
{
   "id": 1,
   "name": "James",
   "emailId": "James@gmail.com",
   "contactNumber": "+1 (513) 888-1234"
}
```

Example of a order data JSON object:
```json
{ 
   "customer_id": 1,
   "price": 120,
   "order_date": "06-30-2023"
}
```

## Requirements:

 Your GitHub URL for the completed homework assignment below (as a reminder, please do not rush through it as they are very selective in who they decide to interview based on the homework assignment quality):

 

WebAPI Developer

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

 

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction.

(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

 

Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.

 

·         Solve using Spring Boot

·         Create a RESTful endpoint

·         Make up a data set to best demonstrate your solution

·         Check solution into GitHub

 

## Commands
- run: 
```bash
mvn clean package; java -jar target/rewards-0.0.1-SNAPSHOT.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```


