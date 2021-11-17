# Book Inventory
Book Inventory was created to help the library owner to take notes
of their books. In this application there are Users that can buy some
books.

### Describe
Before we use this application, we need to login first.
The owner of the library can input the details of book, like title,
author, year, publisher, price, and stock. In this application there
are also Users that can input their info like name, address, phone, username, and password.
Users can buy some book with validation, if the user buy quantity is
bigger than the stock of book, than user cant buy the book

### Dependencies
- PostgreSQL Driver
- Spring Data JPA
- Spring Web

### API
Fetch Book
- Get All Book
```
GET: localhost:8088/books
```
- -------------
- Stram Get Book By Name
```
GET: localhost:8088/bookFilter/YYY
```
- -------------
- Add Book
```
POST: localhost:8088/book
```
- -------------
- Edit Book
```
PUT: localhost:8088/book
```
- -------------

- -------------
- -------------
Fetch Transaction
- Create Transaction
```
POST: localhost:8088/transaction
```
- Get All Transaction
```
GET: localhost:8088/transactions
```
- -------------
- -------------
USER
- Sign In
```
POST: localhost:8088/signin
```
- Add User
```
POST: localhost:8088/user
```
- Edit User By Id
```
PUT: localhost:8088/user
```
- Get All User
```
GET: localhost:8088/users
```
- Delete User By Id
```
DELETE: localhost:8088/user/10fb9bd43a3047cd9825c90f12a16b78
```
- Stream Get User By Name
```
localhost:8088/userFilter/zzz
```

## Authors

Yazri Pahlevi