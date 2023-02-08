CREATE TABLE `products` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `product_title` varchar(45) NOT NULL,
  `product_coast` int NOT NULL,
  PRIMARY KEY (`product_id`)
);

insert into products (product_id,product_title,product_coast) values (38,"banana",56);
insert into products (product_id,product_title,product_coast) values (39,"apple",66);
insert into products (product_id,product_title,product_coast) values (41,"beef",378);
insert into products (product_id,product_title,product_coast) values (42,"potato",66);
insert into products (product_id,product_title,product_coast) values (43,"milk",56);

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);

create table users_roles (
user_id bigint not null,
role_id bigint not null,
primary key(user_id, role_id),
foreign key(user_id) references users(id),
foreign key(role_id) references roles(id)
);

CREATE TABLE `products_from_cart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint NOT NULL,
  `product_name` varchar(45) NOT NULL,
  `product_coast` int NOT NULL,
  PRIMARY KEY (`id`)
);

insert into users (username, password) values ('user2','$2a$12$Bcro0NaEtJNMwsIKjSOqy.6djA71hNHlospGHFVGZxnH5KhupNnl6');

INSERT INTO roles (name)
VALUES
('ROLE_USER'), ('ROLE_ADMIN');

insert into users_roles (user_id, role_id) values (2,1);
insert into users_roles (user_id, role_id) values (2,2);

CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `list_product` varchar(100) NOT NULL,
  `client_name` varchar(100) NOT NULL,
  `total_price` int NOT NULL,
  `address_client` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE users_products_from_cart (user_id_c BIGINT REFERENCES users (id),
product_id BIGINT REFERENCES products_from_cart (id));

ALTER TABLE users_products_from_cart ADD COLUMN id bigint primary key not null auto_increment;

CREATE TABLE users_orders (user_id BIGINT REFERENCES users (id),
order_id BIGINT REFERENCES orders (id));

ALTER TABLE users_orders ADD COLUMN id bigint primary key not null auto_increment;
