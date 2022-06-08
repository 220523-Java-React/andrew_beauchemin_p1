# andrew_beauchemin_p1
## GET
/ = Home page

/users = user list

/user/{userid} = get user by id

/users/{userid}/offers = show open offers

/users/{userid}/offers/{offerid} = offer

/user/{userid}/cars = car list

/user/{userid}/cars/{carid} = get car by id


## POST
/user/{userid}/user = adds user to list

/user/{userid}/cars = add car to lot EMPLOYEE

/user/{userid}/cars/{id}/ = create offer

/users/{userid}/offers = make offer

/users/{userid}/cars = add new car to lot

## PUT/PATCH
/users/{userid}/offers/{offerid} = change offer to accepted


## Model

offers = id CAR, id USER who put out offer, model of car, id of offer
car = id USER who owns car, LIST id of OFFERS, id of car
user = username, password, LIST id of cars owned, LIST id of offers made, id of user

