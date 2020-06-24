	
delete from User;
insert into User(USER_ID, username, password)
			values(1,'James','$2y$12$hD8kLekouAbj5AtgBhso2e4rgJIciuUCFVE/KKscp22XytOKPZ76y'),
			(2,'David','$2y$12$hD8kLekouAbj5AtgBhso2e4rgJIciuUCFVE/KKscp22XytOKPZ76y'),
			(3,'Josh','$2y$12$hD8kLekouAbj5AtgBhso2e4rgJIciuUCFVE/KKscp22XytOKPZ76y'),
			(4,'Evelyn','$2y$12$hD8kLekouAbj5AtgBhso2e4rgJIciuUCFVE/KKscp22XytOKPZ76y');
delete from Authority;
insert into Authority(AUTHORITY_ID, ROLE)
			values(1, 'ROLE_USER'),
				  (2, 'ROLE_EMPLOYEE');
			
delete from User_Authority;
insert into User_Authority(USER_ID, AUTHORITY_ID)
			values(1,1),(2,1),(3,2),(4,2);
			
delete from Product;
insert into Product(PRODUCT_ID,name,description,category,image,price,quantity)
	values(1,'Milk','Fresh milk','Dairy',FILE_READ('src/main/resources/databaseImages/milk.jpg'),0.90,24),
	(2,'Cheese','Delicious Cheese','Dairy',FILE_READ('src/main/resources/databaseImages/cheese.jpg'),3.00,12),
	(3,'Bacon','Crispy bacon pre cooked','Meat and produce',FILE_READ('src/main/resources/databaseImages/bacon.jpg'),3.00,3);
	
	
delete from Basket;
insert into Basket(USER_ID)
	values (1),(2),(3),(4);