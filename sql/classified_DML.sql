insert into CATEGORY (ID, CODE, NAME, DESCRIPTION) values(1,"ELECTRONICS", "Electronics", "Electronic Products");
insert into CATEGORY (ID, CODE, NAME, DESCRIPTION) values(2,"HOME_APPLIANCES", "Home Appliances", "Home Appliances");
insert into CATEGORY (ID, CODE, NAME, DESCRIPTION) values(3,"REAL_ESTATES", "Real Estates", "Real Estates");
insert into CATEGORY (ID, CODE, NAME, DESCRIPTION) values(4,"MATRIMONY", "Matrimony", "Matrimony");

insert into SUB_CATEGORY (ID, CATEGORY_ID, CODE, NAME, DESCRIPTION) values(1, 1, "MOBILES", "Mobiles", "Mobiles");

insert into ITEM_DETAILS (ID, NAME, SUB_CATEGORY_ID, PRICE, DESCRIPTION, LOCATION, ACTIVE_FLAG, SELLER_ID, CREATED_TS, UPDATED_TS) 
values (1,"Samsung Mobile", 1, "5000", "The mobile is still in warranty - 5 months old", "Hyderabad", "Y", 1, '2015-09-25 13:35:00', '2015-09-25 13:35:00');