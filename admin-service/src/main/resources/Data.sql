TRUNCATE TABLE ITEM;
TRUNCATE TABLE AUDIT;

INSERT INTO ITEM (NAME, NUMBER_OF_ITEMS_AVAILABLE, PRICE) values
('Idli',10, 20),
('Vada',15, 30),
('Puri',10, 25),
('Dosa',12, 40);

INSERT INTO AUDIT (USER, ITEMS, CITY, TOTAL_PRICE, TIME) values
('user1', '[Vada price: 30 , Puri price: 25 ]', 'Bangalore', 55, '2020-11-20 15:48:28'),
('user2', '[Puri price: 25 ]', 'Chennai', 25, '2020-11-20 15:48:28'),
('user1', '[Vada price: 30 , Idli price: 20 ]', 'Bangalore', 50, '2021-11-26 15:48:28'),
('user2', '[Idli price: 20 ]', 'Bangalore', 20, '2021-11-26 15:48:28'),
('user1', '[Vada price: 30 , Puri price: 25 ]', 'Bangalore', 55, '2021-11-27 15:48:28'),
('user2', '[Vada price: 30 , Puri price: 25 ]', 'Chennai', 55, '2021-11-27 15:48:28');
