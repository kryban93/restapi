SET @bookOne = random_uuid();
SET @bookTwo = random_uuid();
SET @userOne = random_uuid();
INSERT INTO books (id,title,isbn,author) values (@bookOne,'W pustyni i w puszczy', '978-83-240-2959-4', 'Henryk Sienkiewicz');
INSERT INTO books (id,title,isbn,author) values (@bookTwo,'Władca Pierscieni', '978-83-287-0078-9', 'J.R.R. Tolkien');

INSERT INTO borrowers (id,name,lastname) values (@userOne,'Krystian', 'Sienkiewicz');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Michal','Tolkien');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Jaś', 'Muzykant');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Grześ','Wieś');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Łukasz', 'Szukasz');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Michal','Kichał');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Stasiu', 'Kwasiu');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Rafał','Czacza');

INSERT INTO borrows (borrowers_id,books_id) values ((SELECT b.id FROM borrowers b WHERE b.lastname='Sienkiewicz'),@bookOne);
INSERT INTO borrows (borrowers_id,books_id) values (@userOne,@bookTwo);

--INSERT INTO books (id,title,isbn,author) values (1,'W pustyni i w puszczy', '978-83-240-2959-4', 'Henryk Sienkiewicz');
--INSERT INTO books (id,title,isbn,author) values (2,'Władca Pierscieni', '978-83-287-0078-9', 'J.R.R. Tolkien');
--
--INSERT INTO borrowers (id,name,lastname,bookid) values (1,'Krystian', 'Sienkiewicz',1);
--INSERT INTO borrowers (id,name,lastname,bookid) values (2,'Michal','Tolkien',2);