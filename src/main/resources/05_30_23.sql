CREATE SCHEMA IF NOT EXISTS fed;

--USER
CREATE TABLE IF NOT EXISTS fed.users
(
    id        BIGSERIAL PRIMARY KEY,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    email     varchar(255) not null,
    password  varchar(255),
    role     varchar(30) default 'user',
    status varchar(30) default 'active'
);

INSERT INTO fed.users(first_name, last_name, email, password, role, status)
VALUES ('IVAN', 'IVANOV', 'ivanov@yet.com', '$2a$12$wRxLalrd9ppUDNmUI8sEJezs3TAeBGvLb4EkNWTJhrSleQdcYlkLu', 'ADMIN', 'ACTIVE'),
       ('SERGIO', 'SERGIO', 'sergio@yet.com', '$2a$12$RtMWDIHS/a2jfbB7cZYaLeVt.FPPMVKk/SqtFDc8.rD8KYzdtGoBm', 'USER', 'ACTIVE'),
       ('FRED', 'FREDERISIO', 'fred@yet.com', '$2a$12$RtMWDIHS/a2jfbB7cZYaLeVt.FPPMVKk/SqtFDc8.rD8KYzdtGoBm', 'USER', 'BANNED');

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




