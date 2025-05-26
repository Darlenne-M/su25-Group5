# su25-Group5

# Software Requirements Specification
## For Trotter

Version 0.1  
Prepared by Darlenne Noemi Mosqueda-Arredondo & Sarah Robinson  
CSC 340  
May 26, 2025 

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Introduction](#1-introduction)
  * 1.1 [Document Purpose](#11-document-purpose)
  * 1.2 [Product Scope](#12-product-scope)
  * 1.3 [Definitions, Acronyms and Abbreviations](#13-definitions-acronyms-and-abbreviations)
  * 1.4 [References](#14-references)
  * 1.5 [Document Overview](#15-document-overview)
* 2 [Product Overview](#2-product-overview)
  * 2.1 [Product Functions](#21-product-functions)
  * 2.2 [Product Constraints](#22-product-constraints)
  * 2.3 [User Characteristics](#23-user-characteristics)
  * 2.4 [Assumptions and Dependencies](#24-assumptions-and-dependencies)
* 3 [Requirements](#3-requirements)
  * 3.1 [Functional Requirements](#31-functional-requirements)
    * 3.1.1 [User Interfaces](#311-user-interfaces)
    * 3.1.2 [Hardware Interfaces](#312-hardware-interfaces)
    * 3.1.3 [Software Interfaces](#313-software-interfaces)
  * 3.2 [Non-Functional Requirements](#32-non-functional-requirements)
    * 3.2.1 [Performance](#321-performance)
    * 3.2.2 [Security](#322-security)
    * 3.2.3 [Reliability](#323-reliability)
    * 3.2.4 [Availability](#324-availability)
    * 3.2.5 [Compliance](#325-compliance)
    * 3.2.6 [Cost](#326-cost)
    * 3.2.7 [Deadline](#327-deadline)

## Revision History
|   Name   | Date    | Reason For Changes  | Version   |
|   ----   | ------- | ------------------- | --------- |
|Darlenne  | 5/26/25 |     Initial SRS     |   1.0     |
|          |         |                     |           |
|          |         |                     |           |

## 1. Introduction

### 1.1 Document Purpose
The purpose of this Software Requirements Document (SRD) is to describe the client-view and developer-view requirements for the Trotter application. This document outlines the functional and non-functional requirements, system constraints, interface descriptions, and other key technical details necessary for the design, development, and deployment of the application.

### 1.2 Product Scope
The purpose of the Trotter system is to make it easy for pet owners to find trusted care and services for their furry companions, while also providing a platform for service providers to easily list and manage their services. The system is based on a relational database with its pet-related service management and booking functions. We will have a database server supporting providers of different pet-related services.

### 1.3 Definitions, Acronyms and Abbreviations |                                                                                                         
| Reference         | Definition                          |
|-------------------|--------------------------------------|
| Java              | A programming language originally developed by James Gosling at Sun Microsystems. We will be using this language to build Trotter.   |
| Postgresql  | Open-source relational database management system.|
| SpringBoot   | 	An open-source Java-based framework used to create a micro Service. This will be used to create and run our application.             |
| Spring MVC           | Model-View-Controller. This is the architectural pattern that will be used to implement our system. 
| Spring Web           | Will be used to build our web application by using Spring MVC. This is one of the dependencies of our system.             |            |
| API    | Application Programming Interface. This will be used to interface the backend and the fronted of our application.              |
| HTML           | 	Hypertext Markup Language. This is the code that will be used to structure and design the web application and its content.             |
| CSS   | Cascading Style Sheets. Will be used to add styles and appearance to the web app.              |
| JavaScript          | An object-oriented computer programming language commonly used to create interactive effects within web browsers.Will be used in conjuction with HTML and CSS to make the web app.            |
| VS Code    |  An integrated development environment (IDE) for Java. This is where our system will be created.             |

### 1.4 References
https://spring.io/guides

https://getbootstrap.com/

### 1.5 Document Overview
Section 1 is a general introduction to the document, intended for any readers. Section 2 is focused on the product and its features. This section is for customers and business stakeholders. Section 3 specifies the requirements and constraints for the product and development process. This section is intended for all stakeholders, especially the development team.

## 2. Product Overview
Trotter is a simple, intuitive web app that makes it easy for pet owners to find trusted care and services for their furry companions. Providers and customers make use of the centralized platform to meet their needs. Providers create and publish pet-related services, customers sign up for any available services that they are interested in. Trotter supports two main user roles: customers (pet owners) and providers (service businesses or individuals offering pet care). The system enables customers to register, browse available services, make bookings, and leave reviews. At the same time, providers can create and manage service listings, respond to reviews, and monitor customer activity and performance analytics.

### 2.1 Product Functions
 Service providers can use the platform to list and manage services that cater to pet owners' needs, while customers can easily discover and book the right care for their pets. A key feature of our website is real-time updates during service visits, if time allows, enhancing transparency and peace of mind.

### 2.2 Product Constraints
The program requires a computer with Java JDK 21 installed to run. Due to a tight development timeline of four weeks, some features may need to be deprioritized or removed before the initial release. Since we are using Postgresql database to store the information, the system may struggle to support more users, more data, or more activity without performance issues or limitations.
  
### 2.3 User Characteristics
Our web application is designed to be intuitive and user-friendly, requiring no prior computer knowledge beyond basic web browsing skills. As long as users know the services they're looking for, they can quickly become proficient with the platform after just a few uses.

## 3. Requirements

### 3.1 Functional Requirements
- FR0: The system will allow users to create accounts as either a provider or a client.
  - Each account will have a unique identifier assigned at the time of creation.
- FR1: The system will allow providers to create a new service by providing details including service title, price, brief description, location, cancellation policy, and availability.
- FR2: The system will allow providers to view client statistics.
- FR4: Provider's will have the authority to accept or deny any client bookings.
- FR5: Users will be able to modify or remove their own profiles at any time.
- FR6: The system will allow provider's to reply to clients reviews.


#### 3.1.1 User interfaces
Web pages using HTML, CSS, and JavaScript.

1. Home Page
- Navigation bar with links to "Browse Services", "Book Now", "About Us", and "Contact". Search bar for finding services by keyword or location.

2. Service Listings Page
- Displays available services. Each listing includes a title, price, provider name, brief description, and a "Book Now" button.

3. Service Detail Page
- Detailed information about the service. Provider profile, availability calendar, and user reviews. Option to select date/time and proceed with booking.

4. Booking Interface
- Form with input fields for service details, time, contact information. Confirmation screen before final submission.

#### 3.1.2 Hardware interfaces
Devices that have web browser capabilities.

#### 3.1.3 Software interfaces
- Java jdk 21
- PostgreSQL 17
- SpringBoot 3.4.5

