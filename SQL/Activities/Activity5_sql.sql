REM   Script: Activity5
REM   B38

INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT INTO salesman VALUES(5005, 'Pit Alex', 'London', 11);

select * from salesman;

INSERT INTO salesman VALUES(5006, 'McLyon', 'Paris', 14);

INSERT INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13);

INSERT INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12);

select * from salesman;

select salesman_id,salesman_city from salesman;

select * from salesman 
where salesman_city='Paris';

select * from salesman;

select salesman_id,commission from salesman 
where salesman_name='Paul Adam';

alter table salesman add grade int;

update salesman set grade=100;

select * from salesman;

update salesman set grade=200 
where salesman_city='Rome';

update salesman set grade=300 
where salesman_name='James Hoog';

select * from salesman;

update salesman set salesman_name='Pierre' 
where salesman_name='McLyon';

select * from salesman;

INSERT INTO salesman VALUES(5008, 'James Hoog', 'San Jose', 12);

INSERT INTO salesman VALUES(5008, 'James Hoog', 'San Jose', 12,100);

select * from salesman;

update salesman set grade=300 
where salesman_name='James Hoog';

select * from salesman;

