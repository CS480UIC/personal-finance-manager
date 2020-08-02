
CREATE TABLE IF NOT EXISTS tb_user(
	user_id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(50),
	`password` VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
    name VARCHAR(20),
    address VARCHAR(50),
    phone BIGINT,
    PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS income(
	income_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    in_date DATE,
    description VARCHAR(50),
    amount DECIMAL(6,2),
    tags VARCHAR(50),
    PRIMARY KEY (income_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(user_id)
);

CREATE TABLE IF NOT EXISTS expense(
	expense_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    date DATE,
    description VARCHAR(50),
    amount DECIMAL(6,2),
    tags VARCHAR(50),
    PRIMARY KEY (expense_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(user_id)
);

CREATE TABLE IF NOT EXISTS account(
	ac_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    date DATE,
    balance DECIMAL(10,2),
    PRIMARY KEY (ac_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(user_id)
);

CREATE TABLE IF NOT EXISTS asset(
	asset_name VARCHAR(20),
    user_id INT NOT NULL,
    value DECIMAL(8,2),
    PRIMARY KEY (asset_name,user_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(user_id)
);

CREATE TABLE IF NOT EXISTS liability(
	liability_name VARCHAR(20),
    user_id INT NOT NULL,
    value DECIMAL(8,2),
    PRIMARY KEY (liability_name,user_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(user_id)
);

CREATE TABLE IF NOT EXISTS balance_sheet(
	user_id INT NOT NULL,
    date DATE,
    balance DECIMAL(10,2),
    PRIMARY KEY (user_id,date),
    FOREIGN KEY (user_id) REFERENCES tb_user(user_id)
);

CREATE TABLE IF NOT EXISTS stock(
	symbol VARCHAR(5),
    current_price DECIMAL (8,2),
    PRIMARY KEY (symbol)
);

CREATE TABLE IF NOT EXISTS portfolio(
	user_id INT NOT NULL,
    symbol VARCHAR(5) NOT NULL,
    quantity INT UNSIGNED,
    buy_price DECIMAL(8,2),
    investment DECIMAL(10,2),
    current_price DECIMAL(8,2),
    equity DECIMAL(10,2),
    PRIMARY KEY (user_id,symbol),
    FOREIGN KEY (user_id) REFERENCES tb_user(user_id),
    FOREIGN KEY (symbol) REFERENCES stock(symbol)
);

CREATE TABLE IF NOT EXISTS transaction(
	transaction_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    date_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    symbol VARCHAR(5) NOT NULL,
    quantity INT UNSIGNED,
    price DECIMAL(8,2),
    value DECIMAL(10,2),
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (symbol) REFERENCES stock(symbol),
    FOREIGN KEY (user_id) REFERENCES tb_user(user_id)
);

INSERT INTO tb_user (name,address,phone)
VALUES ('Alan' , '111, Adams St.' , 1111111111),
	   ('Bella', '222, Baxter St.', 2222222222),
	   ('Cindy', '333, Carter St.', 3333333333);
        
INSERT INTO income (user_id,date,description,amount,tags)
VALUES (2,'2020-05-31','Salary for May 2020',3000,'salary;may;2020;'),
	   (3,'2020-06-05','Lent money received',250 ,'loaned;return;'),
       (3,'2020-06-27','Salary for June 2020',3000 ,'salary;june;2020'),
       (3,'2020-02-11','Dividend earned for July 2020',100 ,'divdend;june;2020'),
       (3,'2020-02-11','Dividend earned for August 2020',120 ,'divdend;july;2020'),
       (3,'2021-11-11','Dividend earned for September 2020',999.99 ,'divdend;august;2020'),
       (3,'2020-07-13','Dividend earned for October 2020',100 ,'divdend;september;2020'),
       (3,'2020-09-09','Dividend earned for November 2020',200 ,'divdend;october;2020'),
       (3,'2020-03-27','Salary for March 2020',3000 ,'salary;March;2020'),
       (3,'2020-04-27','Salary for April 2020',3000 ,'salary;April;2020'),
       (3,'2020-08-27','Salary for August 2020',3000 ,'salary;August;2020'),
       (3,'2020-09-27','Salary for September 2020',3000 ,'salary;September;2020');
       
INSERT INTO expense (user_id,ex_date,description,amount,tags)
VALUES (1,'2020-05-20','Summer semester fees',700,'fees;summer;semester;'),
	   (2,'2020-06-03','Flight tickets to LA',450,'flight;ticket;Chicago;LA;'),
       (1,'2020-06-18','Ordered carryout',23 ,'ubsereats;chipotle;mexican;food;'),
       (3,'2020-03-27','Ordered takeout',400 ,'takeout;'),
       (3,'2020-04-27','Rent+takeout',850 ,'rent;takeout;'),
       (3,'2020-08-27','Rent',650 ,'rent;'),
       (3,'2020-09-27','Rent',250 ,'rent;');
       
INSERT INTO account (user_id,date,balance)
VALUES (1,'2020-01-01',127700),
	   (2,'2020-01-01',264000),
       (3,'2020-01-01',139600);
       
INSERT INTO asset
VALUES ('Receivables',1,600),
	   ('Receivables',2,975),
       ('Stocks',1,8372.83);

INSERT INTO liability
VALUES ('Payables',1,350),
	   ('Credit Card Debt',3,300),
       ('Loan1',5,555.55),
       ('Loan2',1,1.00 ),
       ('Loan3',1,1000.00 ),
       ('Loan4',3,333.33),
       ('Loan5',4,444.44),
       ('Wages Owed',2,1750);

INSERT INTO balance_sheet
VALUES (1,'2020-07-01',101000),
	   (2,'2020-07-01',236000),
       (3,'2020-01-01',122000),
       (3,'2020-02-01',123000),
       (3,'2020-03-01',121000),
       (3,'2020-03-01',124000),
       (3,'2020-04-01',120000),
       (3,'2020-05-01',122000),
       (3,'2020-06-01',127000),
       (3,'2020-07-01',121000),
       (3,'2020-08-01',125000);
       
INSERT INTO stock
VALUES ('AAPL',383.68),
	   ('TSLA',1544.65),
       ('MSFT',213.67),
       ('NEW' ,30.67),
       ('AMZN',88.88),
       ('BRK' ,999.99),
       ('STNE',42.00);
       
INSERT INTO portfolio
VALUES (1,'AAPL',10,300.00,3000.00,383.68 ,3836.80),
	   (1,'TSLA',1,1500.00,1500.00,1544.65,1544.65),
	    (1,'NEW',5,20.00,100.00,30.00,1544.65),
	   (1,'STNE',10,21.00,210.00,42.00,1544.65),
	   (9,'AAPL',10,360.00,3600.00,1200.00,12000.00), 
       (1,'MSFT',14,213.67,2991.38,213.67,2991.38);
       
INSERT INTO transaction (user_id,symbol,quantity,price,value)
VALUES (1,'AAPL',10,383.68,3836.80),
	   (1,'TSLA',1,1544.65,1544.65),
       (1,'MSFT',14,213.67,2991.38);


