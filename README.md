# Tech11Test
-GetAll with Postgress Database :     http://localhost:8080/tech11Test/api/usersdao 
-GetAll with Pagination :  http://localhost:8080/tech11Test/api/usersdao?limit=100&offset=3 

- Put User : http://localhost:8080/tech11Test/api/usersdao/1   But with following attributes --> 
            it is important that you enter the password to ensure that only the user himself can change his data
{   
    "id": 1,
    "birthDay": "1997-03-16",
    "email": "klala.chikhi@studnet.fhws.de2",
    "firstName": "test",
    "lastName": "Chikhi2",
    "password":"test"
}

-Post :  http://localhost:8080/tech11Test/api/usersdao
{   
 
    "email": "klala.chidsfkhi@studnet.fhws.de2",
    "firstName": "testf",
    "lastName": "testn",
    "password":"test"
}


______________________________________________

User with Map
GetAll  http://localhost:8080/tech11Test/api/users
         http://localhost:8080/tech11Test/api/users?limit=100&offset=0

Post :    http://localhost:8080/tech11Test/api/users  
{
       
        "email": "klala.chikhi@studnet.fhws.de1",
        "firstName": "testFirstName",
        "lastName": "testLastName",
        "password": "klala"
    }

Put http://localhost:8080/tech11Test/api/users/2
{
    "birthDay": "1997-06-16",
    "email": "klala.chikhi@studnet.fhws.de2",
    "firstName": "test",
    "id": 2,
    "lastName": "test"
   
}
