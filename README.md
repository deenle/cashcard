# Introduction
A simple Family Cash Card application — a modern way for parents to manage allowance 
funds for their kiddos.

# Developing
TDD + The Red, Green, Refactor Loop

# API Contracts
```
Request
    URI: /cashcards/{id}
    HTTP Verb: GET
    Body: None
```
```
Response
    HTTP Status:
        200 OK if the user is authorized and the Cash Card was successfully retrieved
        403 UNAUTHORIZED if the user is unauthenticated or unauthorized
        404 NOT FOUND if the user is authenticated and authorized but the Cash Card cannot be found
    Response Body Type: JSON
    Example Response Body:
        {
            "id": 99,
            "amount": 123.45
           }
```
# Available operations

| Operation | API Endpoint      | HTTP Method | Response Status |
|-----------|-------------------|-------------|-----------------|
| Create    | `/cashcards`      | `POST`      | 201 (CREATED)   |
| Read      | `/cashcards/{id}` | `GET`       | 200 (OK)        |
| Update    | `/cashcards/{id}` | `PUT`       | 204 (NO DATA)   |
| Delete    | `/cashcards/{id}` | `DELETE`    | 204 (NO DATA)   |


### CREATE

### READ

### UPDATE

### DELETE
