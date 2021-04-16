# Spring Boot Application
## Description
I have created a spring Boot application with REST API using H2 and JMS.

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
        "creationTime": "2021-04-16T13:04:50.446+0000",
        "updatedTime": null,
        "dateofBirth": "2021-04-16",
        "userType": "STUDENT",
        "userAddress": {
            "streetAddress": "test1Street",
            "state": "test1State",
            "city": "test1City",
            "areaCode": "test1ZipCode"
        },
        "oldPasswords": [
            "pwd1",
            "pwd2"
        ],
        "dateOfBirthString": "2021-04-16"
    },
    {
        "id": 2,
        "userName": "test2",
        "password": "test2",
        "email": "test2@gmail.com",
        "creationTime": "2021-04-16T13:04:50.446+0000",
        "updatedTime": null,
        "dateofBirth": "2021-04-16",
        "userType": "EMPLOYEE",
        "userAddress": {
            "streetAddress": "test2Street",
            "state": "test2State",
            "city": "test2City",
            "areaCode": "test2ZipCode"
        },
        "oldPasswords": [
            "pwd1",
            "pwd2"
        ],
        "dateOfBirthString": "2021-04-16"
    }
]
Second URl:http://localhost:8181/useradministrator/api/users/1 - to get particular user by using id

output:
{
    "id": 1,
    "userName": "test1",
    "password": "test1",
    "email": "test1@gmail.com",
    "creationTime": "2021-04-16T13:04:50.446+0000",
    "updatedTime": null,
    "dateofBirth": "2021-04-16",
    "userType": "STUDENT",
    "userAddress": {
        "streetAddress": "test1Street",
        "state": "test1State",
        "city": "test1City",
        "areaCode": "test1ZipCode"
    },
    "oldPasswords": [
        "pwd1",
        "pwd2"
    ],
    "dateOfBirthString": "2021-04-16"
}

Third url - http://localhost:8181/useradministrator/api/users/createUser with Post method to create user

{
        "userName": "test3",
        "password": "test3",
        "email": "test3@gmail.com",
        "creationTime": "2021-04-14",
        "dateofBirth": "2021-04-14",
        "userType": "EMPLOYEE",
        "userAddress": {
            "streetAddress": "test3Street",
            "state": "test3State",
            "city": "test3City",
            "areaCode": "test3ZipCode"
        },
        "oldPasswords": [
            "pwd1",
            "pwd2"
        ]
    }
    
output-
User - test3 details are saved with user id - 3

Fourth url: http://localhost:8181/useradministrator/api/users/2 - with put method

{
        "userName": "test2Update",
        "password": "test2Update",
        "email": "test2Update@gmail.com",
        "creationTime": "2021-04-14",
        "dateofBirth": "2021-04-14",
        "userType": "STUDENT",
        "userAddress": {
            "streetAddress": "test2Street",
            "state": "test2State",
            "city": "test2City",
            "areaCode": "test2ZipCode"
        },
        "oldPasswords": [
            "pwd1",
            "pwd2"
        ]
    }

Will update the details

output: 

{
    "id": 2,
    "userName": "test2Update",
    "password": "test2Update",
    "email": "test2Update@gmail.com",
    "creationTime": "2021-04-16T13:09:31.452+0000",
    "updatedTime": null,
    "dateofBirth": "2021-04-14T00:00:00.000+0000",
    "userType": "STUDENT",
    "userAddress": {
        "streetAddress": "test2Street",
        "state": "test2State",
        "city": "test2City",
        "areaCode": "test2ZipCode"
    },
    "oldPasswords": [
        "pwd1",
        "pwd2"
    ],
    "dateOfBirthString": "Wed Apr 14 02:00:00 CEST 2021"
}
