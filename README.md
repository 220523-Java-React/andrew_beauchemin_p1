# andrew_beauchemin_p1
GET
/ = Home page
/users = user list
/user/{userid} = get user by id
/users/{userid}/offers = show open offers

/cars = car list
/cars/{carid} = get car by id
/cars/{carid}/{offid} = get offer by id


POST
/user = adds user to list
/cars = add car to lot EMPLOYEE
/cars/{id}/ = create offer


offers = id CAR, id USER who put out offer, model of car, id of offer
car = id USER who owns car, LIST id of OFFERS, id of car
user = username, password, LIST id of cars owned, LIST id of offers made, id of user

