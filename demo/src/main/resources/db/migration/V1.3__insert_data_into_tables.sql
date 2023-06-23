insert into manager (name, description) values
('Bruce', 'VP'),
('Jack', 'Sr. Manager'),
('Sara', 'Jr. Manager'),
('Larry', 'Jr. Manager'),
('Abbey', 'Sr. Manager'),
('Chris', 'Jr. Manager'),
('Jessica', 'Jr. Manager')
;
commit;

insert into product (name, description) values
('Gold Credit Card', '$5000 Limit'),
('Platinum Credit Card', '$8000 Limit'),
('Freedom Debit Card', '4 Deals Per Month'),
('Ultimate Debit Card', '8 Deals Per Month'),
('ETF', 'Exchange Traded Funds'),
('Stock Bundle', 'Customized Stock Investment Consulting'),
('Bonds Bundle', 'Customized Bonds Investment Consulting')
;
commit;

insert into client (login_name, password, first_name, last_name, email, manager_id ) values
('dsmith', '123456', 'David', 'Smith', 'david.smith@devmountain.com', 2),
('fjohnson', '123456', 'Frank', 'Johnson', 'frank.johnson@devmountain.com', 2),
('edavis', '123456', 'Emily', 'Davis', 'emily.davis@devmountain.com', 1),
('dmiller', '123456', 'Dave', 'Miller', 'dave.miller@devmountain.com', 3),
('tbrown', '123456', 'Thomas', 'Brown', 'thomas.brown@devmountain.com', 3),
('jwilson', '123456', 'Jones', 'Wilson', 'jones.wilson@devmountain.com', 4),
('aclinton', '123456', 'Anderson', 'Clinton', 'anderson.clinton@devmountain.com', 3),
('jyoung', '123456', 'Jackson', 'Young', 'jackson.young@devmountain.com', 4),
('wcook', '123456', 'White', 'Cook', 'white.cook@devmountain.com', 5),
('hscott', '123456', 'Henry', 'Scott', 'henry.scott@devmountain.com', 6),
('hcooper', '123456', 'Harris', 'Cooper', 'harris.cooper@devmountain.com', 7),
('mross', '123456', 'Martin', 'Ross', 'martin.ross@devmountain.com', 7),
('cwood', '123456', 'Clark', 'Wood', 'clark.wood@devmountain.com', 5),
('lpowell', '123456', 'Lee', 'Powell', 'lee.powell@devmountain.com', 7)
;
commit;

insert into client_sensitive (login_name, password, first_name, last_name, email, address, ssn ) values
('dsmith', '123456', 'David', 'Smith', 'david.smith@devmountain.com', '999 Washington Ave, Fairfax, VA 22030', '9876543210'),
('fjohnson', '123456', 'Frank', 'Johnson', 'frank.johnson@devmountain.com', '998 fish road, Fairfax, VA 22030', '9876543211'),
('edavis', '123456', 'Emily', 'Davis', 'emily.davis@devmountain.com', '997 well pl, Fairfax, VA 22030', '9876543212'),
('dmiller', '123456', 'Dave', 'Miller', 'dave.miller@devmountain.com', '996 Washington Ave, Fairfax, VA 22030', '9876543213'),
('tbrown', '123456', 'Thomas', 'Brown', 'thomas.brown@devmountain.com', '995 Washington Ave, Fairfax, VA 22030', '9876543214'),
('jwilson', '123456', 'Jones', 'Wilson', 'jones.wilson@devmountain.com', '994 Washington Ave, Fairfax, VA 22030', '9876543215'),
('aclinton', '123456', 'Anderson', 'Clinton', 'anderson.clinton@devmountain.com', '993 Washington Ave, Fairfax, VA 22030', '9876543216'),
('jyoung', '123456', 'Jackson', 'Young', 'jackson.young@devmountain.com', '992 Washington Ave, Fairfax, VA 22030', '9876543217'),
('wcook', '123456', 'White', 'Cook', 'white.cook@devmountain.com', '991 Washington Ave, Fairfax, VA 22030', '9876543218'),
('hscott', '123456', 'Henry', 'Scott', 'henry.scott@devmountain.com', '990 Washington Ave, Fairfax, VA 22030', '9876543219'),
('hcooper', '123456', 'Harris', 'Cooper', 'harris.cooper@devmountain.com', '989 Washington Ave, Fairfax, VA 22030', '9876543220'),
('mross', '123456', 'Martin', 'Ross', 'martin.ross@devmountain.com', '988 Washington Ave, Fairfax, VA 22030', '9876543221'),
('cwood', '123456', 'Clark', 'Wood', 'clark.wood@devmountain.com', '987 Washington Ave, Fairfax, VA 22030', '9876543222'),
('lpowell', '123456', 'Lee', 'Powell', 'lee.powell@devmountain.com', '986 Washington Ave, Fairfax, VA 22030', '9876543223')
;
commit;

insert into client_product values
(1, 1),
(1, 2),
(1, 5),
(2, 1),
(2, 2),
(3, 1),
(3, 5),
(4, 3),
(4, 7),
(5, 3),
(5, 4),
(6, 1),
(6, 4),
(7, 2),
(8, 2),
(8, 3),
(8, 6),
(8, 1),
(9, 3),
(9, 2),
(9, 1),
(9, 7),
(10, 2),
(10, 1),
(10, 7),
(10, 5)
;
commit;