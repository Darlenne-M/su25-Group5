# su25-Group5

# Software Requirements Specification
## For Trotter

Version 0.1  
Prepared by Darlenne Noemi Mosqueda & Sarah Robinson  
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
The purpose of this Software Requirements Document (SRD) is to describe the client-view and developer-view requirements for the Trotter application.

### 1.2 Product Scope
The purpose of the Trotter system is to make it easy for pet owners to find trusted care and services for their furry companions, while also providing a platform for service providers to easily list and manage their services. The system is based on a relational database with its pet-related service management and booking functions. We will have a database server supporting providers of different pet-related services.


### 1.3 Definitions, Acronyms and Abbreviations |                                                                                                         
| Reference         | Definition                          |
|-------------------|--------------------------------------|
| Java              | A programming language originally developed by James Gosling at Sun Microsystems. We will be using this language to build Trotter.   |
| Postgresql  | Open-source relational database management system.|
| SpringBoot   | 	An open-source Java-based framework used to create a micro Service. This will be used to create and run our application.             |
| Spring MVC           | Model-View-Controller. This is the architectural pattern that will be used to implement our system. 
| Spring Web           | Will be used to build our web application by using Spring MVC. This is one of the dependencies of our system. feedback             |            |
| API    | Application Programming Interface. This will be used to interface the backend and the fronted of our application.              |
| HTML           | 	Hypertext Markup Language. This is the code that will be used to structure and design the web application and its content.             |
| CSS   | Cascading Style Sheets. Will be used to add styles and appearance to the web app.              |
| JavaScript          | An object-oriented computer programming language commonly used to create interactive effects within web browsers.Will be used in conjuction with HTML and CSS to make the web app. feedback             |
| VS Code    |  An integrated development environment (IDE) for Java. This is where our system will be created.             |

### 1.4 References
https://spring.io/guides

https://getbootstrap.com/

### 1.5 Document Overview
Section 1 is a general introduction to the document, intended for any readers. Section 2 is focused on the product and its features. This section is for customers and business stakeholders. Section 3 specifies the requirements and constraints for the product and development process. This section is intended for all stakeholders, especially the development team.

## 2. Product Overview
This section should describe the general factors that affect the product and its requirements. This section does not state specific requirements. Instead, it provides a background for those requirements, which are defined in detail in Section 3, and makes them easier to understand.

### 2.1 Product Functions
Summarize the major functions the product must perform or must let the user perform. Details will be provided in Section 3, so only a high level summary (such as a bullet list) is needed here. Organize the functions to make them understandable to any reader of the SRS. A picture of the major groups of related requirements and how they relate, such as a top level data flow diagram or object class diagram, is often effective.

### 2.2 Product Constraints
This subsection should provide a general description of any other items that will limit the developer’s options. These may include:  

* Interfaces to users, other applications or hardware.  
* Quality of service constraints.  
* Standards compliance.  
* Constraints around design or implementation.
  
### 2.3 User Characteristics
Identify the various user classes that you anticipate will use this product. User classes may be differentiated based on frequency of use, subset of product functions used, technical expertise, security or privilege levels, educational level, or experience. Describe the pertinent characteristics of each user class. Certain requirements may pertain only to certain user classes. Distinguish the most important user classes for this product from those who are less important to satisfy.

## 3. Requirements

### 3.1 Functional Requirements 
This section specifies the software product's requirements. Specify all of the software requirements to a level of detail sufficient to enable designers to design a software system to satisfy those requirements, and to enable testers to test that the software system satisfies those requirements.

The specific requirements should:
* Be uniquely identifiable.
* State the subject of the requirement (e.g., system, software, etc.) and what shall be done.
* Optionally state the conditions and constraints, if any.
* Describe every input (stimulus) into the software system, every output (response) from the software system, and all functions performed by the software system in response to an input or in support of an output.
* Be verifiable (e.g., the requirement realization can be proven to the customer's satisfaction)
* Conform to agreed upon syntax, keywords, and terms.

#### 3.1.1 User interfaces
Define the software components for which a user interface is needed. Describe the logical characteristics of each interface between the software product and the users. This may include sample screen images, any GUI standards or product family style guides that are to be followed, screen layout constraints, standard buttons and functions (e.g., help) that will appear on every screen, keyboard shortcuts, error message display standards, and so on. Details of the user interface design should be documented in a separate user interface specification.

Could be further divided into Usability and Convenience requirements.

#### 3.1.2 Hardware interfaces
Describe the logical and physical characteristics of each interface between the software product and the hardware components of the system. This may include the supported device types, the nature of the data and control interactions between the software and the hardware, and communication protocols to be used.

#### 3.1.3 Software interfaces
Describe the connections between this product and other specific software components (name and version), including databases, operating systems, tools, libraries, and integrated commercial components. Identify the data items or messages coming into the system and going out and describe the purpose of each. Describe the services needed and the nature of communications. Refer to documents that describe detailed application programming interface protocols. Identify data that will be shared across software components. If the data sharing mechanism must be implemented in a specific way (for example, use of a global data area in a multitasking operating system), specify this as an implementation constraint.

