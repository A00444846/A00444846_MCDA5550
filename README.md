# A00444846_MCDA5550

For Changing Database you have to do changes in `application.properties`

You have to create blank database with name 'hoteldb'

SQL query: `create database hoteldb;`

SQL query for insert records in hotel table: 
`INSERT INTO hotel (id,availability, hotel_name, price) 
VALUES (1, true, 'Hotel Brunswick Inn', '230'),
(2, true, 'Hotel Halifax', '250'),
(3, true, 'Atlantic Inn', '300');`

#### GET API: http://localhost:8080/getListOfHotels


Response:
``` 
{
    "hotels_list": [
        {
            "hotel_name": "Hotel Brunswick Inn",
            "price": 230,
            "availability": true
        },
        {
            "hotel_name": "Hotel Halifax",
            "price": 250,
            "availability": true
        },
        {
            "hotel_name": "Atlantic Inn",
            "price": 300,
            "availability": true
        }
    ]
}
```



#### POST API: http://127.0.0.1:8080/reservationConfirmation

Body:
``` 
{  
   "hotel_name": "Hotel Halifax", 
   "checkin": "05/25/2022", 
   "checkout": "05/30/2022", 
    "guests_list": [
           { 
               "guest_name" : "Pratik", 
               "gender": "male"
           }
    ]
}
```

Response: 
```
{
    "confirmation_number": "6"
}
```
