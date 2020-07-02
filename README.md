## Table of Contents
1. [Database](#database)
2. [Author(s)](#author)
3. [Database description](#description)

# Database
finance_manager

# Author(s)
Rushit N. Shah

University of Illinois at Chicago

# Database description
The overall idea of this project is to create a database to store personal financial information of an individual(s).

- An individual **user** is characterized by a unique ***user id*** and  ***name, address, phone number***(s), (and other personal information).

- An individual's **income** and **expense** are identified by (a unique ***transaction ID, description, date, amount, tags***). Tags provide the user with the ability to look back at past incomes and expenses, study the area where they were incurred, and analyze important/wasteful expenses, leading to further financial insight.

- The **bank balance** of the individual (on a particular day) is characterized by the unique pair (***ID, date***) and contains the ***balance*** amount. The bank balance may be updated multiple times on a day hence we need two attributes to characterize a unique primary key.  

- A particular **stock** is characterized by its (unique ***symbol*** (e.g. AAPL - Apple Inc.) , ***current price***). A user is linked to each stock that they buy/sell through a **transaction** entity where each tuple is transaction characterized by a unique ***transaction id*** and described otherwise by a ***user id, symbol, quantity, buying price***, and ***total value*** of the transaction.

- Each tuple in the individual's **portfolio** is characterized by a unique (***user_id,symbol***) pair and the stock's (***buy price , quantity , total investment, current price, equity***). The portfolio records how much money the individual has invested in each stock.

- Each **asset** and **liability** is characterized by a unique (***user id, asset name/liability name***) pair, besides the ***amount*** value of that asset/liability. A date is not needed here since the assets and liabilities are reported at the time that they are accessed, and not on a specific date.

- Finally, the **balance sheet** is an ongoing record of the overall balance of the individual which is a sum of the individual's bank balance, cash on hand, all assets, and all liabilities. Each record in the balance sheet is characterized by a unique (***user ID, date***) pair and also contains the ***balance***. The total balance too can change multiple times within a day and thus must be identified by a unique ID, rather than a date.
