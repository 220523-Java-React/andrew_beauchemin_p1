# andrew_beauchemin_p1
## GET
/ = Home page

/users = user list

***/register -> As a non-user, I can create a Customer or Employee Account***

/user/{userid} = get user by id

/offers = show open offers

***/offers?userid={userid} -> As a Customer, I can view my open offers***

/users/{offerid} = offer

/cars = car list

***/car_view?userid-{userid} ->  As a Customer, I can view the Cars that I own***

***/car_view ->  As a Customer, I can view available Cars on the lot***

/cars/{carid} = get car by id


## POST
/users = adds user to list

/offers = create offer

/offers = make offer

***/cars ->  As an Employee, I can add a new Car to the lot***

***/offers ->  As a Customer, I can make an Offer on an available Car***


/cars = add new car to lot

## PUT/PATCH
/ = change offer to accepted

***/offers/{offerid} -> As an Employee, I can accept or reject an Offer on a Car***


## Model

offers = id CAR, id USER who put out offer, model of car, id of offer
car = id USER who owns car, LIST id of OFFERS, id of car
user = username, password, LIST id of cars owned, LIST id of offers made, id of user

