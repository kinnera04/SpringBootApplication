# Spring Boot Application
## Description
I have created a spring Boot application with REST API using H2.

Once you clone the respository by using GIt url, Please do the following steps.

1.Import existing maven projects/projects from Git.
Once it is imported in STS/Eclipse/other IDES. Do right click the project
2.Maven clean
3.Maven Install
4.Debug as Spring Boot App
5.In postMan http client

Give the following URL with http method- GET

http://localhost:8181/useradministrator/api/users/- to get all the users

Output:

[
    {
        "id": 1,
        "userName": "test1",
        "password": "test1",
        "email": "test1@gmail.com",
        "creationTime": "2021-04-14T10:41:18.536+0000",
        "updatedTime": null,
        "dateofBirth": "2021-04-14",
        "userType": "STUDENT",
        "dateOfBirthString": "2021-04-14"
    },
    {
        "id": 2,
        "userName": "test2",
        "password": "test2",
        "email": "test2@gmail.com",
        "creationTime": "2021-04-14T10:41:18.536+0000",
        "updatedTime": null,
        "dateofBirth": "2021-04-14",
        "userType": "EMPLOYEE",
        "dateOfBirthString": "2021-04-14"
    }
]

Second URl:http://localhost:8181/useradministrator/api/users/1 - to get particular user by using id

output:
{
    "id": 1,
    "userName": "test1",
    "password": "test1",
    "email": "test1@gmail.com",
    "creationTime": "2021-04-14T10:41:18.536+0000",
    "updatedTime": null,
    "dateofBirth": "2021-04-14",
    "userType": "STUDENT",
    "dateOfBirthString": "2021-04-14"
}

Third url - http://localhost:8181/useradministrator/api/users/createUser with Post method to create user

{
        "userName": "test3",
        "password": "test3",
        "email": "test3@gmail.com",
        "creationTime": "2021-04-14",
        "dateofBirth": "2021-04-14",
        "userType": "EMPLOYEE"
    }
    
output-
User - test3 details are saved with user id - 3
