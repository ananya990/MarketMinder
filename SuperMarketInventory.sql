create database SupermarketInventorydb;

use SupermarketInventory;

CREATE TABLE department (
    deptID VARCHAR(10) PRIMARY KEY,
    deptName VARCHAR(50) NOT NULL,
    deptManager VARCHAR(50) NOT NULL,
    eid INT,
    FOREIGN KEY (eid) REFERENCES employee(eid)
);

CREATE TABLE employee (
    eid INT PRIMARY KEY,
    ename VARCHAR(50) NOT NULL,
    eemail VARCHAR(50),
    ephoneNumber VARCHAR(50) NOT NULL,
    eaddress VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    joinDate DATE NOT NULL,
    endDate DATE,
    salary DOUBLE NOT NULL
);

-- Create Supplier table
CREATE TABLE supplier (
    sid VARCHAR(10) PRIMARY KEY,
    sname VARCHAR(50) NOT NULL,
    semail VARCHAR(50) NOT NULL,
    saddress VARCHAR(100),
    sphoneNumber VARCHAR(20)
);

-- Create table for contacts_orders
CREATE TABLE contacts_orders (
    eid INT NOT NULL,
    sid VARCHAR(10) NOT NULL,
    orderDate DATE,
    orderStatus DATE,
    PRIMARY KEY (eid, sid),
    FOREIGN KEY (eid) REFERENCES employee(eid),
    FOREIGN KEY (sid) REFERENCES supplier(sid)
);

-- Create Warehouse table
CREATE TABLE warehouse (
    ptype VARCHAR(50) NOT NULL PRIMARY KEY,
    quantity VARCHAR(50) NOT NULL,
    sid VARCHAR(10) NOT NULL,
    FOREIGN KEY (sid) REFERENCES supplier(sid)
);

-- Create Product table
CREATE TABLE product (
    pid VARCHAR(20) PRIMARY KEY,
    pname VARCHAR(50) NOT NULL,
    ptype VARCHAR(50) NOT NULL,
    prize VARCHAR(50) NOT NULL,
    FOREIGN KEY (ptype) REFERENCES warehouse(ptype)
);

-- Create table for stock_check
CREATE TABLE stock_check (
    deptID VARCHAR(10),
    ptype VARCHAR(20),
    checkDate DATE,
    orderRequired VARCHAR(10),
    PRIMARY KEY (deptID, ptype),
    FOREIGN KEY (deptID) REFERENCES department(deptID),
    FOREIGN KEY (ptype) REFERENCES warehouse(ptype)
);

-- Create Customer table
CREATE TABLE customer (
    cid INT PRIMARY KEY,
    cname VARCHAR(50) NOT NULL,
    caddress VARCHAR(100),
    cphoneNumber VARCHAR(20)
);

-- Create Purchases table
CREATE TABLE purchases (
	purchaseID INT PRIMARY KEY , 
    purchaseDate DATE, 
    totalAmt DOUBLE,
    cid INT,
    pid VARCHAR(20),
    FOREIGN KEY (cid) REFERENCES customer(cid),
    FOREIGN KEY (pid) REFERENCES product(pid)
);

-- Create Promotion table
CREATE TABLE promotion (
    promoCode VARCHAR(20) PRIMARY KEY,
    promoName VARCHAR(100) NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    discountPercentage DECIMAL(5, 2) NOT NULL
);

INSERT INTO employee (eid, ename, eemail, ephoneNumber, eaddress, dob, joinDate, endDate, salary) 
VALUES
    (101, 'Ruchi Garg', 'ruchi@gmail.com', '1234567890', '123 Main St', '1990-01-01', '2020-01-01', NULL, 50000),
    (102, 'Jane Smith', 'jane@gmail.com', '9876543210', '456 Elm St', '1992-05-15', '2021-02-15', NULL, 55000),
    (103, 'Shiv Gupta', 'shiv@gmail.com', '6793450876', '977 Main St', '1984-05-15', '2009-01-01', '2021-01-15', 67000),
    (104, 'Priya Arora', 'priya@gmail.com', '5551234567', '789 Oak St', '1985-09-20', '2019-03-10', NULL, 60000),
    (105, 'Riya Dingra', 'riya@gmail.com', '4449876543', '101 Pine St', '1988-12-10', '2018-07-20', NULL, 48000),
    (108, 'Mohit Gupta', 'mohit@gmail.com', '3334567890', '202 Cedar St', '1993-04-30', '2022-04-30', NULL, 52000),
    (120, 'Rahul', 'rahul@gmail.com', '2229876543', '303 Maple St', '1987-07-25', '2023-01-15', NULL, 58000),
    (121, 'Sophia Minn', 'sophia@gmail.com', '1111234567', '404 Walnut St', '1991-11-05', '2020-09-10', NULL, 51000),
    (122, 'David Taylor', 'david@gmail.com', '9999876543', '505 Birch St', '1984-03-18', '2017-08-05', NULL, 65000),
    (123, 'Swara Bharti', 'swara@gmail.com', '8881234567', '606 Pineapple St', '1994-08-12', '2024-02-20', NULL, 57000),
    (130, 'James Allie', 'james@gmail.com', '7779876543', '707 Cherry St', '1989-06-07', '2016-05-12', NULL, 53000),
    (168, 'Somya Jain', 'somya@gmail.com', '8635947543', '706 Cherry St', '2004-06-07', '2020-08-23', NULL, 60000),
    (171, 'Srishti Bhatia', 'srishti@gmail.com', '9496843767', '913 Green St', '2004-06-02', '2019-05-10', NULL, 45000),
    (302, 'Ananya V A', 'ananya@gmail.com', '7883447564', '788 Pine St', '2004-04-26', '2022-01-10', NULL, 55000),
    (401, 'Megha Rana', 'megha@gmail.com', '9999876543', '712 Cherry St', '1989-06-07', '2016-04-02', NULL, 54000);


INSERT INTO department (deptID, deptName, deptManager, eid) VALUES
('D001', 'Sales', 'Ananya V A', 302),
('D002', 'Marketing', 'Srishti Bhatia', 171),
('D003', 'IT', 'Somya Jain', 168),
('D004', 'Finance', 'Priya Arora' , 104),
('D005', 'Operations', 'Riya Dingra', 105),
('D006', 'Customer Service', 'Mohit Gupta', 108),
('D007', 'Production', 'Megha Rana', 401),
('D008', 'Maintainace', 'Rahul', 120);

INSERT INTO supplier (sid, sname, semail, saddress, sphoneNumber) 
VALUES
('S001', 'Khari Agrawal', 'khari@gmail.com', '443 Main Street', '764-545-7675'),
('S002', 'Ishaan Ahluwalia', 'ishaan@gmail.com', '954 Oak Avenue', '998-765-0987'),
('S003', 'Dhruv Banerjee', 'dhruv@gmail.com', '789 Elm Street', '321-666-7538'),
('S004', 'Aanya Ahuja', 'aanya@gmail.com', '321 Pine Road', '456-789-1230'),
('S005', 'Jai Chopra', 'jai@gmail.com', '567 Maple Avenue', '789-123-4560'),
('S006', 'Aditi Bedi', 'aditi@gmail.com', '123 Cedar Lane', '654-321-9870'),
('S007', 'Kavi Jha', 'kavi@gmail.com', '432 Birch Street', '321-789-4560'),
('S008', 'Anjali Chawla', 'anjali@gmail.com', '876 Oakwood Drive', '987-654-3210');

INSERT INTO warehouse (ptype, quantity, sid) VALUES
('Daily Use Electronics', '100', 'S001'),
('Utensils', '200', 'S007'),
('Toys', '180', 'S006'),
('Groceries', '300', 'S008'),
('Stationery', '180', 'S006'),
('Sports Equipment', '160', 'S006'),
('Cosmetics', '200', 'S003'),
('Pet Supplies', '130', 'S005'),
('Healthcare', '190', 'S002');

INSERT INTO product (pid, pname, ptype, prize) VALUES
    ('P001', 'Microwave', 'Daily Use Electronics', '1000'),
    ('P002', 'Pet Food', 'Pet Supplies', '800'),
    ('P003', 'Pet Collar', 'Pet Supplies', '50'),
    ('P004', 'Medical Stethoscope', 'Healthcare', '200'),
    ('P005', 'Lipstick', 'Cosmetics', '100'),
    ('P006', 'Pet Bed', 'Pet Supplies', '400'),
    ('P007', 'LED TV', 'Daily Use Electronics', '1200'),
    ('P008', 'Teddy', 'Toys', '30'),
    ('P009', 'Remote Control Car', 'Toys', '20'),
    ('P010', 'Breakfast Cereal', 'Groceries', '500'),
    ('P011', '3D Printer', 'Daily Use Electronics', '150'),
    ('P012', 'Soccer Ball', 'Sports Equipment', '1200'),
    ('P013', 'Eyeliner', 'Cosmetics', '30'),
    ('P014', 'Tennis Racket', 'Sports Equipment', '20'),
    ('P015', 'Cutting Board', 'Utensils', '500'),
    ('P016', 'Medical Thermometer', 'Healthcare', '150'),
    ('P017', 'Atta', 'Groceries', '150'),
    ('P018', 'Fork', 'Utensils', '30'),
    ('P019', 'Lip Gloss', 'Cosmetics', '20'),
    ('P020', 'Knife Set', 'Utensils', '500'),
    ('P021', 'Pressure Cooker', 'Utensils', '150'),
    ('P022', 'Skipping Rope', 'Sports Equipment', '100'),
    ('P023', 'Skipping Rope', 'Sports Equipment', '100'),
    ('P024', 'Eyeliner', 'Cosmetics', '30');

-- Insert 10 values into the customer table
INSERT INTO customer (cid, cname, caddress, cphoneNumber) VALUES
    (17001, 'Gita Singh', '223 Cedar St', '777-555-1234'),
    (17002, 'Lakshmi Biswas', '455 Elm St', '456-555-5678'),
    (17003, 'Shanti Chaudhari', '780 Oak St', '231-555-9101'),
    (17004, 'Mira Gupta', '101 Pine St', '993-555-2345'),
    (17005, 'Punam Kumar', '222 Cedar St', '900-555-6789'),
    (17006, 'Sunita Devi', '303 Maple St', '234-555-1234'),
    (17007, 'Suman Sharma', '440 Walnut St', '987-555-5678'),
    (17008, 'Lalita Mandal', '505 Birch St', '454-555-9101'),
    (17009, 'Vinod Sharma', '606 Pineapple St', '444-555-2345'),
    (17010, 'Umesh Singh', '799 Cherry St', '232-555-6789');


INSERT INTO promotion (promoCode, promoName, startDate, endDate, discountPercentage)
VALUES ('PROMO001', 'Summer Sale', '2024-06-01', '2024-06-30', 10.00),
       ('PROMO002', 'Back to School Promo', '2024-08-15', '2024-09-15', 15.50),
       ('PROMO003', 'Holiday Discount', '2024-12-01', '2024-12-31', 20.00);

ALTER TABLE employee
ADD COLUMN deptID VARCHAR(10),
ADD CONSTRAINT deptID FOREIGN KEY (deptID) REFERENCES department(deptID);



