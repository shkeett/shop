CREATE SCHEMA IF NOT EXISTS fed;


--Category product
CREATE TABLE IF NOT EXISTS fed.product_category

(
    id            BIGSERIAL PRIMARY KEY,
    name_category VARCHAR(255) NOT NULL
);

INSERT INTO fed.product_category(name_category)
VALUES ('Бытовая техника'),
       ('Компьютерная техника'),
       ('ТЕЛЕВИЗОРЫ'),
       ('ТЕЛЕФОНЫ');

--Product
CREATE TABLE IF NOT EXISTS fed.product
(
    id          BIGSERIAL PRIMARY KEY,
    category_id BIGINT       NOT NULL,
    name        VARCHAR(255) NOT NULL,
    price       INTEGER,
    count       INTEGER
);


INSERT INTO fed.product(category_id, name, price, count)
VALUES (2, 'MAC BOOK', 1500, 8),
       (1, 'ХОЛОДИЛЬНИК', 550, 2),
       (2, 'ASUS LAPTOP', 800, 15),
       (1, 'ПЛИТА', 350, 7),
       (3, 'LG', 750, 4),
       (3, 'SONY', 1000, 1),
       (1, 'ТОСТЕР', 150, 9);