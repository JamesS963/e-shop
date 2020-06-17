	
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