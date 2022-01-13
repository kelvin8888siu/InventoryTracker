# InventoryTracker
Inventory Tracker Web Application

## About this Project

An inventory tracking web application that consists of the following functionalities/features:
1.	Creating inventory items
2.	Editing/Updating inventory items
3.	Deleting specific inventory items
4.	Viewing all inventory items or a specific inventory item
5.	Exporting all inventory data into a CSV file

### Demo:
https://user-images.githubusercontent.com/93673736/149422527-f6781251-d36f-4b2a-b061-138c1542fd8e.mov

### Web Page Screenshots:

#### Inventory Page:
![image](https://user-images.githubusercontent.com/93673736/149423112-4228656b-32ff-49f9-80f8-6ddeead6ca00.png)


#### Add Product Page:
![image](https://user-images.githubusercontent.com/93673736/149423175-3b605f76-43ca-4575-83e4-c13ec9edaa7e.png)


#### Edit/Update Product Page:
![image](https://user-images.githubusercontent.com/93673736/149423188-e3adafdb-0112-453e-a885-1517bdd4a36b.png)

#### Built with:
-	[MySQL](https://www.mysql.com/)
-	[Spring Boot](https://spring.io/projects/spring-boot)
-	[Swagger](https://swagger.io/)
-	[Bootstrap](https://getbootstrap.com/)
-	[Thymeleaf](https://www.thymeleaf.org/)

## Getting Started

Below are instructions and steps for running the web application locally.

### Prerequisites

Download and install the latest version of [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) and [IntelliJ](https://www.jetbrains.com/idea/download/#section=mac).

### Installation
1.	Download the code by either:
    -	Downloading the ZIP file and unzip the file. Open the unzip file using IntelliJ. 
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

6.	At this point everything is set up properly! Run the program! 












