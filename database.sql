create database foodappDB;

create table address (address_id integer not null, area varchar(255) not null, city varchar(255) not null, country varchar(255) not null, pin_code integer not null, state varchar(255) not null, primary key (address_id)) engine=InnoDB

create table cart (cart_id bigint not null, customer_customer_id bigint, primary key (cart_id)) engine=InnoDB

create table cart_item_list (cart_cart_id bigint not null, item_list_item_id bigint not null) engine=InnoDB

create table customers (customer_id bigint not null, email_id varchar(255), customer_name varchar(255) not null, contact_no bigint, address_address_id integer, cart_cart_id bigint, primary key (customer_id)) engine=InnoDB

create table hibernate_sequence (next_val bigint) engine=InnoDB

insert into hibernate_sequence values ( 1 )

create table items (item_id bigint not null, availability bit not null, description varchar(255) not null, item_name varchar(255) not null, price double precision not null, quantity integer, primary key (item_id)) engine=InnoDB

create table log_in_model (user_id integer not null, password varchar(255), user_name varchar(255), primary key (user_id)) engine=InnoDB

create table orders (order_id bigint not null, order_date date not null, cart_cart_id bigint, primary key (order_id)) engine=InnoDB

create table payment (payment_id integer not null, payment_date date, total_cost double precision not null, total_item integer, order_order_id bigint, primary key (payment_id)) engine=InnoDB

create table ratings (rating integer not null, customer_customer_id bigint, restaurant_restaurant_id bigint, primary key (rating)) engine=InnoDB

create table restaurant (restaurant_id bigint not null, cuisine_type varchar(255), location varchar(255), restaurant_name varchar(255), address_id integer, primary key (restaurant_id)) engine=InnoDB

create table restaurant_item_list (restaurants_restaurant_id bigint not null, item_list_item_id bigint not null) engine=InnoDB

create table users (user_id integer not null, email varchar(255) not null, mobile_no varchar(255) not null, password varchar(255) not null, user_name varchar(255) not null, primary key (user_id)) engine=InnoDB

create table user_session (id integer not null, uuid varchar(255), time_stamp datetime(6), user_id integer, primary key (id)) engine=InnoDB

alter table address drop index UK_jsgalw0tcrqp9cpf3ayn9u50r

alter table address add constraint UK_jsgalw0tcrqp9cpf3ayn9u50r unique (pin_code)

alter table cart_item_list drop index UK_xi48elt4nr73yp704fkh32jh

alter table cart_item_list add constraint UK_xi48elt4nr73yp704fkh32jh unique (item_list_item_id)

alter table restaurant_item_list drop index UK_32637n6wkexst54qmtev6w4wu

alter table restaurant_item_list add constraint UK_32637n6wkexst54qmtev6w4wu unique (item_list_item_id)

alter table user_session add constraint UK_p9ixbu6uq0wk83xq3823cpbom unique (user_id)

 alter table cart add constraint FKmdownx8ttpkqg2dusu0p77ugd foreign key (customer_customer_id) references customers (customer_id)

 alter table cart_item_list add constraint FKalfet73ix4mvlp5j0odju65ge foreign key (item_list_item_id) references items (item_id)

alter table cart_item_list add constraint FK6j4m0i51v559xj6b5knt99vt8 foreign key (cart_cart_id) references cart (cart_id)

 alter table customers add constraint FKbsdkm11yv6y4vn3a6cl8fccbn foreign key (address_address_id) references address (address_id)

alter table customers add constraint FKnh1dyje1m8d49iuc7y2vdsau foreign key (cart_cart_id) references cart (cart_id)

alter table orders add constraint FKtg32cl8e1f2afe83we3bqrw2h foreign key (cart_cart_id) references cart (cart_id)

alter table payment add constraint FK4ps1dmmr2pq3s70gyodygkiwe foreign key (order_order_id) references orders (order_id)

 alter table ratings add constraint FK4wfchj85ifnnple1f7h42yig4 foreign key (customer_customer_id) references customers (customer_id)

 alter table ratings add constraint FK21r1qjmulk0cag9ja5w9vbrs3 foreign key (restaurant_restaurant_id) references restaurant (restaurant_id)

alter table restaurant add constraint FK96q13p1ptpewvus590a8o83xt foreign key (address_id) references address (address_id)

 alter table restaurant_item_list add constraint FKjqv246tv3lfxsngor8nyc4xdo foreign key (item_list_item_id) references items (item_id)

alter table restaurant_item_list add constraint FKdcv5oyx4t8xkkupk4wgvkx1a foreign key (restaurants_restaurant_id) references restaurant (restaurant_id)
