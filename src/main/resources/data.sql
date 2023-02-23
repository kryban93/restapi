INSERT INTO books (id,title,isbn,author) values (random_uuid(),'W pustyni i w puszczy', '978-83-240-2959-4', 'Henryk Sienkiewicz');
INSERT INTO books (id,title,isbn,author) values (random_uuid(),'Władca Pierscieni', '978-83-287-0078-9', 'J.R.R. Tolkien');

INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Krystian', 'Sienkiewicz');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Michal','Tolkien');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Jaś', 'Muzykant');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Grześ','Wieś');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Łukasz', 'Szukasz');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Michal','Kichał');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Stasiu', 'Kwasiu');
INSERT INTO borrowers (id,name,lastname) values (random_uuid(),'Rafał','Czacza');

--INSERT INTO borrows (borrowers_id,books_id) values (1,1);

--INSERT INTO books (id,title,isbn,author) values (1,'W pustyni i w puszczy', '978-83-240-2959-4', 'Henryk Sienkiewicz');
--INSERT INTO books (id,title,isbn,author) values (2,'Władca Pierscieni', '978-83-287-0078-9', 'J.R.R. Tolkien');
--
--INSERT INTO borrowers (id,name,lastname,bookid) values (1,'Krystian', 'Sienkiewicz',1);
--INSERT INTO borrowers (id,name,lastname,bookid) values (2,'Michal','Tolkien',2);