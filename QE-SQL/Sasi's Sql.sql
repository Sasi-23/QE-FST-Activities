---Activity1
create table salesman(
    salesman_id int,
    salesman_name varchar2(20),
    salesman_city varchar2(20),
    commission int
);

---Activity2
INSERT intO salesman values(5001,'James Hoog','New York',15);
INSERT intO salesman values(5002,'Nail Knite','Paris',13);
INSERT intO salesman values(5005,'Pit Alex','London',11);
INSERT intO salesman values(5006,'McLyon','Paris',14);
INSERT intO salesman values(5007,'Paul Adam','Rome',13);
INSERT intO salesman values(5003,'Lauson Hen','San Jose',12);

---Activity3
select salesman_id, salesman_city
from salesman;

select * from salesman
where salesman_city='Paris';

select salesman_id, commission 
from salesman
where salesman_name='Paul Adam';

---Activity4
ALTER table salesman 
ADD grade int;

UPDATE salesman 
SET grade=100;

select *  from salesman;

----Activity5
UPDATE salesman 
SET grade=200
wHERE salesman_city='Rome';

UPDATE salesman 
SET grade=300
wHERE salesman_name='James Hoog';

UPDATE Salesman 
SET salesman_name='Pierre'
where salesman_name='McLyon';

select * from salesman;

---Activity6
-- Create a table named orders
create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);

-- Add values to the table
INSERT ALL
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)
SELECT 1 FROM DUAL;

select distinct (salesman_id)
from orders;

select order_no
from Orders 
ORDER BY order_date;

select order_no
from Orders 
ORDER BY purchase_amount desc;

select * 
from orders
where purchase_amount<500;

select * 
from orders
where purchase_amount BETWEEN 1000 AND 2000;

---Activity7
select sum(purchase_amount) Total_Purchase_amount
from orders;

select avg(purchase_amount) Average_Purchase_amount
from orders;

select max(purchase_amount) Maximum_Purchase_amount
from orders;

select min(purchase_amount) Minuimum_Purchase_amount
from orders;

select  count( distinct salesman_id) Number_of_salesman
from orders;

----Activity8
select customer_id,  max(purchase_amount) Maximum_Purchase_amount
from orders
GROUP BY customer_id;

select salesman_id,  max(purchase_amount) Maximum_Purchase_amount
from Orders 
WHERE order_date= DATE '2012-08-17'
GROUP BY salesman_id;

select customer_id,order_date ,max(purchase_amount) Maximum_Purchase_amount
from Orders 
where purchase_amount in(2030,3450,5760,6000)
GROUP BY customer_id, order_date;

--Activity9
-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

select salesman_name, customer_name 
from salesman s join customers c
ON s.salesman_id=c.salesman_id;

select c.customer_name,s.salesman_name,s.grade
from customers c JOIN  salesman s
ON c.salesman_id=s.salesman_id
where s.grade<300
ORDER BY c.customer_name;

select c.customer_name, s.salesman_name,s.commission
from customers c JOIN salesman s
ON c.salesman_id=s.SALESMAN_ID
WHERE s.commission>0.12;

select o.order_no,o.order_date,o.purchase_amount,c.customer_name,s.salesman_name,s.commission
from orders o
JOIN customers c ON o.customer_id=c.CUSTOMER_ID
JOIN salesman s ON c.salesman_id=s.salesman_id;

select * from customers;

---Activity10
select * 
from ORDERS
where salesman_id=(
    select salesman_id
    from CUSTOMERS
    WHERE customer_id=3007
);

select *
from orders
where salesman_id IN(
    select salesman_id
    from salesman
    where salesman_city='NEW York'
);

select count(*)
from CUSTOMERS
where grade>(
    select avg(grade)
    from CUSTOMERS
    where city='New York'
);

select * 
from ORDERS
where salesman_id IN(
    select salesman_id
    from SALESMAN
    where commission=(
        select max(commission)
        from SALESMAN
    )
);