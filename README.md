# andrew_beauchemin_p1
## GET
/ = Home page

/users = user list

***/users -> As a non-user, I can create a Customer or Employee Account***

/user/{userid} = get user by id

/offers = show open offers

/users/{offerid} = offer

/cars = car list

***/cars?userid={userid} ->  As a Customer, I can view available Cars on the lot***

/cars/{carid} = get car by id


## POST
/users = adds user to list

/offers = create offer

/offers = make offer

***/cars ->  As a Customer, I can make an Offer on an available Car***


/cars = add new car to lot

## PUT/PATCH
/ = change offer to accepted


## Model

offers = id CAR, id USER who put out offer, model of car, id of offer
car = id USER who owns car, LIST id of OFFERS, id of car
user = username, password, LIST id of cars owned, LIST id of offers made, id of user

