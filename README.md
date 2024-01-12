# Financeplanner

## General information
Financeplanner is a client server based tool to manage your personal budget by assigning the total income of an month to budget-buckets. 

The most important principle is: Each budget-bucket should have a specific purpose.

## Budget
A budget is the sum of all availaibe sources of money, split up into budget-buckets with specific purpose. It is some kind of purpose related planning of future spendings. A budget can consist of several budget sources, maybe a bank account or local savings or an investment fond. In case of transactions, a specific account has to be selected to keep the sync with your real accounts.

## Budget planning
The budget plannung is done at the beginning of every month, when you get your payment from your job, you should assign the money to the specific buckets. At the end of the month, every euro should be assigned to a purpose.

## Budget Bucket
A budget bucket is a part of your complete budget which is associated with a specific purpose, for example a holiday trip. It can have a target amount that sould be reached or it is possible to have no limit like some kind of continous savings. A budget bucket can be associated with annual payments like for example an insurance which is payed in Januaray so the buckt should be full if the payment is necessary. Negative aounts are possible but should not be possible. In this case, money from another bucket has to be transfered.

## Transaction
A transaction marks a specific transfer of money by a user into or out of a budget Bucket. It has to be documented in the monthly transactions view and reperents for example a specific spending. A transaction comes from a money source, is assoiciated with a budget bucket, is done by a user in a specific budgeting period like a month. It is possible to define scheduled transactions. 

## User and Accounts
It is possible to work on a single budget with multiple accounts because it is possible that families have a shared budget for example. There must be at least one Budget-Administrator, associated to a budget who is able to manage access of other users towards his specific budget. In transactions, it is possible to show, who created a specific spent on a bucket.

## Statistics and automatism
Apart from that, there will be several possibilities to make your budgeting more easy, for examle take over the values from the previous month, notifications about events, statistics and so on but the core value should be the budgeting method.

## Technology

### Backend
- Spring Boot
- JDBC via Spring Data JPA
- Spring Security
- Relational database
- REST

### Frontend
- Angular

## Architecture
The architecture is based on a classical n-tier design, separated by domains. A Split up into separate services does not make sense and would increase the complexity of maintanance.
