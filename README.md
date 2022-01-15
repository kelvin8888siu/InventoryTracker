# InventoryTracker

### Table of Contents
1. [About this Project](#about)
    -  [Project Overview](#overview)
        - [Database](#db)
        - [API Endpoints and Methods](#api)
    - [Built With](#builtwith)
2. [Getting Started](#started)
    -   [Prerequisites](#preq)
    -   [Installation](#install)
    -   [Running Postman](#rp)
3. [Contact](#contact)

<a name=about></a>
## About this Project

This is a [coding challenge](https://docs.google.com/document/d/1z9LZ_kZBUbg-O2MhZVVSqTmvDko5IJWHtuFmIu_Xg1A/edit) for the Shopify (Summer 2022) backend developer internship position.

In this project, an inventory tracking web API was developed for a logistics company. The API consists of the following functionalities/features:
1.	Creating inventory items
2.	Editing/Updating inventory items
3.	Deleting specific inventory items
4.	Viewing all inventory items or a specific inventory item
5.	Exporting all inventory data into a CSV file

<a name=overview></a>
### Project Overview:

<img width="623" alt="Screen Shot 2022-01-15 at 3 14 14 PM" src="https://user-images.githubusercontent.com/93673736/149636404-a8c88c9b-9cb7-4be4-a8c1-3a43d77fc657.png">

Multiple frameworks were utilized during the development of this web API but communicating with the API requires the use of the Postman API platform. Postman is an API platform used to ensure that the process of sending and recieving data from our web API is functioning properly. It is important to consider that the Postman API platform is simply a way to communicate and interact with our web API. Postman is not a tool for performance testing or for dealing with user interactions.

<a name=db></a>
#### Database:

<img width="792" alt="Screen Shot 2022-01-15 at 3 19 23 PM" src="https://user-images.githubusercontent.com/93673736/149636528-c267c433-454c-4c38-8dc6-35c1eeeb9aed.png">

A relational database was chosen for this project. The file named InventoryTracker.sql will contain the schema for the database above. Mock data is also included in the script, which will be neccessary when testing the web API with Postman.

The Products table will store all the information regarding the specific attributes of a particular inventory item. More specifically, each inventory item will have the following attributes: product ID, product name, quantity in stock, price per unit and currency code. The ProductLog table will keep a history of all the quantity updates that have been made to items in the Products table. 

The ProductLog table was initially created for the purpose of implementing a feature where a report on the most in-stock and out-of-stock items in the inventory is generated. However, this feature was abandoned halfway through the production of the web API. Instead, a feature where the inventory data can be exported to a CSV file was implemented. In the end, the ProductLog table was kept in the program because the information that can be derived from the table can ultimately be useful for other feature implementations in the future.

<a name=api></a>
#### API Endpoints and Methods:

<img width="575" alt="Screen Shot 2022-01-15 at 4 03 29 PM" src="https://user-images.githubusercontent.com/93673736/149637634-daa3991d-e9aa-4f07-b4d8-84c273495880.png">

<a name=builtwith></a>
### Built With:
-	[MySQL](https://www.mysql.com/)
-	[Spring Boot](https://spring.io/projects/spring-boot)
-	[Swagger](https://swagger.io/)

<a name=started></a>
## Getting Started

Below are instructions and steps for running the web API as well as Postman.

<a name=preq></a>
### Prerequisites

Download and install the latest version of [MySQL Workbench](https://dev.mysql.com/downloads/workbench/), [IntelliJ](https://www.jetbrains.com/idea/download/#section=mac), and [Postman](https://www.postman.com/downloads/).

<a name=install></a>
### Installation
1.	Download the code by either:
    - Downloading the ZIP file and unzip the file. Open the unzip file using IntelliJ. 
    - Opening IntelliJ > Get from VCS > URL
    
      ![image](https://user-images.githubusercontent.com/93673736/149423967-cc9640b1-9ba9-437f-a8ba-defbedf7381e.png)
    
      Ensure that the version control is Git and the project is in a directory that is accessible. Paste the following Git URL into IntelliJ or:
      https://github.com/kelvin8888siu/InventoryTracker.git
    
      This link can also be found on the GitHub repository. 


2.	Open MySQL Workbench and set up a new connection. Open a SQL script file in a new query tab and the SQL script file that should be open can be found in the downloaded repository code where the file is named InventoryTracker.sql file. Execute the script.

    ![image](https://user-images.githubusercontent.com/93673736/149424112-7655f2ae-6f79-4cbc-ad08-25b6c42ca0bc.png)

3. Access application.properties by following the steps below:

   src > main > java > resources > application.properties 
   
   ![image](https://user-images.githubusercontent.com/93673736/149424209-c516ae48-5c1b-4da6-b0a2-fcc86277606b.png)
   
   Update the information above based on the way that the database connection was set up in the previous step.

4.	Access ConnManager by following the steps below:
    
    src > main > java > com.example.Inventory > ORM > ConnManager

    ![image](https://user-images.githubusercontent.com/93673736/149424288-7e9cb8a2-22b3-4ecc-8bb0-ee5c628e3e9f.png)

    Similar to the previous step, update the attributes in the class above based on the way that the database connection was set up.

5.	Access the pom.xml file and click on the reload all maven projects button in the upper left corner, which will allow all dependencies to be loaded/reloaded. 

    ![image](https://user-images.githubusercontent.com/93673736/149424302-78d38de0-4fd6-4f1c-84bd-0e9f491cda1c.png)

6.	The web API is now set up on IntelliJ. Click on the Run button on the right corner of IntelliJ to start running the web API.
    
    <img width="305" alt="Screen Shot 2022-01-15 at 5 15 03 PM" src="https://user-images.githubusercontent.com/93673736/149639339-18dc3985-f286-4168-a765-fab0cac21af7.png">


<a name=rp></a>
### Running Postman:

1. To interact with the web API, open Postman and import the file named Inventory API.postman_collection.json. Please follow the steps below:
    
   Open Postman > File > Import > Drag the file named: Inventory API.postman_collection.json
   
   <img width="745" alt="Screen Shot 2022-01-15 at 4 38 04 PM" src="https://user-images.githubusercontent.com/93673736/149638505-81a89b47-e539-47cb-84f8-b710a2a68268.png">
   
2. To understand the tests that have been written for each endpoint, click on the dropdown button next to the Inventory API collection on the left sidebar. Click on any of the endpoints or http method tabs desired below. To see the tests, click on "Tests" (Note: for POST and PUT methods, "Body" and "Pre-request Script" can also provide additional information about the underlying testing mechanism).  

    <img width="1054" alt="Screen Shot 2022-01-15 at 5 06 01 PM" src="https://user-images.githubusercontent.com/93673736/149639152-2b382ba3-b47a-4fe2-983b-ddbbd37ba8aa.png">

3. To run the all automated tests, click on the Runner button on the lower right corner of the Postman application.

   <img width="872" alt="Screen Shot 2022-01-15 at 4 42 44 PM" src="https://user-images.githubusercontent.com/93673736/149638617-1c576546-0379-4307-aba9-f06f23cd3d7c.png">


4.  Click and drag the Inventory API collection from the left sidebar and drop the collection into the right side console that states "Drag a collection or folder from your sidebar to get started".

    <img width="932" alt="Screen Shot 2022-01-15 at 4 48 27 PM" src="https://user-images.githubusercontent.com/93673736/149638771-4cc1743f-afe4-45e7-81fd-7bc3caab4e8d.png">

5. Change the iteration from 1 to 10 and check "Save responses". The run order of the tests should NOT be changed.

    <img width="685" alt="Screen Shot 2022-01-15 at 4 51 22 PM" src="https://user-images.githubusercontent.com/93673736/149638830-41d601b9-48b7-4ca9-a539-32677b739b7d.png">

6. Click "Run Inventory API" to run all the automated tests. After running the test, Postman will allow for viewing the results or result summary. Results can also be exported.

    <img width="1060" alt="Screen Shot 2022-01-15 at 5 11 08 PM" src="https://user-images.githubusercontent.com/93673736/149639258-d439fa53-6bbe-4daf-81b0-62608ac49131.png">

7. To download the CSV file.

   Click on the exportCSV tab on the left side bar > Click "Send" > Click on the "Save Response" dropdown button > Click "Save to a file"
   
   <img width="1038" alt="Screen Shot 2022-01-15 at 5 10 27 PM" src="https://user-images.githubusercontent.com/93673736/149639237-e0c8e0f6-ff2f-40c5-b267-a2fe6b8878cc.png">

<a name=contact></a>
## Contact

Work email: kelvinsiu8888work@gmail.com

School email: siu.ka@northeastern.edu

Project link: https://github.com/kelvin8888siu/InventoryTracker

Linkedin: https://www.linkedin.com/in/kelvin-siu-7b6297160/













