REM   Script: Activity3
REM   B38

select salesman_id,salesman_city from salesman;

select salesman_id,salesman_city from salesman;

select * from salesman;

create table salesman (  
    salesman_id int,  
    salesman_name varchar2(32),  
    salesman_city varchar2(32),  
    commission int  
) 
;

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

