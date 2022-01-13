
CREATE SCHEMA IF NOT EXISTS InventoryTracker;

USE InventoryTracker;

DROP TABLE IF EXISTS ProductLog;
DROP TABLE IF EXISTS Products;

CREATE TABLE Products (
  productID INT NOT NULL,
  poName VARCHAR(255) NOT NULL UNIQUE,
  quantity INT NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  currency VARCHAR(10) NOT NULL,
  PRIMARY KEY (productID));

CREATE TABLE ProductLog (
  logID INT NOT NULL AUTO_INCREMENT,
  productID INT NOT NULL,
  quantity INT NOT NULL,
  date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (logID),
  CONSTRAINT fk_productID 
  FOREIGN KEY (productID) REFERENCES Products(productID) ON DELETE CASCADE);
 
DELIMITER //
CREATE TRIGGER LogUpdateTrigger 
AFTER UPDATE 
ON Products 
FOR EACH ROW
BEGIN
	INSERT INTO ProductLog(productID, quantity) VALUES (Old.productID, Old.quantity);
END;
//

INSERT INTO Products(productID, poName, quantity, price, currency) VALUES (1, "Small Computer Desk 32 Inch", 50, 79.99, "USD");
INSERT INTO Products(productID, poName, quantity, price, currency) VALUES (2, "Samsung - 55 inch Q70A QLED 4K Ultra HD HDR Smart TV", 25, 1127.0, "HKD");
INSERT INTO Products(productID, poName, quantity, price, currency) VALUES (3, "Eccho Dot (4th) Gen", 15, 71.45, "USD");
INSERT INTO Products(productID, poName, quantity, price, currency) VALUES (4, "Alexa Voice Remote (3rd Gen)", 5, 49.99, "CAD");
INSERT INTO Products(productID, poName, quantity, price, currency) VALUES (5, "Yamaha F325D Acoustic Guitar", 27, 199.99, "USD");
INSERT INTO Products(productID, poName, quantity, price, currency) VALUES (6, "Sony MDRZX110 Over-Ear Headphones (Black)", 122, 530.2, "HKD");
INSERT INTO Products(productID, poName, quantity, price, currency) VALUES (7, "Skullcandy Jib Earbuds with Microphone, Black (S2DUYK-343)", 69, 19.99, "USD");
