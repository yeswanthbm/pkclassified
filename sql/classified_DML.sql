insert into CATEGORY (ID, CODE, NAME, DESCRIPTION, IMG_LOC) values(1,"001", "Real Estate", "Real Estate", "img/portfolio/home.png");
insert into CATEGORY (ID, CODE, NAME, DESCRIPTION, IMG_LOC) values(2,"002", "Automobile", "Automobile", "img/portfolio/car.png");
insert into CATEGORY (ID, CODE, NAME, DESCRIPTION, IMG_LOC) values(3,"003", "Household Items", "Household Items", "img/portfolio/household.png");
insert into CATEGORY (ID, CODE, NAME, DESCRIPTION, IMG_LOC) values(4,"004", "Digital Media", "Digital Media", "img/portfolio/periferals.png");
insert into CATEGORY (ID, CODE, NAME, DESCRIPTION, IMG_LOC) values(5,"005", "Education", "Education", "img/portfolio/books.png");
insert into CATEGORY (ID, CODE, NAME, DESCRIPTION, IMG_LOC) values(6,"006", "Others", "Others", "img/portfolio/other.png");

insert into SUB_CATEGORY (ID, CATEGORY_ID, CODE, NAME, DESCRIPTION) values(1, 4, "Mobiles", "Mobiles", "Mobiles");

insert into ITEM_DETAILS (ID, NAME, SUB_CATEGORY_ID, PRICE, DESCRIPTION, LOCATION, ACTIVE_FLAG, SELLER_ID, CREATED_TS, UPDATED_TS) 
values (1,"Samsung Mobile", 1, "5000", "The mobile is still in warranty - 5 months old", "Hyderabad", "Y", 1, '2015-09-25 13:35:00', '2015-09-25 13:35:00');