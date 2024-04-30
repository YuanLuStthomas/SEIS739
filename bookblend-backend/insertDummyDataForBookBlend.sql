-- Script to insert dummy dev data into the database.

-- You first need to register two users into the system before running this scirpt.

-- Replace the id here with the first user id you want to have ownership of the orders.
-- DECLARE @userId1 AS INT = 6;
SET @userId1 := 6;


-- Replace the id here with the second user id you want to have ownership of the orders.
-- DECLARE @userId2 AS INT = 7;
SET @userId2 := 7;


DELETE FROM book_order_quantities;
DELETE FROM book_order;
DELETE FROM inventory;
DELETE FROM book;
DELETE FROM address;

INSERT INTO book (`name`, author, bookImg, short_description, long_description, price) VALUES ('Pride and Prejudice', 'Jane Austen', 'assets/pride-and-prejudice.webp', 'Book one short description.', 'This is a very long description of Pride and Prejudice.', 25.50);
INSERT INTO book (`name`, author, bookImg, short_description, long_description, price) VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 'assets/the-great-gatsby.jpg', 'Book two short description.', 'This is a very long description of The Great Gatsby.', 21.56);
INSERT INTO book (`name`, author, bookImg, short_description, long_description, price) VALUES ('The Lord of the Rings', 'John Ronald Reuel Tolkien', 'assets/the-lord-of-the-rings.gif', 'Book three short description.', 'This is a very long description of The Lord of the Rings.', 23.74);
INSERT INTO book (`name`, author, bookImg, short_description, long_description, price) VALUES ('The Lion, the Witch and the Wardrobe', 'C.S. Lewis', 'assets/LWW.jpg', 'Book four short description.', 'This is a very long description of Lolita.', 15.69);
INSERT INTO book (`name`, author, bookImg, short_description, long_description, price) VALUES ('To Kill a Mockingbird', 'Harper Lee', 'assets/TCMB.jpg', 'Book five short description.', 'This is a very long description of To Kill a Mockingbird.', 22.59);

-- DECLARE @book1 INT, @book2 INT, @book3 INT, @book4 INT, @book5 AS INT;
SET @book1 = NULL;
SET @book2 = NULL;
SET @book3 = NULL;
SET @book4 = NULL;
SET @book5 = NULL;

SELECT id INTO @book1 FROM book WHERE `name` = 'Pride and Prejudice';
SELECT id INTO @book2 FROM book WHERE `name` = 'The Great Gatsby';
SELECT id INTO @book3 FROM book WHERE `name` = 'The Lord of the Rings';
SELECT id INTO @book4 FROM book WHERE `name` = 'The Lion, the Witch and the Wardrobe';
SELECT id INTO @book5 FROM book WHERE `name` = 'To Kill a Mockingbird';

INSERT INTO inventory (book_id, quantity) VALUES (@book1, 5);
INSERT INTO inventory (book_id, quantity) VALUES (@book2, 8);
INSERT INTO inventory (book_id, quantity) VALUES (@book3, 12);
INSERT INTO inventory (book_id, quantity) VALUES (@book4, 73);
INSERT INTO inventory (book_id, quantity) VALUES (@book5, 2);

INSERT INTO address (address_line_1, city, country, user_id) VALUES ('238 Vikings Ave', 'Minneapolis', 'USA', @userId1);
INSERT INTO address (address_line_1, city, country, user_id) VALUES ('723 Beach Ln', 'Miami', 'USA', @userId2);

-- DECLARE @address1 INT, @address2 INT;
SET @address1 = NULL;
SET @address2 = NULL;


SELECT id INTO @address1 FROM address WHERE user_id = @userId1 ORDER BY id DESC LIMIT 1;
SELECT id INTO @address2 FROM address WHERE user_id = @userId2 ORDER BY id DESC LIMIT 1;


INSERT INTO book_order (address_id, user_id) VALUES (@address1, @userId1);
INSERT INTO book_order (address_id, user_id) VALUES (@address1, @userId1);
INSERT INTO book_order (address_id, user_id) VALUES (@address1, @userId1);
INSERT INTO book_order (address_id, user_id) VALUES (@address2, @userId2);
INSERT INTO book_order (address_id, user_id) VALUES (@address2, @userId2);

-- DECLARE @order1 INT, @order2 INT, @order3 INT, @order4 INT, @order5 INT;
SET @order1 = NULL;
SET @order2 = NULL;
SET @order3 = NULL;
SET @order4 = NULL;
SET @order5 = NULL;


SELECT id INTO @order1 FROM book_order WHERE address_id = @address1 AND user_id = @userId1 ORDER BY id DESC LIMIT 1;
-- SELECT id INTO @order2 FROM book_order WHERE address_id = @address1 AND user_id = @userId1 ORDER BY id DESC OFFSET 1 ROW FETCH FIRST 1 ROW ONLY;

SELECT id INTO @order2 FROM book_order WHERE address_id = @address1 AND user_id = @userId1 ORDER BY id DESC LIMIT 1 OFFSET 1;


-- SELECT id INTO @order3 FROM book_order WHERE address_id = @address1 AND user_id = @userId1 ORDER BY id DESC OFFSET 2 ROW FETCH FIRST 1 ROW ONLY;

SELECT id INTO @order3
FROM book_order
WHERE address_id = @address1 AND user_id = @userId1
ORDER BY id DESC
LIMIT 2, 1;


SELECT id INTO @order4 FROM book_order WHERE address_id = @address2 AND user_id = @userId2 ORDER BY id DESC LIMIT 1;
-- SELECT id INTO @order5 FROM book_order WHERE address_id = @address2 AND user_id = @userId2 ORDER BY id DESC OFFSET 1 ROW FETCH FIRST 1 ROW ONLY;

SELECT id INTO @order5
FROM book_order
WHERE address_id = @address2 AND user_id = @userId2
ORDER BY id DESC
LIMIT 1 OFFSET 1;



INSERT INTO book_order_quantities (order_id, book_id, quantity) VALUES (@order1, @book1, 5);
INSERT INTO book_order_quantities (order_id, book_id, quantity) VALUES (@order1, @book2, 5);
INSERT INTO book_order_quantities (order_id, book_id, quantity) VALUES (@order2, @book3, 5);
INSERT INTO book_order_quantities (order_id, book_id, quantity) VALUES (@order2, @book2, 5);
INSERT INTO book_order_quantities (order_id, book_id, quantity) VALUES (@order2, @book5, 5);
INSERT INTO book_order_quantities (order_id, book_id, quantity) VALUES (@order3, @book3, 5);
INSERT INTO book_order_quantities (order_id, book_id, quantity) VALUES (@order4, @book4, 5);
INSERT INTO book_order_quantities (order_id, book_id, quantity) VALUES (@order4, @book2, 5);
INSERT INTO book_order_quantities (order_id, book_id, quantity) VALUES (@order5, @book3, 5);
INSERT INTO book_order_quantities (order_id, book_id, quantity) VALUES (@order5, @book1, 5);

SELECT * FROM book;
SELECT * FROM inventory;
SELECT * FROM address;
SELECT * FROM book_order;
SELECT * FROM book_order_quantities;
