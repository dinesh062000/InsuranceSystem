create database insurance;
use insurance;
-- user table
create table user (userid int primary key, username varchar(255),
 password varchar(255), role varchar(50) );

-- client table
create table client (clientid int primary key, 
clientname varchar(255), contactinfo varchar(255), policy varchar(100) );

-- claim table
create table claim (claimid int primary key, claimnumber varchar(255), datefiled varchar(255),
claimamount decimal(10, 2), status varchar(50), policy varchar(100), 
client int, foreign key (client) references client(clientid));

-- payment table
create table payment ( paymentid int primary key, paymentdate varchar(100),
paymentamount decimal(10, 2), client int, foreign key (client) references client(clientid));

create table policy (policyid int primary key, policyname varchar(255), policytype varchar(255),
    coverageamount decimal(10, 2));

insert into user (userid, username, password, role)
values(1, 'admin', 'admin_password', 'admin'),
    (2, 'user1', 'user1_password', 'user'),
    (3, 'user2', 'user2_password', 'user');
    
insert into client (clientid, clientname, contactinfo, policy)
values
    (1, 'clienta', '123-456-7890', 'auto insurance'),
    (2, 'clientb', '987-654-3210', 'home insurance'),
    (3, 'clientc', null, 'health insurance');
    
insert into claim (claimid, claimnumber, datefiled, claimamount, status, policy, client)
values
    (1, 'c12345', '2023-01-15', 1500.00, 'pending', 'auto insurance claim', 1),
    (2, 'c67890', '2023-02-20', 2000.00, 'approved', 'home insurance claim', 2),
    (3, 'c54321', '2023-03-10', 1000.00, 'rejected', 'health insurance claim', 3);

insert into payment (paymentid, paymentdate, paymentamount, client)
values
    (1, '2023-01-20', 500.00, 1),
    (2, '2023-02-25', 750.00, 2),
    (3, '2023-03-15', 300.00, 3);
    
insert into policy (policyid, policyname, policytype, coverageamount)
values
    (1, 'auto insurance', 'vehicle', 5000.00),
    (2, 'home insurance', 'property', 10000.00),
    (3, 'health insurance', 'health', 20000.00);






