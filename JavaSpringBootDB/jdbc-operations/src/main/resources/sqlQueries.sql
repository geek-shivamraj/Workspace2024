create database sampledb;

use sampledb;

create table employee_data (
	emp_id int, 
	emp_name varchar(45), 
	designation varchar(45), 
	salary double, 
	primary key(emp_id));
	
insert into employee_data values(101, 'Alan', 'Java Developer', 87000),
(102,'Claudia', 'Senior Software Engineer', 1022000),
(103,'Raj', 'Tech lead', 11000),
(104,'Maria', 'Product Manager', 118000),
(105,'Ryan', 'Project Manager', 100000),
(106,'Marcia', 'Web Developer', 88000),
(107,'Neil', 'Pre-sales Engineer', 12000),
(108,'Gina', 'Senior Product Manager', 12000);

update employee_data set designation='Head of Product Management', salary = 1555000
where emp_id = 108;

update employee_data set designation='Senior Product Manager', salary = 12000
where emp_id = 108;