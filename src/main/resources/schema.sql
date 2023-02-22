CREATE TABLE IF NOT EXISTS books (
    id  INTEGER NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS borrowers (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    bookid BIGINT NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE borrowers
    ADD CONSTRAINT borrower_book_id
    FOREIGN KEY (bookid) REFERENCES books(id)