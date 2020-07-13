
CREATE TABLE IF NOT EXISTS tb_user(
	user_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    address VARCHAR(50),
    phone BIGINT,
    PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS income(
	income_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    date DATE,
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
       (3,'2020-06-27','Salary for June 2020',5500 ,'salary;june;2020');

INSERT INTO expense (user_id,date,description,amount,tags)
VALUES (1,'2020-05-20','Summer semester fees',700,'fees;summer;semester;'),
	   (2,'2020-06-03','Flight tickets to LA',450,'flight;ticket;Chicago;LA;'),
       (1,'2020-06-18','Ordered carryout',23 ,'ubsereats;chipotle;mexican;food;');

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
       ('Wages Owed',2,1750);

INSERT INTO balance_sheet
VALUES (1,'2020-07-01',101000),
	   (2,'2020-07-01',236000),
       (3,'2020-01-01',122000);

INSERT INTO stock
VALUES ('AAPL',383.68),
	   ('TSLA',1544.65),
       ('MSFT',213.67);

INSERT INTO portfolio
VALUES (1,'AAPL',10,300.00,3000.00,383.68 ,3836.80),
	   (1,'TSLA',1,1500.00,1500.00,1544.65,1544.65),
       (1,'MSFT',14,213.67,2991.38,213.67,2991.38);

INSERT INTO transaction (user_id,symbol,quantity,price,value)
VALUES (1,'AAPL',10,383.68,3836.80),
	   (1,'TSLA',1,1544.65,1544.65),
       (1,'MSFT',14,213.67,2991.38);
