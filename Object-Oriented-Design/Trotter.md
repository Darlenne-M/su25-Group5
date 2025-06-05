# Trotter - Software Design 

Version 1  
Prepared by Darlenne Noemi Mosqueda-Arredondo & Sarah Robinson\
Trotter\
June 4, 2025

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Product Overview](#1-product-overview)
* 2 [Use Cases](#2-use-cases)
  * 2.1 [Use Case Model](#21-use-case-model)
  * 2.2 [Use Case Descriptions](#22-use-case-descriptions)
    * 2.2.1 [Actor: Provider](#221-actor-provider)
    * 2.2.2 [Actor: Customer](#222-actor-customer) 
* 3 [UML Class Diagram](#3-uml-class-diagram)
* 4 [Database Schema](#4-database-schema)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|  DM  | 6/04    | Initial Design      |    1      |
|      |         |                     |           |
|      |         |                     |           |

## 1. Product Overview
Trotter is a simple, intuitive web app that makes it easy for pet owners to find trusted care and services for their furry companions. Providers and customers make use of the centralized platform to meet their needs. Providers create and publish pet-related services, customers sign up for any available services that they are interested in.

## 2. Use Cases
### 2.1 Use Case Model
![Use Case Model](https://github.com/Darlenne-M/su25-Group5/blob/BackendAPI-Darlenne/Object-Oriented-Design/use-case-model.png)

### 2.2 Use Case Descriptions

#### 2.2.1 Actor: Provider
##### 2.2.1.1 Sign Up
A provider can sign up to create their profile with their first Name, last name, address, city, zip code, phone number, email, and password

##### 2.2.1.2 Log In
A provider shall be able to sign in using their registred email and password. After logging in, the provider shall be directed their dashboard where they see an overview of their services and bookings.
##### 2.2.1.3 Update Profile
A provider shall be to modify their profile by going to their profile page. They can change their email, password, certificates, phone number, name, address.
##### 2.2.1.4 Create Class
The provider shall be able to create a new service. They would provide a service name, description, experience, pricing, preferred contact method, service locations, travel radius, and an image path. This service will be created to be associated with only this provider.
##### 2.2.1.4 Manage Class Content
A proider shall be able to accept and decline upcoming appointments, as well as reply to customer reviews.

#### 2.2.2 Actor: Student
##### 2.2.2.1 Sign Up
A student can sign up to create their profile with their name, email, password, and bio. Emails must be unique.
##### 2.2.2.2 Log In
A teacher shall be able to sign in using their registred email and password. After logging in, the student shall be directed their dashboard where they see an overview of their classes and stats.
##### 2.2.2.3 Browse Classes
A student shall be able to view available classes. They can do this from the home page or using a search function. They can also filter classes by name, subject, or teacher. They will also be able to select one class and view more details.
##### 2.2.1.4 Sign Up for Class
Upon selecting a class, a student shall be able to sign up for the class usin a one-click action. This class will then appear on their dashboard, and they will be able to participate in the class.
##### 2.2.1.5 Drop Class
A student may drop/unregister for a class from the class page.

## 3. UML Class Diagram
![UML Class Diagram](https://github.com/Darlenne-M/su25-Group5/blob/BackendAPI-Darlenne/Object-Oriented-Design/provider-class-diagram-Darlenne.png)
## 4. Database Schema
![UML Class Diagram](https://github.com/Darlenne-M/su25-Group5/blob/BackendAPI-Darlenne/Object-Oriented-Design/provider-database-schema-Darlenne.png))
