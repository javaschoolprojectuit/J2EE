CREATE DATABASE Store;
GO

USE Store;

CREATE TABLE ROLES (
	ROLE_ID int identity(1,1) not null,
	TYPE varchar(20),
	primary key (ROLE_ID)
);

CREATE TABLE USERS (
	USER_ID int identity(1,1) not null,
	FIRSTNAME varchar(10),
	LASTNAME varchar(10),
	ADDRESS varchar(50),
	CITY varchar(20),
	EMAIL varchar(20),
	PHONE varchar(20),
	USERNAME varchar(10) not null,
	PASSWORD varchar(50) not null,
	ACTIVE bit,
	ROLE_ID int,
	DELETED bit,
	primary key (USER_ID),
	constraint FK_ROLE foreign key (ROLE_ID) references ROLES(ROLE_ID)
);

CREATE TABLE SHIPPING_ADDRESS (
	SHIPPING_ID int identity(1,1) not null,
	ADDRESS varchar(50), 
	CITY varchar(10),
	DISTRICT varchar(10),
	EMAIL varchar(20),
	USER_ID int,
	primary key (SHIPPING_ID),
	constraint FK_USER foreign key (USER_ID) references USERS(USER_ID)
);

CREATE TABLE SUPPLIERS (
	SUPPLIER_ID int identity(1,1) not null,
	NAME varchar(20),
	ADDRESS varchar(50),
	CITY varchar(20),
	DISTRICT varchar(20),
	EMAIL varchar(20),
	PHONE varchar(20),
	primary key (SUPPLIER_ID)
);

CREATE TABLE CATEGORIES (
	CAT_ID int identity(1,1) not null,
	NAME varchar(20),
	IMAGE varchar(50),
	ACTIVE bit,
	DESCRIPTION varchar(MAX),
	primary key (CAT_ID)
);

CREATE TABLE PRODUCTS (
	PROD_ID int identity(1,1) not null,
	NAME varchar(20),
	DESCRIPTION varchar(MAX),
	PRICE int,
	Size int,
	IMAGE varchar(50),
	CAT_ID int,
	SUPPLIER_ID int,
	DELETED bit,
	QUANTITY int,
	primary key (PROD_ID),
	constraint FK_CATEGORY foreign key (CAT_ID) references CATEGORIES(CAT_ID),
	constraint FK_SUPPLIER foreign key (SUPPLIER_ID) references SUPPLIERS(SUPPLIER_ID)
);

CREATE TABLE PAYMENTS (
	PAYMENT_ID int identity(1,1) not null,
	TYPE varchar(10),
	ACTIVE bit,
	primary key (PAYMENT_ID)
);

CREATE TABLE ORDERS (
	ORDER_ID int identity(1,1) not null,
	NUMBER varchar(max),
	ORDERDATE nvarchar(10),
	SHIPPINGDATE nvarchar(10),
	TAX int,
	STATUS varchar(10),
	PAYMENTDATE nvarchar(10),
	USER_ID int,
	PAYMENT_ID int,
	constraint FK_USER_ORD foreign key (USER_ID) references USERS(USER_ID),
	constraint FK_PAYMENT foreign key (PAYMENT_ID) references PAYMENTS(PAYMENT_ID), 
	primary key (ORDER_ID)
);

CREATE TABLE ORDER_DETAIL (
	OD_ID int identity(1,1) not null,
	PRICE int,
	QUANTITY int,
	DISCOUNT int,
	ORDER_ID int,
	PROD_ID int,
	primary key (OD_ID),
	constraint FK_ORDER foreign key (ORDER_ID) references ORDERS (ORDER_ID),
	constraint FK_PROD foreign key (PROD_ID) references PRODUCTS (PROD_ID)
);

INSERT INTO CATEGORIES (NAME, IMAGE, ACTIVE, DESCRIPTION) VALUES ('NEW ARRIVALS', '',1, 'Inspired by the brand’s refined and colourful identity, Our new arrivals offer all of this season’s essentials.');
INSERT INTO CATEGORIES (NAME, IMAGE, ACTIVE, DESCRIPTION) VALUES ('MEN SUITS', '',1, 'Ultra-lightweight, comfortable and spacious, these suits are exactly what your wardrobe needs. The natural and elegant shapes embellished by a range of vibrant colours offer a wide range of possible matching sets.');
INSERT INTO CATEGORIES (NAME, IMAGE, ACTIVE, DESCRIPTION) VALUES ('SKIRTS', '',1, 'Combining elegance and practicality, Business collection can rise to every situation. Its modern look and enhanced ergonomics make it the perfect companion for your days at the office or on business trips.');
